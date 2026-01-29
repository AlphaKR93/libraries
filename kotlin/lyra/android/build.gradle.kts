plugins {
    alias(libs.plugins.android.library)
    kotlin("android")
    `maven-publish`
}

val minTarget = libs.versions.android.min.get().split('.').map { it.toInt() }
val compileTarget = libs.versions.android.compile.get().split('.').map { it.toInt() }

kotlin {
    jvmToolchain(11)
    explicitApi()
}

android {
    namespace = "kr.alpha93.lyra"
    compileSdk {
        version = release(compileTarget.first()) { minorApiLevel = compileTarget.last() }
    }

    defaultConfig {
        minSdk {
            version = release(minTarget.first())
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

    publishing {
        singleVariant("release") {
            withSourcesJar()
            //withJavadocJar()
        }
    }
}

dependencies {
    api(project(":shared"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            artifactId = "android"
            groupId = rootProject.group.toString()
            version = rootProject.version.toString()

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}