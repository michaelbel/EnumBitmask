plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

private val gitCommitsCount: Int by lazy {
    ProcessBuilder("git", "rev-list", "--count", "HEAD")
        .redirectErrorStream(true)
        .start().inputStream.bufferedReader().readLine().trim().toInt()
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.enumbitmask"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "org.michaelbel.enumbitmask"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = gitCommitsCount
        versionName = "1.0.0"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "enumbitmask"
            keyPassword = "password"
            storeFile = rootProject.file(".github/debug-key.jks")
            storePassword = "password"
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        compose = true
    }
}

base {
    archivesName.set("EnumBitmask-v${android.defaultConfig.versionName}(${android.defaultConfig.versionCode})")
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.google.material)
    debugImplementation(libs.androidx.compose.ui.tooling)
    testImplementation(libs.junit)
}

tasks.register("printVersion") {
    description = "Prints the current versionName and versionCode to stdout."
    doLast {
        println("VERSION_NAME=${android.defaultConfig.versionName}")
        println("VERSION_CODE=${android.defaultConfig.versionCode}")
    }
}
