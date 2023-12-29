# matrix-jetbrains

![Build](https://github.com/techhuntstudio/matrix-jetbrains/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/23426-matrix.svg)](https://plugins.jetbrains.com/plugin/23426-matrix)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/23426-matrix.svg)](https://plugins.jetbrains.com/plugin/23426-matrix)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [x] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [x] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [x] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [x] Set the `PLUGIN_ID` in the above README badges.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
**"Matrix"** is a neon cyberpunk theme that aims to bathe your coding environment in a mesmerizing green glow reminiscent of a neon-lit future.

## Features:

- 🌐 **Futuristic Vibes** Immerse yourself in the cyberpunk atmosphere with a carefully crafted blend of dark hues and vivid green accents, creating an environment that sparks creativity and focus.

- 🚀 **Hardcore Coding Experience** Tailored for those who push the boundaries of programming, NeonMatrix Green is optimized for maximum readability and efficiency, ensuring a seamless coding experience even during the most intense coding sessions.

- 🎨 **Striking Contrast** The theme provides a perfect balance of contrast, making code elements pop and enhancing visibility, allowing you to navigate through your code effortlessly.

- 🔧 **Versatile and Customizable** Fine-tune your coding experience with the flexibility to adjust the theme to your liking. Whether you prefer a subtle glow or an intense neon burst, NeonMatrix Green adapts to your coding style.

- 🔍 **Optimized for All Languages** From Python to JavaScript, C++ to HTML, NeonMatrix Green ensures a visually consistent and satisfying experience across a wide range of programming languages.

- 💼 **Ideal for Hardcore Programmers** For those who live and breathe code, NeonMatrix Green is not just a theme – it's a statement. Elevate your programming journey with a theme that mirrors your dedication to the craft.

**Unleash the power of NeonMatrix Green** and embrace a coding environment that goes beyond the ordinary. Elevate your programming aesthetics to new heights and experience the future of coding today! 🚀💻✨

<!-- Plugin description end -->

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "matrix-jetbrains"</kbd> >
  <kbd>Install</kbd>
  
- Manually:

  Download the [latest release](https://github.com/techhuntstudio/matrix-jetbrains/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
