# Java Internationalization Demo

A small Java Swing application built to show, in a way you can actually click through, how
internationalisation works in Java: externalised strings, `Locale`, and switching language at runtime
without restarting the app.

Written for the *Software Engineering / Interfaces* coursework (BSc in Computer Engineering,
University of Jaén).

## What it demonstrates

- **Externalised UI strings** — no user-facing text is hard-coded in the `.java` files
- **`ResourceBundle` + `Locale`** — the app resolves the right bundle for the selected language
- **Runtime language switching** — pick Spanish or English from the UI and every label, button and
  message updates in place; no restart
- **Locale-aware formatting** — numbers and dates are formatted according to the active locale, not
  with a hard-coded pattern
- **Flags / images per locale** — `img/banderaESP.png`, `img/banderaEN.png` are loaded per bundle

## Screens

<!-- TODO: add 1-2 screenshots. They are the single thing that makes this repo click.
Drag the images into the GitHub editor while editing this file and it uploads them for you.

| Spanish | English |
| :---: | :---: |
| ![ES](docs/screenshot-es.png) | ![EN](docs/screenshot-en.png) |
-->

The app is a small CRUD over a text file (`datos.txt`), with screens for adding, editing, deleting and
listing records. The point is not the CRUD — it is that the same screens work in every language.

## Running it

**Option A — NetBeans (original project)**

1. Open the `InternationalizationAPP` folder as a NetBeans project
2. Run (`F6`)

**Option B — command line**

```bash
cd InternationalizationAPP
javac -d build/classes $(find src -name "*.java")
java -cp build/classes Internacionalización.Main
```

Requires **JDK 8+**. A prebuilt jar is in `InternationalizationAPP/dist/`.

## How it works

```
src/Internacionalización/
├── Main.java            # entry point, loads the initial locale
├── Principal.java       # main window
├── Idioma.java          # language selector, reloads the bundle
├── Add.java  / Add2.java
├── Eliminar.java / Eliminar2.java
├── Modificar.java / Modificar2.java
└── Ver.java
```

Each screen asks the bundle for its labels instead of using literals:

```java
ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", currentLocale);
label.setText(bundle.getString("form.name"));
```

<!-- TODO: if the bundles are .properties files inside the project, list them here so the reader
sees where the translations live:

i18n/messages_es.properties
i18n/messages_en.properties
-->

## Stack

`Java` · `Swing` · `ResourceBundle` · `Locale` · NetBeans

## License

MIT — see [LICENSE](LICENSE).
