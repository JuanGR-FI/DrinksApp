import com.android.build.gradle.internal.utils.isKspPluginApplied
import org.jetbrains.kotlin.load.java.javaToKotlinNameMap

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    //kotlin("kapt")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.drinksapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.drinksapp"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //Retrofit y Gson
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //ViewModel y LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.core.ktx)

    //Activity and Fragment extensions
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx.v182)

    //Coroutines
    //implementation(libs.kotlin.coroutines.android)

    //Room
    implementation(libs.androidx.room.ktx)
    ksp (libs.androidx.room.compiler)

    //Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Picasso
    implementation(libs.picasso)

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    ksp ("com.google.dagger:hilt-android-compiler:2.48")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
