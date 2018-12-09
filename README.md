# Reconciliation алгоритм

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
