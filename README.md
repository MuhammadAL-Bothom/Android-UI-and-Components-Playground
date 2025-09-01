# 💎 Android UI & Components Playground

**training4** is a compact Android demo app showcasing common UI patterns and components:
a splash/intro animation, dashboard cards, app-bar menu navigation, profile with photo picker,
settings with language switching + password update, animated buttons (ObjectAnimator + Lottie),
a custom **GridView** with adapter/model classes, and an **ExpandableListView**.

---

## 📱 Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/3aafa0c3-eacf-46ae-add1-3c568b945125"        alt="Splash / intro"          width="230"/>
  <img src="https://github.com/user-attachments/assets/e0eb4eca-50ad-402d-9bb1-561a5735cf86"     alt="Dashboard"               width="230"/>
  <img src="https://github.com/user-attachments/assets/0ea5226e-8221-461a-bbc6-fba93d0a96f7"          alt="App bar menu"            width="230"/>
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/a4126fe4-4412-476b-87e1-aba9fff1aea6"       alt="Profile screen"          width="230"/>
  <img src="https://github.com/user-attachments/assets/4c710037-2421-4dcd-88f5-6c0233b2800d"      alt="Settings (lang + pwd)"   width="230"/>
  <img src="https://github.com/user-attachments/assets/8b6d2108-b088-4ba4-ba3d-1a67b9603815"   alt="Animated button (idle)"  width="230"/>
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/d6fd5dd2-a1de-4355-8445-193cbbf3dc1a" alt="Animated button (running)" width="230"/>
  <img src="https://github.com/user-attachments/assets/520c6a2a-aaa5-4c9a-bccb-5037d6480981"     alt="Action cards"             width="230"/>
    <img src="https://github.com/user-attachments/assets/35c84118-68f0-457d-9905-52e4e7bf9e38" alt="Animated cards (running)" width="230"/>

</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/e5382dde-3acd-40a3-9cef-e207975c5560"             alt="Custom GridView"          width="230"/>
  <img src="https://github.com/user-attachments/assets/2f91f5e5-1eea-4784-ad39-78e5dae77641" alt="Expandable list" width="230"/>
</p>

---

## ✨ What’s inside

- 🐦 **Splash / Intro** (`AnimationDrawable`) → auto-navigates to main screen when animation finishes.
- 🏠 **Dashboard** with gradient card and quick actions.
- ☰ **App-bar menu navigation** to:
  - **Profile**: pick profile photo from **gallery** or **camera** (runtime permissions handled).
  - **Settings**: **change language (AR/EN)** + **update password** (simple in-memory demo).
  - **Button1 / Button2**: animation playground (ObjectAnimator rotation, Lottie toggle).
  - **GridView**: custom adapter over a model list.
  - **List**: **ExpandableListView** with groups and clickable children.
- 🎞 **Animations**
  - `ObjectAnimator` spin on button click.
  - **Lottie** on/off progress-range toggle.
- 🧩 **Custom GridView**
  - `GridviewAdapter` (ViewHolder pattern) bound to `ArrayListModel` → `Models(iconId, name)`.
- 📚 **Expandable List**
  - Groups + children generated in code, **selectable** children with toast feedback.
- 🌐 **Localization**
  - AR/EN switching via `Configuration.setLocale` + layout direction update, persisted with `SharedPreferences`.

---

## 🛠 Tech Stack

- **Language:** Java  
- **UI:** ConstraintLayout, AppCompat, Toolbar/AppBar, GridView, ExpandableListView  
- **Animations:** `AnimationDrawable`, `ObjectAnimator`, **Lottie**  
- **Media:** Camera/gallery via `ActivityResultContracts.StartActivityForResult`  
- **State/Prefs:** `SharedPreferences` for language, simple in-memory password demo

---

## 📂 Project Structure (key files)

```plaintext
app/
 ├─ src/main/java/com/example/traning4/
 │   ├─ MainActivity.java            # Splash/intro (AnimationDrawable) → Task2
 │   ├─ Task2.java                   # Main container with menu
 │   ├─ ProfileActivity.java         # Pick profile photo (gallery/camera + permissions)
 │   ├─ SettingActivity.java         # Language (AR/EN) + change password demo
 │   ├─ Button1.java                 # ObjectAnimator rotation + Lottie toggle
 │   ├─ Button2.java                 # Second animation/sandbox page
 │   ├─ GridViewActivity.java        # Custom GridView demo
 │   ├─ List.java                    # ExpandableListView demo
 │   ├─ MainAdapter.java             # ExpandableList adapter
 │   │
 │   ├─ disign/GridviewAdapter.java  # GridView adapter (ViewHolder pattern)
 │   ├─ modle/ArrayListModel.java    # Supplies demo data (icons + labels)
 │   └─ modle/Models.java            # Model { Integer iconId, String name }
 │
 ├─ res/layout/                      # XML layouts (splash, dashboard, profile, settings, etc.)
 ├─ res/drawable/                    # Icons, animation list, gradients
 ├─ res/menu/main_menu.xml           # App bar menu: Profile / Setting / Button1 / Button2 / GridView / List
 └─ README.md
