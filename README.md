# Пример компонента

#### Описание компонента в стиле _The Elm Architecture_

```kotlin
object TodoListComponent : TeaComponent<Msg, Model> {

    data class Model(val todos: List<String>, val text: String)

    sealed class Msg {
        object Add : Msg()
        object DeleteAll : Msg()
        class Delete(val title: String) : Msg()
    }

    override val init = Model(emptyList(), "")

    override fun update(model: Model, msg: Msg): Model =
        when (msg) {
            is Msg.Add -> model.copy(todos = model.todos + model.text)
            is Msg.DeleteAll -> model.copy(todos = emptyList())
            is Msg.Delete -> model.copy(todos = model.todos.filterNot { it != msg.title })
        }

    override fun view(model: Model, dispatch: (Msg) -> Unit): VirtualNode =
        border(all = 20) {
            linearLayout {
                orientation = LinearLayout.VERTICAL

                appCompatEditText {
                    hintCharSequence = "Enter text..."
                }

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.END

                    appCompatButton {
                        textCharSequence = "Add item"
                        onClickListener = OnClickListener { dispatch(Msg.Add) }
                    }
                    appCompatButton {
                        textCharSequence = "Clear all"
                        onClickListener = OnClickListener { dispatch(Msg.DeleteAll) }
                    }
                }

                model.todos.forEach { item ->
                    viewItem(item, dispatch)
                }
            }
        }

    private fun viewItem(title: String, dispatch: (Msg) -> Unit) {
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
    }
}
```

#### Активити для запуска

```kotlin
class TodoListActivity : AppCompatActivity() {

    private lateinit var root: VirtualHostView
    private lateinit var server: Closeable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = VirtualHostView(this).also(::setContentView)

        SimpleTea.run(root, TodoListComponent)
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
```

#### JUnit тест для запуска hot-reload

```kotlin
class HotReloadRunners {

    @Test
    fun `run TodoList`() {
        val model = TodoListComponent.init.copy(todos = List(5) { "Item #$it" })

        runInRemote {
            val virtualNode = TodoListComponent.view(model) {}
            HotReloadClient.send(virtualNode)
        }
    }
}
```

# Исследования Reconciliation алгоритма

### Первое построение View

```json
{
  "@class": "LinearLayout",
  "children": [
    {
      "@class": "TextView",
      "textColor_": -65536,
      "text_": "1) Hello World",
      "textSize_": 0.0,
      "backgroundColor_": 0
    },
    {
      "@class": "TextView",
      "textColor_": -16711936,
      "text_": "2) Moscow",
      "textSize_": 0.0,
      "backgroundColor_": 0
    }
  ],
  "backgroundColor_": -3355444
}
```

Реальные изменения View

```
LOG: LinearLayout.setBackgroundColor(-3355444)
LOG: LinearLayout.addView(::TextView)
LOG: TextView.setText("1) Hello World")
LOG: TextView.setTextSize(0.0)
LOG: TextView.setTextColor(-65536)
LOG: LinearLayout.addView(::TextView)
LOG: TextView.setText("2) Moscow")
LOG: TextView.setTextSize(0.0)
LOG: TextView.setTextColor(-16711936)
```

### Новый виртуальный-view

```json
{
  "@class": "LinearLayout",
  "children": [
    {
      "@class": "TextView",
      "textColor_": -65536,
      "text_": "1.1) Hello World",
      "textSize_": 0.0,
      "backgroundColor_": 0
    }
  ],
  "backgroundColor_": -3355444
}
```

Реальные изменения View

```
LOG: TextView.setText("1.1) Hello World")
LOG: LinearLayout.removeViewAt(1)
```

# Пример DSL

```kotlin
fun view(counter: String, onUp: () -> Unit, onDown: () -> Unit) =
    linearLayout {
        backgroundColor = Color.WHITE
        orientation = LinearLayout.VERTICAL

        h1("Increase / Decrease example")

        counterButton("+", onUp)

        h1(counter)

        counterButton("-", onDown)
    }

private fun counterButton(title: String, e: () -> Unit) =
    button {
        padding = floatArrayOf(4f)
        backgroundDrawableRes = R.drawable.button_bg
        textColor = Color.BLUE
        textSize = 18f
        text = title
        onPressed = e
    }

private fun h1(title: String) =
    textView {
        padding = floatArrayOf(4f)
        backgroundDrawableRes = R.drawable.textview_bg
        textColor = Color.GRAY
        textSize = 20f
        text = title
    }
```
