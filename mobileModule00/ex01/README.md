# Exercise 01 — Say Hello to the World (Kotlin Multiplatform)

This exercise builds upon the previous one (`ex00`) and introduces **state management** in **Jetpack Compose Multiplatform (KMP)** — a crucial concept in UI programming across Android, iOS, Web, and Desktop.

---

## 🎯 Objective

Create a composable app that displays a text and a button centered on the screen.  
When the user clicks the button, the displayed text **toggles** between two states:
- `"A simple Text"`
- `"Hello World"`

Additionally, print `"Button pressed"` in the debug console when the button is clicked.

---

## 🧱 Project Structure Recap

Your project (created in `ex00`) follows the standard **Kotlin Multiplatform (KMP)** layout:

```
mobileModule00/
└── ex01/
    ├── androidMain/     # Android-specific code (e.g., AndroidManifest.xml, MainActivity.kt)
    ├── iosMain/         # iOS-specific code (e.g., UIKit integration)
    ├── webMain/         # Web-specific setup (optional)
    ├── desktopMain/     # Desktop target (optional)
    ├── commonMain/      # Shared code across all platforms
    │   ├── kotlin/      # Shared Kotlin logic
    │   └── resources/   # Common resources (strings, icons, etc.)
    ├── build.gradle.kts # Gradle build configuration
    └── README.md        # Exercise documentation
```

---

## ⚙️ Gradle Recap

**Gradle** is the build automation tool used in Kotlin projects.  
It manages:
- **Dependencies** (Compose, Coroutines, etc.)
- **Build targets** (Android, iOS, JVM, JS)
- **Tasks** (building APKs, running tests, etc.)

Each module has its own `build.gradle.kts`, while the root `build.gradle.kts` handles shared settings.

To build your app:
```bash
./gradlew build
```

To build an Android APK:
```bash
./gradlew :ex01:assembleDebug
```
The generated `.apk` will be located under:
```
ex01/build/outputs/apk/debug/
```

---

## 📱 The Code

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
            var toggle by remember { mutableStateOf(false) }

            Text(
                if (!toggle) "A simple Text" else "Hello World",
                color = Color.White,
                modifier = Modifier
                    .background(color = Color(0xFF626b32), shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                fontSize = 24.sp
            )

            Button(
                onClick = {
                    Log.i("I/Kotlin", "Button pressed")
                    toggle = !toggle
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

---

## 🧠 Understanding `remember` and `mutableStateOf`

### What is a State?

A **state** represents a **piece of data that can change over time**.  
When the state changes, the UI automatically **recomposes** — re-executing composable functions to update what the user sees.

In Compose, we use:

```kotlin
var toggle by remember { mutableStateOf(false) }
```

- `mutableStateOf()` creates a **mutable observable state**.  
- `remember` makes the state **persist** across recompositions — it keeps the same value until the composable leaves memory.  
- The `by` keyword is **property delegation**, allowing direct access to the state without calling `.value`.

Each time the button is pressed, `toggle` flips between `true` and `false`, and the `Text` composable updates automatically.

---

## 🔄 Lifecycle and Memory Behavior

Jetpack Compose manages its own lifecycle within each screen.  
However, understanding **how UI state persists** across platforms is essential:

### 🧩 Android
- When the app goes to the background, the **Activity** or **Composable state** may be **destroyed**.
- Use `rememberSaveable` to persist data across configuration changes (like screen rotation).

### 🍎 iOS
- The KMP iOS target integrates with **SwiftUI** or **UIKit**.
- Compose state works the same — Kotlin manages it through a memory-safe runtime.

### 💻 Desktop & Web
- Desktop Compose uses **JVM memory management**.
- Web Compose (Compose for Web) stores UI state in the **browser runtime**.

> ⚠️ The key takeaway: `remember` stores data **only in memory** — it is not persistent when the app is killed.

To persist data across sessions, use:
- `rememberSaveable()` (in Android)
- SharedPreferences / DataStore (Android)
- NSUserDefaults (iOS)
- LocalStorage (Web)

---

## 🧩 How State Works in KMP

In **Kotlin Multiplatform**, state and recomposition logic are **shared** through `commonMain`.  
This means your business logic (like toggling, data fetching, or validation) can be written once in Kotlin and reused on all targets.

The UI layer — Compose, SwiftUI, or other — **reacts** to state changes emitted by the shared logic.

Example shared logic:

```kotlin
class GreetingState {
    private val _toggle = MutableStateFlow(false)
    val toggle = _toggle.asStateFlow()

    fun onButtonClick() {
        _toggle.value = !_toggle.value
    }
}
```

Each platform can observe this state using its native tools (Compose, SwiftUI, etc.).

---

## ⚙️ Lifecycle in Jetpack Compose (Simplified)

| Lifecycle Stage | Description | Common Usage |
|------------------|-------------|---------------|
| **Composition** | Composable enters composition | Initialize states |
| **Recomposition** | State changes trigger UI update | Redraw UI |
| **Disposal** | Composable leaves composition | Free resources |

Compose keeps the UI reactive and efficient by re-rendering **only the parts that changed**.

---

## 🚀 Step-by-Step Implementation

1. Create a new project `ex01`.
2. Copy your `ex00` code base.
3. Add a `var toggle by remember { mutableStateOf(false) }` state variable.
4. Replace static text with conditional text:
   ```kotlin
   Text(if (!toggle) "A simple Text" else "Hello World")
   ```
5. Modify the button’s `onClick` to flip the state:
   ```kotlin
   toggle = !toggle
   ```
6. Run the app — each click toggles between texts.
7. Check the console for `"Button pressed"` logs.

---

## 🧩 Result

| Action | UI Result |
|--------|------------|
| App start | Displays **“A simple Text”** |
| Button click | Displays **“Hello World”** |
| Button click again | Returns to **“A simple Text”** |

---

## 🧭 Summary

- **State** is the core of modern UI. It drives reactivity and data flow.
- `remember` keeps state alive within a Composable.
- `mutableStateOf` makes a variable observable.
- Jetpack Compose automatically re-renders UI on state changes.
- In **KMP**, this state system works seamlessly across platforms.

> 💡 This exercise is your first step into **reactive UI programming** — the foundation for advanced Kotlin Multiplatform applications.
