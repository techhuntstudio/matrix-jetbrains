import gg.jte.ContentType
import org.jetbrains.changelog.date
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import java.nio.file.Paths

fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)

plugins {
    java
    id("gg.jte.gradle") version "3.1.15"
    libs.plugins.jte // JTE support
    alias(libs.plugins.kotlin) // Kotlin support
    alias(libs.plugins.gradleIntelliJPlatformPlugin) // Gradle IntelliJ Platform Plugin
    alias(libs.plugins.changelog) // Gradle Changelog Plugin
    alias(libs.plugins.qodana) // Gradle Qodana Plugin
    alias(libs.plugins.kover) // Gradle Kover Plugin
}

apply(plugin = "org.jetbrains.kotlinx.kover")

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

// Set the JVM language level used to build the project. Use Java 11 for 2020.3+, Java 17 for 2022.2+, Java 21 for 2024.2+
kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    implementation(libs.jte)
    intellijPlatform {
        create(properties("platformType"), properties("platformVersion"))
        instrumentationTools()
        pluginVerifier()
        zipSigner()
        testFramework(TestFrameworkType.Platform)
    }
}

intellijPlatform {
    pluginConfiguration {
        version.set(properties("pluginVersion"))
        description =  providers.fileContents(layout.projectDirectory.file("README.md")).asText.map {
            val start = "<!-- Plugin description -->"
            val end = "<!-- Plugin description end -->"

            with (it.lines()) {
                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end)).joinToString("\n").let(::markdownToHTML)
            }
        }
        name.set(properties("pluginName"))
        group = properties("pluginGroup")
//        plugins(providers.gradleProperty("platformPlugins").map { it.split(',') })
        // Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
        changelog {
            version.set(properties("pluginVersion"))
            path.set(file("CHANGELOG.md").canonicalPath)
            header.set(provider { "${version.get()} - ${date()}" })
            headerParserRegex.set("""(\d\.\d\.\d)""".toRegex())
            itemPrefix.set("-")
            keepUnreleasedSection.set(true)
            unreleasedTerm.set("[Unreleased]")
            groups.set(listOf("Added", "Changed", "Deprecated", "Removed", "Fixed", "Security"))
        }
        vendor {
            name.set(properties("pluginVendor"))
            url.set(properties("pluginVendorUrl"))
            email.set(properties("pluginVendorEmail"))
        }
        ideaVersion {
            sinceBuild.set(properties("pluginSinceBuild"))
            untilBuild.set(properties("pluginUntilBuild"))
        }

    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        // The pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels = listOf("default")
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

changelog {
    groups.empty()
    repositoryUrl = providers.gradleProperty("pluginRepositoryUrl")
}

// Configure Gradle Kover Plugin - read more: https://github.com/Kotlin/kotlinx-kover#configuration
kover {
    reports {
        total {
            xml {
                onCheck = true
            }
        }
    }
}

tasks {
    wrapper {
        gradleVersion = properties("gradleVersion").get()
    }

    publishPlugin {
        dependsOn(patchChangelog)
    }

    generateJte {
        sourceDirectory = Paths.get("src/main/resources")
        contentType = ContentType.Plain
        targetDirectory = Paths.get("src/main/kotlin")
        packageName = "com.techhuntstudio.matrix.themes"

    }

    compileKotlin {
        dependsOn("generateJte")
    }
}

intellijPlatformTesting {
    runIde {
        register("runIdeForUiTests") {
            task {
                jvmArgumentProviders += CommandLineArgumentProvider {
                    listOf(
                        "-Drobot-server.port=8082",
                        "-Dide.mac.message.dialogs.as.sheets=false",
                        "-Djb.privacy.policy.text=<!--999.999-->",
                        "-Djb.consents.confirmation.enabled=false",
                    )
                }
            }

            plugins {
                robotServerPlugin()
            }
        }
    }
}

tasks.buildSearchableOptions {
    enabled = false
}