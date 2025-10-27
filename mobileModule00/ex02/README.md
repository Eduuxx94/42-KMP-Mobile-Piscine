# Exercise 02 - More Buttons

## Overview
In this exercise, you will expand your calculator project by adding a more complete **UI layout** using **Jetpack Compose Multiplatform (KMP)**.  
This exercise focuses on creating a clean and interactive **button grid** with a top bar and placeholders for the expression and result.

Unlike the previous step, this one introduces **dynamic layouts** with loops, **click handling**, and **layout organization** using Compose's declarative approach.

---

## 🧱 Code Structure

### 1. Material Theme and Layout
The entire app is wrapped in a `MaterialTheme`, which provides consistent UI styling across Android, iOS, and Desktop.

```kotlin
MaterialTheme {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25414a))
    ) {
        // AppBar
        // Display Area
        // Buttons Grid
    }
}
```

- `Column`: vertically arranges the children.
- `Modifier.fillMaxSize()`: expands the layout to fit the whole screen.
- `Modifier.background(Color(...))`: defines the main background color.

---

## 🧮 TopAppBar and Display Section

The **TopAppBar** defines a simple header with the title `"Calculator"`:

```kotlin
TopAppBar(
    title = {
        Box(Modifier.fillMaxWidth(), Alignment.Center) {
            Text("Calculator", color = Color.White)
        }
    },
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color(0XFF528ba3),
    ),
)
```

Below it, a **display area** shows placeholders for the expression and result:

```kotlin
Column(
    Modifier.fillMaxWidth()
        .fillMaxHeight(0.45f)
        .padding(8.dp),
    horizontalAlignment = Alignment.End
) {
    Text("0", color = Color(0XFF528ba3), fontSize = 24.sp)
    Text("0", color = Color(0XFF528ba3), fontSize = 24.sp)
}
```

These will later be updated to show the user’s current input and result dynamically.

---

## 🔘 Buttons and Layout Grid

The calculator’s buttons are stored in a list of lists:

```kotlin
val buttons = listOf(
    listOf("7", "8", "9", "C", "AC"),
    listOf("4", "5", "6", "+", "-"),
    listOf("1", "2", "3", "*", "/"),
    listOf("0", ".", "00", "=", ""),
)
```

This makes it easy to loop through rows and create a structured grid dynamically.

### `forEachIndexed`

We use `forEachIndexed` to iterate through both **rows** and **columns**:

```kotlin
buttons.forEachIndexed { rowIndex, row ->
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        row.forEachIndexed { buttonIndex, button ->
            Text(
                text = button,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable(enabled = button.isNotEmpty()) {
                        Log.i("I/Kotlin", "Button pressed: $button")
                    }
                    .weight(1f),
                textAlign = TextAlign.Center,
                color =
                    if (buttonIndex < buttons.size - 1)
                        Color(0xFF25414a)
                    else if (rowIndex == 0)
                        Color.Red.copy(alpha = 0.5F)
                    else
                        Color.White
            )
        }
    }
}
```

### Key points:
- **`forEachIndexed`** gives both the index and value → useful for grid logic.
- **`clip(RoundedCornerShape(12.dp))`** → rounds the button corners.
- **`clickable`** → makes each `Text` element interactive.
- **`weight(1f)`** → ensures all buttons share equal width.
- **`Log.i`** → outputs which button was pressed to the debug console.

---

## 🧩 BottomAppBar

A small `BottomAppBar` is added for balance and potential expansion:
```kotlin
BottomAppBar(modifier = Modifier.height(24.dp), containerColor = Color.Transparent) {}
```
Currently, it serves a visual purpose only.

---

## 🧠 Key Takeaways

- **`forEachIndexed`** enables dynamic UI generation.
- **Modifiers** control layout, color, padding, shape, and clickability.
- **Jetpack Compose** declaratively describes the interface: the UI automatically updates based on state or logic.
- The layout is **responsive**, adapting to screen orientation and size.
- This structure prepares the project for adding real calculation logic in the next exercise.

---

✅ **Next Step:**  
You will now implement the logic to evaluate mathematical expressions and update the display fields dynamically.
