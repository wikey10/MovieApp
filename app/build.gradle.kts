plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.app.movieapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.app.movieapp"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Jetpack Compose BOM (Manages Compose versions)
    implementation(platform(libs.androidx.compose.bom))

    // Core UI and Foundation
    implementation(libs.ui) // Core UI
    implementation(libs.androidx.foundation) // Layouts and modifiers
    implementation(libs.ui.graphics) // Graphics
    implementation(libs.ui.tooling.preview) // Previews in Android Studio

    // Material Design
    implementation(libs.material3) // Material 3 components

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.ui.test.junit4) // UI testing

    // Debugging and Tooling
    debugImplementation(libs.ui.tooling) // UI tooling in debug builds
    debugImplementation(libs.ui.test.manifest) // Testing manifest

    //navigation
    implementation(libs.androidx.navigation.compose)

    //coil Images
//    implementation(libs.coil.compose)
    implementation("io.coil-kt:coil-compose:1.3.1")

}
