# 📱 42 Mobile Piscine — Kotlin Multiplatform Edition

Welcome to the **42 Mobile Piscine**, a hands-on introduction to modern mobile development — using **Kotlin Multiplatform (KMP)** and **Jetpack Compose Multiplatform**.

This repository contains multiple modules of the piscine, where each one explores a different level of mobile application development — from UI fundamentals to full multiplatform logic sharing.

---

## 🧭 What is Kotlin Multiplatform (KMP)?

**Kotlin Multiplatform (KMP)** is a technology developed by **JetBrains** that allows developers to share code across multiple platforms — Android, iOS, Desktop, Web, and more — while keeping **native UI layers**.

KMP enables you to write **business logic once** and **reuse it everywhere** while maintaining the look and performance of **native apps**.

### 💡 Why this matters

Most frameworks (like Flutter or React Native) use a single UI toolkit for all platforms, often sacrificing native feel or platform-specific features.

KMP, instead, focuses on **shared logic and native presentation**:

- ✅ **Shared code** for core logic (data, networking, algorithms, models).  
- 🎨 **Native UI** with Jetpack Compose, SwiftUI, etc.  
- ⚙️ **Native performance** — no bridges, no webviews, just Kotlin compiled for each target.  
- 🔒 **Type-safe and maintainable** architecture.  
- 🧩 **Interoperable** — easily integrates with existing native apps.

---

## 🎨 What is Jetpack Compose Multiplatform?

**Jetpack Compose Multiplatform** is JetBrains’ implementation of Google’s **Jetpack Compose** that works not only on Android but also on **iOS, Web, and Desktop**.

It provides a **declarative UI framework**, where you describe *what* the UI should look like instead of *how* to build it step-by-step.

### 🧱 Key Features
- One **declarative UI language** for all platforms.  
- Full **Kotlin integration** (no XML, no bridging).  
- Fast previews and hot reload during development.  
- Scales from simple UIs to full apps.  

This makes Compose Multiplatform an ideal choice for modern mobile development — flexible, efficient, and future-proof.

---

## 🧠 Why I Chose Kotlin Multiplatform

I selected KMP for this piscine because it strikes the **perfect balance between reusability and native power**.

Unlike cross-platform tools that abstract away platform APIs, KMP keeps you **close to native development** while still offering **shared business logic**. This ensures:

- High performance.  
- Native integration with Android Studio & Xcode.  
- Easier scaling for professional SDK and app projects.  
- Long-term viability backed by JetBrains and Google.

> In short: KMP lets me write clean, maintainable, and truly multiplatform code — the right way.

---

## 🧩 About This Repository

This repository contains **all modules** of the 42 Mobile Piscine, implemented in **Kotlin Multiplatform** using **Jetpack Compose Multiplatform** for UI.

Each module builds upon the previous one, gradually introducing concepts of UI, state management, and multiplatform logic.

📁 Each module (e.g. `mobileModule00`, `mobileModule01`, etc.) includes its own exercises and documentation.

You can find module-specific details in their respective **README files**.

---

## 🧭 Learning Goals

By the end of this piscine, you will understand:

- How mobile applications are structured.  
- How to build declarative UIs using Compose.  
- How Kotlin Multiplatform enables code sharing.  
- How to architect scalable and testable mobile apps.  

---

## ⚙️ Technologies Used

- **Language:** Kotlin  
- **UI Framework:** Jetpack Compose Multiplatform  
- **Architecture:** MVVM / Unidirectional Data Flow  
- **Build System:** Gradle (Kotlin DSL)  
- **Supported Targets:** Android, iOS, Desktop, Web  

---

> 🧭 *42 Mobile Piscine — Kotlin Multiplatform Edition*  
> “Write once. Feel native everywhere.”
