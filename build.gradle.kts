import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    id("org.jetbrains.compose") version "0.4.0-build180"
}

group = "me.waithaka"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    implementation(compose.desktop.currentOs)

    // Decompose for desktop
    implementation("com.arkivanov.decompose:decompose:0.2.1")
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:0.2.1")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions {
        jvmTarget = "11"

//        // suppress kotlin vs compose compatibility check
//        useIR = true
//        freeCompilerArgs = listOf(
//            "-P",
//            "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
//        )
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "player"
            packageVersion = "1.0.0"
        }
    }
}
