plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
//    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.rashidsaleem.eventbookingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rashidsaleem.eventbookingapp"
        minSdk = 24
        targetSdk = 34
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
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
//        kotlinCompilerExtensionVersion = "1.4.3"
        kotlinCompilerExtensionVersion = "1.5.7"
//        kotlinCompilerExtensionVersion = "1.9.21"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    val nav_version = "2.7.5"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Compose
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Navigation
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Material
    implementation("androidx.compose.material:material:1.5.4")
    implementation("androidx.compose.material3:material3:1.1.2")

    // Gson
    implementation("com.google.code.gson:gson:2.10.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Compose-Testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Dagger - Hilt
//    implementation("com.google.dagger:hilt-android:2.44")
//    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")

    // compose dialog
    implementation("io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc")
    implementation("com.kizitonwose.calendar:compose:2.4.1")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")


}

kapt {
    correctErrorTypes = true
}