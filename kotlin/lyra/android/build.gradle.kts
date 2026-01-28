plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "kr.alpha93.lyra.android"
    compileSdk {
        val versions = libs.versions.android.target.get().split('.').map { it.toInt() }
        version = release(versions.first()) { minorApiLevel = versions.last() }
    }

    defaultConfig {
        minSdk {
            val versions = libs.versions.android.min.get().split('.').map { it.toInt() }
            version = release(versions.first())
        }
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":java"))
}
