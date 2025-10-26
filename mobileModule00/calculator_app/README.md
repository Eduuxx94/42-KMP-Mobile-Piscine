# Exercise 03 – It’s Alive! (Calculator Logic)

**Objective:**
- Implement calculator logic behind the UI.
- Handle multiple operations, negative numbers, decimal numbers, clear (`AC`), and delete (`C`).

**Implementation Notes:**
- Created `commonMain` logic for parsing and evaluating expressions:
    - `calculateExpression(expression: String): String` – main entry function.
    - `tokenize()` – splits input into numbers and operators.
    - `infixToRPN()` – converts infix expression to Reverse Polish Notation using operator precedence.
    - `evaluateRPN()` – calculates the RPN result using a stack.
- Decoupled logic from UI for multiplatform reusability.
- Used `ArrayDeque` for stack operations.
- Debugging: used my own multiplatform logging (`Log.i("Tag", "message")`).

**Problems Faced:**
- Handling consecutive operators and negative numbers during tokenization (`59-89+-20/6`).
- Need for custom logging across platforms.
- Ensuring correct precedence in infix to RPN conversion.
- Desktop vs Android default UI differences (elevation, clickable ripple).

**Result:**
- Calculator correctly evaluates expressions like `"0+1.2-4/3*2-2+11"`.
- Negative numbers, decimals, multi-operation expressions are supported.
- UI remains responsive across Android, iOS, Desktop, and Web.
- Debug output logs each button press and intermediate states.

---

## General Notes & Best Practices

- **Separation of Concerns:** UI code (`Composable`) does not contain business logic. Logic resides in `commonMain`.
- **State Management:** Use `remember { mutableStateOf(...) }` for reactive UI updates.
- **Platform-Specific Differences:** Desktop, Web, and Mobile have slightly different defaults in Compose (e.g., elevation, clickable effect). Always test all targets.
- **Logging:** Use my implementation of `Log` for multiplatform logging.
- **Responsive Design:** Use `fillMaxWidth()`, `weight()`, `safeContentPadding()`, and alignment modifiers to ensure responsiveness.

---

This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop (JVM).

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
    - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
    - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
      For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
      the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
      Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
      folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:

- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run Desktop (JVM) Application

To build and run the development version of the desktop app, use the run configuration from the run widget
in your IDE’s toolbar or run it directly from the terminal:

- on macOS/Linux
  ```shell
  ./gradlew :composeApp:run
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:run
  ```

### Build and Run Web Application

To build and run the development version of the web app, use the run configuration from the run widget
in your IDE's toolbar or run it directly from the terminal:

- for the Wasm target (faster, modern browsers):
    - on macOS/Linux
      ```shell
      ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
      ```
    - on Windows
      ```shell
      .\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
      ```
- for the JS target (slower, supports older browsers):
    - on macOS/Linux
      ```shell
      ./gradlew :composeApp:jsBrowserDevelopmentRun
      ```
    - on Windows
      ```shell
      .\gradlew.bat :composeApp:jsBrowserDevelopmentRun
      ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack
channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).