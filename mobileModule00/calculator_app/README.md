# 🧮 Exercise 03 — It’s Alive! (Calculator Logic)

## 🎯 Objective

In this final exercise of **Module 00** from the *Piscine Mobile - Kotlin Multiplatform (KMP)* series, we will make the calculator fully functional by adding the **mathematical logic** behind the UI created in the previous exercise.

This project brings together everything we have learned so far — UI layout, user interaction, state management, and now, the ability to **parse and evaluate mathematical expressions**.

---

## 🧠 What You’ll Learn

By the end of this exercise, you will understand how to:

- Implement logical computation inside a shared Kotlin module.
- Parse arithmetic expressions with custom logic (tokenization, precedence, and evaluation).
- Manage UI events and state updates in a Compose-based UI.
- Separate UI (Compose) from business logic (Kotlin shared code).
- Gracefully handle user errors (invalid expressions, division by zero, etc.).

---

## 🧩 Code Overview

### 🔹 UI Component

The button handling logic connects the **user interface** with the **expression evaluator**:

```kotlin
Text(
    text = button,
    modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .clickable(enabled = button.isNotEmpty()) {
            Log.i("I/Kotlin", "Button pressed :$button")
            if (button == "=") {
                result = calculateExpression(expression)
            } else if (button == "C") {
                expression = expression.dropLast(1)
                if (expression == "")
                    expression = "0"
            } else if (button == "AC") {
                expression = "0"
                result = "0"
            } else {
                if (expression != "0")
                    expression += button
                else
                    expression = button
            }
        }
        .weight(1f),
    textAlign = TextAlign.Center,
    color = if (buttonIndex < buttons.size - 1)
        Color(0xFF25414a)
    else if (rowIndex == 0)
        (Color.Red.copy(alpha = 0.5F))
    else
        Color.White
)
```

Each button press modifies the **expression state** or triggers an action (like clearing or evaluating).

---

### 🔹 Core Logic — `calculateExpression()`

This function, placed in the `commonMain` module (`calculator` package), performs the core math operations.

It follows **three main steps:**

1. **Tokenization** – Break the string into numbers and operators.
2. **Infix to Postfix (RPN)** – Reorder based on operator precedence.
3. **Evaluation** – Compute the result using a stack-based approach.

```kotlin
fun calculateExpression(expression: String): String {
    if (expression.isBlank()) return "0"

    return try {
        val tokens = tokenize(expression)
        val rpn = infixToRPN(tokens)
        val result = evaluateRPN(rpn)
        result.toString()
    } catch (e: Exception) {
        Log.d("calculateExpression", e.toString())
        "Error"
    }
}
```

---

### 🔹 Tokenization

The expression (e.g. `"59-89+-20/6"`) is split into **tokens** like `[59, -, 89, +, -20, /, 6]`.  
This step ensures that negative numbers and decimals are correctly identified.

---

### 🔹 Infix to Postfix Conversion

To correctly apply **operator precedence** (`*` and `/` before `+` and `-`), we convert the token list into **Reverse Polish Notation (RPN)** using a stack algorithm.

Example:  
Input → `["1", "+", "2", "*", "3"]`  
Output (RPN) → `["1", "2", "3", "*", "+"]`

---

### 🔹 Evaluation of RPN

Finally, we compute the RPN expression using another stack.  
Each number is pushed to the stack, and when an operator is found, two numbers are popped and evaluated.

Example:  
`["1", "2", "3", "*", "+"]` → `1 + (2 * 3)` → `7`

---

## ⚙️ Error Handling

- Empty expressions return `"0"`.
- Invalid syntax or division by zero returns `"Error"`.
- All exceptions are safely caught — **the app must never crash**.

---

## 📚 Review — What We Learned in Module 00

| Exercise | Concept | Description |
|-----------|----------|-------------|
| **00 — A Basic Display** | UI Setup | Learned how to create a simple Compose UI with Text and Button. |
| **01 — Say Hello to the World** | State Management | Introduced `remember` and `mutableStateOf` for managing reactive UI updates. |
| **02 — More Buttons** | Layout and Interactions | Built a structured calculator layout using `Column`, `Row`, and `forEachIndexed`. |
| **03 — It’s Alive!** | Business Logic | Integrated real computation logic and linked it with UI actions. |

By completing this module, you now understand the **core principles of Kotlin Multiplatform and Jetpack Compose**:

- How **UI and business logic** can be separated.
- How **state and events** flow through Compose UIs.
- How **KMP enables shared code** between Android, iOS, and Web/Desktop targets.
- How to build **robust, testable, and crash-resistant** apps.

---

## 🏁 Next Steps

In the next modules, you’ll deepen your understanding of:

- Advanced state management (`ViewModel`, `StateFlow`)
- Navigation between screens
- Networking and data persistence
- Platform integrations

> 💡 Congratulations! You now have your first **fully functional multiplatform app** — built with Compose and Kotlin logic, from the ground up.
