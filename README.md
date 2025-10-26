# Mobile 0 — Basics of Mobile Application

This repository contains exercises from the Mobile-0 Piscine, implemented using **Kotlin Multiplatform (KMP)** and **Jetpack Compose Multiplatform**. The goal of these exercises is to understand basic UI elements, user interaction, and multiplatform logic.

---

## Project Structure

- `mobileModule00/ex00` – Exercise 00: A basic display  
- `mobileModule00/ex01` – Exercise 01: Say Hello to the World  
- `mobileModule00/ex02` – Exercise 02: More Buttons / Calculator UI  
- `mobileModule00/calculator_app` – Exercise 03: Full calculator with logic  

Each exercise is independent and builds upon the previous one.  

All shared logic resides in `commonMain` and UI code is implemented using Compose for multiplatform targets: Android, iOS, Web, Desktop.

---
## 📘 Table of Contents

- [I. Instructions](#i-instructions)
- [II. Introduction](#ii-introduction)
  - [II.1 What is a mobile application?](#ii1-what-is-a-mobile-application)
  - [II.2 What is Flutter?](#ii2-what-is-flutter)
  - [II.3 What is Kotlin Multiplatform (KMP)?](#ii3-what-is-kotlin-multiplatform-kmp)
  - [II.4 Why I chose Kotlin Multiplatform](#ii4-why-i-chose-kotlin-multiplatform)
- [III. Exercise 00: A Basic Display](#iii-exercise-00-a-basic-display)
- [IV. Exercise 01: Say Hello to the World](#iv-exercise-01-say-hello-to-the-world)
- [V. Exercise 02: More Buttons](#v-exercise-02-more-buttons)
- [VI. Exercise 03: It’s Alive!](#vi-exercise-03-its-alive)
- [VII. Submission and Peer-Evaluation](#vii-submission-and-peer-evaluation)

---

## I. Instructions

- Only this page will serve as reference. **Do not trust rumors.**
- Read the entire document carefully before starting.
- Your exercises will be corrected by your peers.
- The document can be relied upon — **do not blindly trust demos or screenshots**, which may contain extra elements.
- Got a question? Ask your peer on the right. If not, ask the one on the left.
- **By Odin, by Thor! Use your brain!**

🕒 *Intra indicates the closing date and time for your repositories. This also marks the beginning of the peer-evaluation period, which lasts exactly 24 hours. Missing peer grades after this time will be automatically set to 0.*

---

## II. Introduction

### II.1 What is a mobile application?

A **mobile application** is a software program designed to run on mobile devices, such as smartphones, personal digital assistants, or enterprise devices.

These applications can be:
- Pre-installed on devices during manufacturing, or  
- Delivered as web applications using server-side or client-side processing.

Mobile apps differ from:
- **Desktop applications**, which run on computers.
- **Web applications**, which run in browsers instead of directly on mobile devices.

---

### II.2 What is Flutter?

**Flutter** is Google’s open-source UI framework for building high-quality native interfaces for iOS and Android — **fast** and **efficiently**.

- Works with existing codebases.
- Used worldwide by developers and organizations.
- Completely **free and open-source**.

---

### II.3 What is Kotlin Multiplatform (KMP)?

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

### II.4 Why I chose Kotlin Multiplatform

I chose **Kotlin Multiplatform (KMP)** over other frameworks (like Flutter or React Native) because it provides the **best balance between code reuse and native control**.

While Flutter offers a unified UI and fast iteration, KMP allows me to:
- Use **native UI frameworks** (Jetpack Compose, SwiftUI) while still sharing business logic.
- Integrate more naturally into existing **native projects**.
- Maintain **long-term flexibility**, since KMP is based on **Kotlin**, a first-class language officially supported by Google for Android development.

In short, **KMP keeps the power of native apps** while reducing redundancy across platforms — making it ideal for scalable, professional mobile SDK development.

---

## III. Exercise 00: A Basic Display

**Exercise:** `A basic display`  
**Turn-in directory:** `mobileModule00`  
**Files to turn in:** `ex00` and all necessary files  
**Forbidden functions:** None  

For your first exercise, create a new project named **ex00** using the framework of your choice (in this case, **KMP**).

If using **Kotlin Multiplatform**:
- Understand the structure of a **shared module**.
- Learn how to define **expect/actual** declarations for platform-specific behavior.
- Explore **Compose Multiplatform** for building UI components when targeting multiple platforms.

### Requirements:
- Create a single-page app containing:
  - A **Text** element.
  - A **Button** below it.
- Both should be **centered horizontally and vertically**.
- When the button is clicked, print **“Button pressed”** in the console.
- The application must be **responsive**.

---

## IV. Exercise 01: Say Hello to the World

**Exercise:** `Say Hello to the World`  
**Turn-in directory:** `mobileModule00`  
**Files to turn in:** `ex01` and all necessary files  
**Forbidden functions:** None  

Start from your previous project (**ex00**) and create a new one: **ex01**.

### Requirements:
- The displayed text must **change** when clicking the button.
- It should toggle between the **initial text** and **“Hello World!”**.

---

## V. Exercise 02: More Buttons

**Exercise:** `More Buttons`  
**Turn-in directory:** `mobileModule00`  
**Files to turn in:** `ex02` and all necessary files  
**Forbidden functions:** None  

Now that you understand text and button basics, create a new project: **ex02**.

### Requirements:
1. Display an **AppBar** at the top with the title `"Calculator"`.
2. Add two **TextFields**:
   - One to show the **expression**.
   - One to show the **result**.
   - Initially, both should display `"0"`.
3. Add multiple **buttons**:
   - Digits: `0–9`
   - Decimal: `.`
   - Clear options: `AC` (reset), `C` (delete last character)
   - Operators: `+`, `-`, `*`, `/`
   - Equal: `=`
4. **Debug feature:** print the text of any pressed button in the console.
5. The UI must be **responsive** on all devices (phone, tablet, etc.).

---

## VI. Exercise 03: It’s Alive!

**Exercise:** `It’s Alive!`  
**Turn-in directory:** `mobileModule00`  
**Files to turn in:** `calculator_app` and all necessary files  
**Forbidden functions:** None  

Retrieve your **ex02** project and create a new one: **calculator_app**.

You may use libraries such as:
- `kotlin.math` for expressions.
- Or integrate third-party multiplatform math libraries.

### Requirements:
Make your calculator **fully functional**:
- Perform:
  - Addition
  - Subtraction
  - Multiplication
  - Division
- Handle **multiple operations** (e.g., `1 + 2 * 3 - 5 / 2`).
- Support **negative** and **decimal** numbers.
- Implement:
  - Delete last character (`C`)
  - Clear all (`AC`)

> ⚠️ Your application must **never crash** — handle invalid inputs, division by zero, and large numbers gracefully.

---

## VII. Submission and Peer-Evaluation

- Submit your work in your **Git repository**.
- Only files inside your repository will be evaluated.
- Double-check **folder and file names**.
- Evaluation will take place on the **evaluator’s computer**.

---

> 🧭 *Piscine Mobile — 0: Introduction to Mobile Development (Kotlin Multiplatform Edition)*
