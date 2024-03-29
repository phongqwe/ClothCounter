import com.google.protobuf.gradle.id

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.protobuf") version "0.9.4"
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.24.1"
    }

    generateProtoTasks {
        all().forEach {task->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}
android {
    namespace = "com.example.clothcounter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.clothcounter"
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
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions{
        unitTests {
            this.isIncludeAndroidResources = true
        }
    }

}


kapt {
    correctErrorTypes = true
}


dependencies {
    testImplementation("io.mockk:mockk:1.12.3")
    implementation("androidx.compose.material:material:1.6.3")
    implementation ("com.google.android.material:material:1.11.0")

    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")

    testImplementation("com.google.dagger:hilt-android-testing:2.46")
    kaptTest("com.google.dagger:hilt-android-compiler:2.46")
    testImplementation("org.robolectric:robolectric:4.11.1")

    testImplementation("io.kotest:kotest-assertions-core:5.8.0")
    testImplementation(kotlin("test"))
    implementation("androidx.datastore:datastore:1.0.0")
    implementation  ("com.google.protobuf:protobuf-javalite:3.24.1")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
