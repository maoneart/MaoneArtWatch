plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

// A debug signing input, from `-P<property>` or `<environment>`, following the same
// property-then-environment order as the roots resolved in the root build file.
fun signingInput(property: String, environment: String): String? =
    (
        providers.gradleProperty(property).orNull
            ?: providers.environmentVariable(environment).orNull
        )?.takeIf(String::isNotBlank)

android {
    namespace = "dev.fitface.studio"
    compileSdk = 36

    signingConfigs {
        create("release") {
            storeFile = rootProject.file("keystore/release.jks")
            storePassword = signingInput("maoneart.storePassword", "KEYSTORE_PASSWORD") ?: "maoneart_key_2026"
            keyAlias = signingInput("maoneart.keyAlias", "KEY_ALIAS") ?: "maoneart"
            keyPassword = signingInput("maoneart.keyPassword", "KEY_PASSWORD") ?: "maoneart_key_2026"
        }
        getByName("debug") {
            signingInput("fit3.debugKeystore", "FIT3_DEBUG_KEYSTORE")?.let { keystore ->
                storeFile = rootProject.file(keystore)
                storePassword =
                    signingInput("fit3.debugKeystorePassword", "FIT3_DEBUG_KEYSTORE_PASSWORD")
                        ?: "android"
                keyAlias =
                    signingInput("fit3.debugKeyAlias", "FIT3_DEBUG_KEY_ALIAS")
                        ?: "androiddebugkey"
                keyPassword =
                    signingInput("fit3.debugKeyPassword", "FIT3_DEBUG_KEY_PASSWORD")
                        ?: "android"
            }
        }
    }

    defaultConfig {
        applicationId = "id.maoneart.watch"
        minSdk = 28
        targetSdk = 36
        versionCode = 100
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":feature:library"))
    implementation(project(":feature:editor"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
