# Car Makes List

An Android app built with Jetpack Compose, Hilt, Retrofit, and Room to browse car manufacturers from the VPIC NHTSA API. Supports offline access by caching data locally.

## ✨ Features

- Fetches car makes from VPIC API
- Caches results in Room database
- Offline fallback when no internet
- Modern UI with Jetpack Compose
- Dependency injection via Hilt

## 🧱 Tech Stack

- **Jetpack Compose** – Declarative UI
- **Hilt** – Dependency injection
- **Retrofit** – Network layer
- **Room** – Local database
- **ViewModel + State** – UI logic
- **Kotlin Coroutines** – Async operations

## 📦 API Reference

Endpoint used:
- [GET] https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json

## 🧠 Architecture: MVVM Pattern

This project follows the **Model–View–ViewModel (MVVM)** architecture to ensure a clean separation of concerns and scalable code structure.

### 🔹 Model
- Represents the data layer.
- Includes:
  - `CarMake` data class
  - Room entities and DAO
  - Retrofit API service
- Handles data operations from both network and local database.

### 🔹 ViewModel
- Acts as a bridge between UI and data.
- Uses `CarMakeRepository` to fetch and expose data.
- Maintains UI state using `mutableStateOf` and `viewModelScope`.

### 🔹 View (Jetpack Compose)
- Observes state from `ViewModel`.
- Displays a list of car makes using `LazyColumn`.
- Reacts to state changes automatically.

### 🧩 Benefits of MVVM
- Decouples UI from business logic
- Improves testability and maintainability
- Makes the app easier to scale and extend

