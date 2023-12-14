import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id ("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.appstrov2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appstrov2"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
        compose = true
    }
    composeOptions {
        composeOptions {
            kotlinCompilerExtensionVersion = "1.4.3"
        }


        buildToolsVersion = "33.0.1"
    }

    dependencies {

        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.10.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("com.google.firebase:firebase-database:20.3.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
        implementation("androidx.activity:activity-ktx:1.4.1")
        implementation("androidx.fragment:fragment:1.4.0")

        implementation("com.google.android.material:material:1.3.0-alpha03")

        implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
        implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

        //api
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

//    MediaPipe

        implementation("com.google.mediapipe:tasks-vision:0.10.0")
        implementation("androidx.camera:camera-core:1.3.0")

        // CameraX Camera2 extensions
        implementation("androidx.camera:camera-camera2:1.3.0")
        // CameraX
        implementation("androidx.camera:camera-lifecycle:1.3.0")

        // CameraX View class
        implementation("androidx.camera:camera-view:1.3.0")
        implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
        implementation("com.google.firebase:firebase-analytics-ktx")

        //media player
        implementation("androidx.media3:media3-exoplayer:1.1.0")
        implementation("androidx.media3:media3-ui:1.1.0")
        implementation("androidx.media3:media3-session:1.1.0")

//    media
        implementation("com.google.android.exoplayer:exoplayer:2.18.1")

//Compose
        implementation("androidx.compose.ui:ui-android:1.5.1")
        implementation("androidx.compose.ui:ui-tooling:1.5.1")
        implementation("androidx.compose.material:material:1.5.4")
        implementation("androidx.compose.material:material-ripple:1.5.4")
        implementation("androidx.activity:activity-compose:1.7.1")
        implementation("androidx.compose.material3:material3-android:1.2.0-alpha12")

//    Coil
        //    coil
        implementation("io.coil-kt:coil-compose:2.4.0")


    }
}
