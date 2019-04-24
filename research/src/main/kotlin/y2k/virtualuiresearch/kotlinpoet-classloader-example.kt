package y2k.virtualuiresearch

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import y2k.virtualuiresearch.common.isOverrided
import y2k.virtualuiresearch.common.loadAllClassesFromJar
import java.io.File
import java.lang.Deprecated
import java.lang.reflect.Modifier
import java.net.URLClassLoader
import kotlin.Array
import kotlin.String
import kotlin.Suppress

fun main(args: Array<String>) {
    println(
        execute(
            null,
            if (args.size < 2) null else args.first(),
            args.last(),
            args
        )
    )
}

fun execute(rootPackage: String?, libPath: String?, androidJar: String, jarPathes: Array<String>): String {
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
        .map { mkComponent(it, groupClass) }
        .forEach {
            fileSpec.addFunction(createTypeDsl(it.type, it.group))
            fileSpec.addType(createType(it))
        }

    return fileSpec.build().toString()
}

private fun mkComponent(clazz: Class<*>, groupClass: Class<*>): ComponentDesc {
    val typeBound = clazz.typeParameters.firstOrNull()?.bounds?.firstOrNull()?.asTypeName()
    val type =
        if (typeBound != null) {
            clazz.asClassName().parameterizedBy(typeBound)
        } else {
            clazz.asClassName()
        }

    return ComponentDesc(
        type,
        clazz.superclass.asClassName(),
        getProperties(clazz),
        groupClass.isAssignableFrom(clazz),
        Modifier.isAbstract(clazz.modifiers),
        typeBound
    )
}

private fun getProperties(clazz: Class<*>): List<PropertyDescription> {
    val methods = clazz
        .declaredMethods
        .filter {
            it.name.matches(Regex("set[A-Z].+"))
                && it.parameterCount == 1
                && Modifier.isPublic(it.modifiers)
                && !Modifier.isStatic(it.modifiers)
                && !it.isAnnotationPresent(Deprecated::class.java)
                && !it.isOverrided()
        }
    return methods
        .map { m ->
            PropertyDescription(
                m.name,
                m.parameters[0].type.asTypeName(),
                methods.count { it.name == m.name } > 1
            )
        }
}
