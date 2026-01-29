plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    jvm()

    explicitApi()
    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(kotlin("stdlib"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        jvmMain.dependencies {
            api(project(":java"))

            implementation(kotlin("reflect"))
        }
    }
}
