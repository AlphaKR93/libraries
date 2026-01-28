plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library.multiplatform)
}

kotlin {
    explicitApi()

    jvm()
    androidLibrary {
        namespace = "kr.alpha93.lyra"
        compileSdk = libs.versions.android.target.get().split('.').first().toInt()
        minSdk = libs.versions.android.min.get().split('.').first().toInt()

        withJava()
        withHostTestBuilder {}.configure {}
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
                optIn.add("-Xexpect-actual-classes")
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(kotlin("stdlib"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
