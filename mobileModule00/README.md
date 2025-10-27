# Module00 — Introduction to Mobile Development

This repository contains the implementation of **Module00** from the **42 Piscine Mobile** program.  
All exercises in this module are developed using **Kotlin Multiplatform (KMP)** with **Jetpack Compose Multiplatform**.

---

## 📘 Table of Contents

- [I. Instructions](#i-instructions)
- [II. Introduction](#ii-introduction)
  - [II.1 What is a mobile application?](#ii1-what-is-a-mobile-application)
  - [II.2 What is Kotlin Multiplatform (KMP)?](#ii2-what-is-kotlin-multiplatform-kmp)
  - [II.3 Why I chose Kotlin Multiplatform](#ii3-why-i-chose-kotlin-multiplatform)
- [III. Exercise 00: A Basic Display](#iii-exercise-00-a-basic-display)
- [IV. Exercise 01: Say Hello to the World](#iv-exercise-01-say-hello-to-the-world)
- [V. Exercise 02: More Buttons](#v-exercise-02-more-buttons)
- [VI. Exercise 03: It’s Alive!](#vi-exercise-03-its-alive)
- [VII. Submission and Peer-Evaluation](#vii-submission-and-peer-evaluation)

---

## I. Instructions

- Only this document serves as reference — **ignore external rumors**.
- Carefully read all requirements before starting.
- Exercises will be corrected by your peers.
- Screenshots and demos may contain extra elements not required for evaluation.
- When in doubt, **ask your peers** before coding.
- ⚡ *By Odin, by Thor!* Use your brain.

🕒 Intra defines the deadline for each repository. The peer-evaluation period starts immediately after submission and lasts exactly **24 hours**. Missing grades after this period are automatically set to **0**.

---

## II. Introduction

### II.1 What is a mobile application?

A **mobile application** is a software program designed to run on mobile devices such as smartphones, tablets, or PDAs.  
They can be pre-installed or delivered as web applications using server-side or client-side processing.

Mobile applications differ from desktop or web apps because they are designed for **native device environments**, often providing faster performance and deeper integration with system features.

### II.2 What is Kotlin Multiplatform (KMP)?

**Kotlin Multiplatform (KMP)** is a technology from **JetBrains** that enables developers to share code across multiple platforms — including Android, iOS, desktop, web, and even backend systems — while still writing **native UIs**.

It allows you to:
- **Write business logic once** (in Kotlin).
- **Reuse it across platforms**, avoiding duplication.
- Keep the **UI layers platform-specific**, ensuring a native look and feel.

**Key advantages:**
- ✅ **Code sharing efficiency:** Write core logic once for multiple targets (networking, database, models, etc.).
- ⚡ **Native performance:** Runs directly on the platform, not in a virtual machine or WebView.
- 🔄 **Full platform access:** You can call native APIs and libraries directly from Kotlin.
- 🔒 **Strong type safety:** Kotlin provides null-safety, immutability, and concise syntax for robust shared code.
- 🤝 **Seamless integration:** Works natively with Android Studio and Xcode.

---

### II.3 Why I chose Kotlin Multiplatform

I chose **Kotlin Multiplatform (KMP)** over other frameworks (like Flutter or React Native) because it provides the **best balance between code reuse and native control**.

While Flutter offers a unified UI and fast iteration, KMP allows me to:
- Use **native UI frameworks** (Jetpack Compose, SwiftUI) while still sharing business logic.
- Integrate more naturally into existing **native projects**.
- Maintain **long-term flexibility**, since KMP is based on **Kotlin**, a first-class language officially supported by Google for Android development.

In short, **KMP keeps the power of native apps** while reducing redundancy across platforms — making it ideal for scalable, professional mobile SDK development.

---

## III. Exercise 00: A Basic Display

**Turn-in directory:** `mobileModule00/ex00`  
**Forbidden functions:** None

### 🎯 Objective

Create a simple application with a single page containing:
- A **Text** widget.
- A **Button** positioned below it.
- Both centered **horizontally and vertically**.

When the button is clicked, log **“Button pressed”** in the console.  
Ensure the layout is **responsive** across screen sizes.

### 🧱 Implementation Steps

1. Create a new Kotlin Multiplatform project (`ex00`).
2. Setup a basic Compose `@Composable` screen.
3. Use a `Column` with `horizontalAlignment = Alignment.CenterHorizontally` and `verticalArrangement = Arrangement.Center`.
4. Add a `Text()` composable and a `Button()` below it.
5. In the button’s `onClick` lambda, call `println("Button pressed")` or do your Log implementation like i did.
6. Run the project and verify console output.

---

## IV. Exercise 01: Say Hello to the World

**Turn-in directory:** `mobileModule00/ex01`  
**Forbidden functions:** None

### 🎯 Objective

Update your previous project so that clicking the button toggles the text displayed.

- Initial text: `"Press the button"`  
- After click: `"Hello World!"`

Each click should **toggle** between these two values.

### 🧱 Implementation Steps

1. Copy your previous project into a new folder `ex01`.
2. Introduce a mutable state variable using `remember { mutableStateOf(false) }`.
3. In the `Text()` composable, display based on state:  
   `if (!toggle) "A simple Text" else "Hello World"`.
4. Update state on button click:  
   `toggle = !toggle`.
5. Test toggling behavior and console logs.

---

## V. Exercise 02: More Buttons

**Turn-in directory:** `mobileModule00/ex02`  
**Forbidden functions:** None

### 🎯 Objective

Create a simple calculator **UI** with the following elements:

- **TopAppBar** with title `"Calculator"`.
- Two **Text** inside a Column:
  - One to display the current **expression**.
  - One to display the **result** (both initialized to `"0"`).
- A grid of **buttons** including:
  - Numbers `0–9`
  - Decimal point `"."`
  - Clear buttons: `"AC"` (reset), `"C"` (delete last)
  - Operators: `+`, `-`, `*`, `/`
  - Equal sign `=`

### 🧱 Implementation Steps

1. Create a new project `ex02`.
2. Setup a `TopAppBar(title = { Text("Calculator") })`.
3. Add two `TextField`s at the top for **expression** and **result**.
4. Create a `listOf<listOf<String>>` of buttons so you can use forEachIndexed for each `Row` and then you can use again forEachIndexed for each `Text` button.
5. For each button, print its label in the console on clickable modifier.
6. Ensure responsiveness across device sizes.

---

## VI. Exercise 03: It’s Alive!

**Turn-in directory:** `mobileModule00/calculator_app`  
**Forbidden functions:** None

### 🎯 Objective

Add **logic** to make your calculator functional.

### ✅ Features

- Perform:
  - Addition
  - Subtraction
  - Multiplication
  - Division
- Support **multiple operations** (e.g., `1 + 2 * 3 - 5 / 2`).
- Allow **negative** and **decimal** numbers.
- Implement buttons:
  - `"C"` – delete last character
  - `"AC"` – clear all
  - `"="` – evaluate expression

### 🧱 Implementation Steps

1. Copy your project from `ex02` into a new one `calculator_app`.
2. Implement a parser or evaluation logic in a separate Kotlin file.
   - Tokenize the expression.
   - Convert infix notation to postfix (RPN).
   - Evaluate the RPN expression.
3. Update the **expression field** as buttons are pressed.
4. Show the **result field** dynamically when `=` is pressed.
5. Handle:
   - Division by zero
   - Invalid inputs
   - Large numbers gracefully
6. Test thoroughly — your app must **never crash**.

---

## VII. Submission and Peer-Evaluation

- Submit your work through your **Git repository**.
- Only files present in the repository at evaluation time will be considered.
- Ensure proper naming of directories and files.
- Evaluations happen on the evaluator’s machine.

> 🧭 *Piscine Mobile — Module00: Introduction to Mobile Development (Kotlin Multiplatform Edition)*
