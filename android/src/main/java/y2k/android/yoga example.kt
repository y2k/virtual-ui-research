package y2k.android

import android.os.Bundle
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.facebook.yoga.YogaFlexDirection
import com.facebook.yoga.YogaJustify
import y2k.android.YogaExampleComponent.Model
import y2k.android.YogaExampleComponent.Msg
import y2k.virtual.ui.*
import y2k.virtual.ui.common.editableView
import y2k.virtual.ui.remote.HotReloadServer
import y2k.virtual.ui.tea.SimpleTea
import y2k.virtual.ui.tea.TeaComponent
import y2k.virtual.ui.yoga.flexDirection
import y2k.virtual.ui.yoga.flexGrow
import y2k.virtual.ui.yoga.justifyContent
import java.io.Closeable

object YogaExampleComponent : TeaComponent<Msg, Model> {

    data class Model(val todos: List<String>, val text: String)

    sealed class Msg {
        object Add : Msg()
        object DeleteAll : Msg()
        class Delete(val title: String) : Msg()
        class Changed(val text: CharSequence) : Msg()
    }

    override val init = Model(emptyList(), "")

    override fun update(model: Model, msg: Msg): Model =
        when (msg) {
            is Msg.Add -> model.copy(todos = model.todos + model.text, text = "")
            is Msg.DeleteAll -> model.copy(todos = emptyList())
            is Msg.Delete -> model.copy(todos = model.todos.filterNot { it == msg.title })
            is Msg.Changed -> model.copy(text = "" + msg.text)
        }

    override fun view(model: Model, dispatch: (Msg) -> Unit): VirtualNode =
        yogaLayout {
            flexDirection = YogaFlexDirection.COLUMN

            editableView {
                onTextChanged = { dispatch(Msg.Changed(it)) }
                text = model.text

                appCompatEditText {
                    hintCharSequence = "Enter text..."
                }
            }

            yogaLayout {
                flexDirection = YogaFlexDirection.ROW
                justifyContent = YogaJustify.FLEX_END

                appCompatButton {
                    enabled = model.text.isNotBlank()
                    textCharSequence = "Add item"
                    onClickListener = OnClickListener { dispatch(Msg.Add) }
                }
                appCompatButton {
                    enabled = model.todos.isNotEmpty()
                    textCharSequence = "Clear all"
                    onClickListener = OnClickListener { dispatch(Msg.DeleteAll) }
                }
            }

            model.todos.forEach { item ->
                viewItem(item, dispatch)
            }
        }

    private fun viewItem(title: String, dispatch: (Msg) -> Unit): VirtualNode =
        yogaLayout {
            flexDirection = YogaFlexDirection.ROW

            yogaLayout {
                flexGrow = 1f
                appCompatTextView {
                    textCharSequence = title
                }
            }
            appCompatButton {
                textCharSequence = "Delete"
                onClickListener = OnClickListener { dispatch(Msg.Delete(title)) }
            }
        }

    class Activity : AppCompatActivity() {

        private lateinit var root: VirtualHostView
        private lateinit var server: Closeable

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            root = VirtualHostView(this).also(::setContentView)

            SimpleTea.run(root, YogaExampleComponent)
        }

        override fun onResume() {
            super.onResume()
            server = HotReloadServer.start(root)
        }

        override fun onPause() {
            super.onPause()
            server.close()
        }
    }
}
