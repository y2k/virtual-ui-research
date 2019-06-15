package y2k.android

import android.os.Bundle
import android.view.Gravity
import android.view.View.OnClickListener
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import y2k.android.TodoListComponent.Model
import y2k.android.TodoListComponent.Msg
import y2k.tea.*
import y2k.virtual.ui.*
import y2k.virtual.ui.common.editableView
import y2k.virtual.ui.common.fillHorizontal
import y2k.virtual.ui.remote.HotReloadServer
import java.io.Closeable

object TodoListComponent : TeaComponent<Model, Msg> {

    data class Model(val todos: List<String>, val text: String)

    sealed class Msg {
        object Add : Msg()
        object DeleteAll : Msg()
        class Delete(val title: String) : Msg()
        class Changed(val text: CharSequence) : Msg()
    }

    override fun initialize(): Pair<Model, Cmd<Msg>> = Model(emptyList(), "") to Cmd.none()

    override fun update(model: Model, msg: Msg): Pair<Model, Cmd<Msg>> =
        when (msg) {
            is Msg.Add -> model.copy(todos = model.todos + model.text, text = "")
            is Msg.DeleteAll -> model.copy(todos = emptyList())
            is Msg.Delete -> model.copy(todos = model.todos.filterNot { it == msg.title })
            is Msg.Changed -> model.copy(text = "" + msg.text)
        } to Cmd.none()

    fun view(model: Model, dispatch: (Msg) -> Unit): VirtualNode =
        linearLayout {
            orientation = LinearLayout.VERTICAL
            padding = Quadruple(20, 20, 20, 20)

            editableView {
                onTextChanged = { dispatch(Msg.Changed(it)) }
                text = model.text

                appCompatEditText {
                    hintCharSequence = "Enter text..."
                }
            }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.END

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

            scrollView {
                linearLayout {
                    orientation = LinearLayout.VERTICAL

                    model.todos.forEach { item ->
                        viewItem(item, dispatch)
                    }
                }
            }
        }

    private fun viewItem(title: String, dispatch: (Msg) -> Unit): VirtualNode =
        linearLayout {
            orientation = LinearLayout.HORIZONTAL

            fillHorizontal {
                appCompatTextView {
                    textCharSequence = title
                }
            }
            appCompatButton {
                textCharSequence = "Delete"
                onClickListener = OnClickListener { dispatch(Msg.Delete(title)) }
            }
        }

    override fun sub(): Sub<Msg> = Sub.empty()

    class Activity : AppCompatActivity(), TeaView<Model> {

        private lateinit var virtualHostView: VirtualHostView
        private lateinit var server: Closeable

        private val runtime = TeaRuntime(TodoListComponent, this, { }, true)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            virtualHostView = VirtualHostView(this)
            setContentView(virtualHostView)
        }

        override fun view(model: Model) {
            virtualHostView.update { view(model, runtime::dispatch) }
        }

        override fun onStart() {
            super.onStart()
            runtime.attach()
            server = HotReloadServer.start(virtualHostView)
        }

        override fun onStop() {
            super.onStop()
            runtime.detach()
            server.close()
        }
    }
}
