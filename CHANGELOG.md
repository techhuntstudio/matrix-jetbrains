<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# matrix-jetbrains Changelog

## [Unreleased]

### Changed 

- Relaxed the version range for the plugin
- Kotlin updated to 2.1.0
- Gradle IntelliJ platform plugin updated to 2.2.0
- Qodana updated to 2024.2.6
- Kover updated to 0.8.3

### Notes

- Attempted to use JTE to generate themes from templates. Turns out that the library brings some dependencies that are not detected by the plugin verifier as unused. Trying to remove some of them results in the verifier not being able to find the classes. So, for now, the plugin will continue to use the hardcoded themes.  

## [0.0.8] - 2024-11-23

### Added

- this release was generated using CI/CD

## [0.0.7] - 2024-13-11

### Added

- Plugin Signing and Publish Run Configuration

## [0.0.6] - 2024-11-11

### Added

- Open end support for IntelliJ

## [0.0.5] - 2024-19-08

### Added

- Support for IntelliJ 242.*

## [0.0.4] - 2024-04-01

### Added

- Update build range to support 2023 and 2024

## [0.0.3]

### Added

- Update Supported IDE Version
- Retain Color When Top Bar Is Unfocused
- Debug Window - Change Selected Tab Foreground

## [0.0.2]

### Added

- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)

[Unreleased]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.8...HEAD
[0.0.8]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.7...v0.0.8
[0.0.7]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.6...v0.0.7
[0.0.6]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.5...v0.0.6
[0.0.5]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.4...v0.0.5
[0.0.4]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.3...v0.0.4
[0.0.3]: https://github.com/techhuntstudio/matrix-jetbrains/compare/v0.0.2...v0.0.3
[0.0.2]: https://github.com/techhuntstudio/matrix-jetbrains/commits/v0.0.2
