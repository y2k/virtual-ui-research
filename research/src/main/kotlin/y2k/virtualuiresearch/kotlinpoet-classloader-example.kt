package y2k.virtualuiresearch

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import y2k.virtualuiresearch.asm.ClassRecord
import y2k.virtualuiresearch.common.asGenTypeName
import y2k.virtualuiresearch.common.isOverrided
import y2k.virtualuiresearch.common.loadAllClassesFromJar
import java.io.File
import java.lang.Deprecated
import java.lang.reflect.Modifier
import java.net.URLClassLoader
import kotlin.Array
import kotlin.Pair
import kotlin.String
import kotlin.Suppress

fun execute(
    rootPackage: String?,
    libPath: String?,
    androidJar: String,
    jarPathes: Array<String>,
    nonNullMethods: Set<ClassRecord>
): String {
    val jars = jarPathes.map { File(it).toURI().toURL() }.toTypedArray()

    val loader = URLClassLoader(jars, ClassLoader.getSystemClassLoader())

    val libClasses =
        if (libPath == null) emptyList()
        else loadAllClassesFromJar(File(libPath), loader)

    val androidClasses = loadAllClassesFromJar(File(androidJar), loader)

    val viewClass = androidClasses.first { it.name == "android.view.View" }
    val groupClass = androidClasses.first { it.name == "android.view.ViewGroup" }

    val fileSpec = FileSpec.builder(libraryPackage, "dsl")

    fileSpec
        .addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember("\"unused\"")
                .addMember("\"ClassName\"")
                .addMember("\"NewApi\"")
                .addMember("\"RestrictedApi\"")
                .addMember("\"UsePropertyAccessSyntax\"")
                .build()
        )

    (libClasses + androidClasses)
        .asSequence()
        .filter {
            it.name !in listOf(
                "android.webkit.WebView",
                "android.widget.AutoCompleteTextView",
                "android.widget.MultiAutoCompleteTextView",
                "android.widget.TimePicker",
                "android.widget.AnalogClock",
                "android.inputmethodservice.ExtractEditText",
                "android.inputmethodservice.KeyboardView",
                "android.appwidget.AppWidgetHostView",
                "android.opengl.GLSurfaceView",
                // Replaced by AppCompat
                "android.widget.SearchView",
                "android.widget.Toolbar",

                // Restrict
                "androidx.appcompat.widget.ActionBarContextView",
                "androidx.appcompat.widget.ActionBarContainer",
                "androidx.appcompat.widget.ActionBarOverlayLayout",
                "androidx.appcompat.widget.ActivityChooserView",
                "androidx.appcompat.widget.ButtonBarLayout",
                "androidx.appcompat.widget.ContentFrameLayout",
                "androidx.appcompat.widget.ScrollingTabContainerView",
                "androidx.appcompat.widget.AlertDialogLayout",
                "androidx.appcompat.widget.DialogTitle",
                "androidx.appcompat.widget.FitWindowsFrameLayout",
                "androidx.appcompat.widget.FitWindowsLinearLayout",
                //
                "androidx.appcompat.widget.AppCompatAutoCompleteTextView",
                "androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView",
                "androidx.appcompat.widget.ActionMenuView"
            )
        }
        .filter { if (rootPackage == null) true else it.name.startsWith(rootPackage) }
        .filter { clazz ->
            viewClass.isAssignableFrom(clazz) &&
                !clazz.isAnnotationPresent(Deprecated::class.java) &&
                !clazz.isMemberClass &&
                clazz.constructors.any { it.parameterCount == 1 }
        }
        .sortedBy { it.name }
        .map { mkComponent(it, groupClass) }
        .forEach {
            if (!it.isAbstract)
                fileSpec.addFunction(createTypeDsl(it.type, it.group))
            fileSpec.addType(createType(it, nonNullMethods))
        }

    return fileSpec.build().toString()
}

private fun mkComponent(clazz: Class<*>, groupClass: Class<*>): ComponentDesc {
    fun extractTypeName(clazz: Class<*>): Pair<TypeName?, TypeName> {
        val typeBound = clazz.typeParameters.firstOrNull()?.bounds?.firstOrNull()?.asTypeName()
        val type =
            if (typeBound != null) clazz.asClassName().parameterizedBy(typeBound)
            else clazz.asClassName()
        return Pair(typeBound, type)
    }

    val (typeBound, type) = extractTypeName(clazz)
    val parentType = clazz.genericSuperclass.asTypeName()

    return ComponentDesc(
        type,
        parentType,
        getProperties(clazz),
        groupClass.isAssignableFrom(clazz),
        Modifier.isAbstract(clazz.modifiers),
        typeBound)
}

private fun getProperties(clazz: Class<*>): List<PropertyDescription> {
    val methods = clazz
        .declaredMethods
        .filter {
            it.name.matches(Regex("set[A-Z].+"))
                && (it.parameterCount == 1 || (it.parameterCount in 2..4 && it.parameterTypes.all { it.isPrimitive }))
                && Modifier.isPublic(it.modifiers)
                && !Modifier.isStatic(it.modifiers)
                && !it.isAnnotationPresent(Deprecated::class.java)
                && !it.isOverrided()
        }
        .sortedBy { it.name }

    return methods.map { m ->
        PropertyDescription(
            m.name,
            m.parameters.map { it.asGenTypeName() },
            methods.count { it.name == m.name } > 1)
    }
}
