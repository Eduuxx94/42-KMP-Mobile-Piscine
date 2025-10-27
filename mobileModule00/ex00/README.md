# Exercise 00 - A Basic Display (Kotlin Multiplatform)

## 📘 Overview

This project is part of **Piscine Mobile Module 00**, where we introduce the fundamentals of **Kotlin Multiplatform (KMP)** development.  
You will learn how to create a simple mobile UI using **Jetpack Compose Multiplatform**, understand the structure of a KMP project, and explore the basic tools such as **Gradle**, **APK**, and platform-specific folders.

---

## 🧩 Multiplatform Project (KMP)?

**Kotlin Multiplatform** allows you to share common code (business logic, networking, models, etc.) between multiple platforms — typically **Android**, **iOS**, **Desktop**, and **Web**.

KMP splits your project into two main parts:

- **Shared Module**: Contains platform-independent logic written in Kotlin.
- **Platform-Specific Modules**: Contain UI and platform-dependent implementations.

### 🏗️ Common Project Structure

```
mobileModule00/
│
├── shared/                     # Shared Kotlin code (business logic, models, utils)
│   ├── src/commonMain/         # Common code for all platforms
│   ├── src/androidMain/        # Android-specific implementations
│   ├── src/iosMain/            # iOS-specific implementations
│   ├── build.gradle.kts        # Gradle configuration for shared module
│
├── androidApp/                 # Android application module
│   ├── src/main/               # Android entry point (MainActivity.kt, manifest, etc.)
│   ├── build.gradle.kts        # Gradle configuration for Android app
│
├── iosApp/                     # iOS application module (Xcode project)
│   ├── iosMain/                # iOS source code (Swift/Kotlin interop)
│
├── build.gradle.kts            # Root Gradle build file
├── settings.gradle.kts         # Gradle project configuration
└── gradle.properties           # Project-wide Gradle settings
```

---

## ⚙️ What is **Gradle**?

**Gradle** is a powerful build automation tool used in Kotlin and Android projects. It manages:

- Dependencies (external libraries)
- Compilation (turning your code into executables)
- Packaging (creating APKs or iOS apps)
- Versioning and configuration management

Each module has its own `build.gradle.kts` file defining how it builds and what dependencies it uses.

---

## 📦 What is an **APK**?

An **APK (Android Package)** is the compiled and packaged version of your Android app.  
It contains all resources, assets, compiled Kotlin/Java bytecode, and metadata — ready to be installed on any Android device.

You can generate an APK by running:

```bash
./gradlew assembleDebug
```

The APK will be located in:
```
androidApp/build/outputs/apk/debug/androidApp-debug.apk
```

---

## 📁 Folder Breakdown

### `commonMain/`
This folder holds **shared logic** — code that can be reused across all platforms.  
Typical files include network requests, data models, and core algorithms.

### `androidMain/`
Contains code that interacts directly with Android APIs — for instance, UI components, system permissions, or hardware access.

### `iosMain/`
This folder allows iOS-specific Kotlin code that communicates with Swift or Objective-C.  
It uses Kotlin/Native to compile directly into iOS binaries.

### `androidApp/`
The Android application layer — includes **Compose UI** and Android-specific entry points (like `MainActivity.kt`).

---

## 💡 The Code Explained

The following Kotlin Compose code builds a minimal user interface with a **Text** and a **Button** centered vertically and horizontally.

```kotlin
@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "A simple Text",
                color = Color.White,
                modifier = Modifier
                    .background(color = Color(0xFF626b32), shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                fontSize = 24.sp
            )
            Button(
                onClick = {
                    Log.i("I/Kotlin", "Button pressed")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF626b32),
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp,
                    focusedElevation = 6.dp,
                    hoveredElevation = 10.dp,
                    disabledElevation = 4.dp
                ),
            ) {
                Text("Click me")
            }
        }
    }
}
```

### 🧠 Step-by-Step Breakdown

1. **`@Composable`** – Marks a function as composable, meaning it can define part of your UI.
2. **`@Preview`** – Allows previewing the composable in Android Studio without running the app.
3. **`MaterialTheme`** – Provides consistent styling following Google’s Material Design.
4. **`Column`** – Arranges its child components vertically.
5. **`Modifier`** – Used to decorate or layout UI components (size, color, alignment, etc.).
6. **`Text`** – Displays text on the screen.
7. **`Button`** – Creates an interactive button.
8. **`Log.i()`** – Prints “Button pressed” to the debug console when clicked, you can check how i build it, but it works like printl.

The app displays:

- A **green rounded rectangle** with the text `"A simple Text"` inside.
- A **white button** labeled `"Click me"` below.
- When clicked, the console shows:  
  ```
  I/Kotlin: Button pressed
  ```

---

## 🧭 How to Run the Project

### 1. Open in Android Studio
- Import the KMP project folder (`ex00`) into **Android Studio**.
- Wait for Gradle sync to complete.

### 2. Run Android App
- Select **androidApp** as the run configuration.
- Click ▶️ **Run** to build and deploy on an emulator or physical device.

### 3. Run iOS App (Optional)
- Select the **iosApp** as the run configuration.
- Click ▶️ **Run** to build and deploy on an emulator or physical device.

### 4. Run Web/Desktop App (Optional)
- Select the **Web/Desktop** as the run configuration.
- Click ▶️ **Run** to build and deploy on an browser or JVM.

---

## 🧱 Key Takeaways

- You learned how KMP separates shared and platform-specific code.
- You explored **Gradle**, **APK**, and **KMP folder structure**.
- You built your first **Composable function** using **Jetpack Compose Multiplatform**.
- You practiced basic UI layout and event handling.

---

## 🚀 Next Steps

- Exercise 01 will expand this UI to dynamically change the displayed text when the button is pressed.
- Exercise 02 introduces calculator UI concepts.
- Exercise 03 implements the full calculator logic.

---

### 🧾 Author Notes

Created as part of **Piscine Mobile - Module00**, this README is designed to give you a complete foundation in **Kotlin Multiplatform app structure**, **UI composition**, and **tooling** setup.
