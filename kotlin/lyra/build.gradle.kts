plugins {
    kotlin("multiplatform") version libs.versions.kotlin.get() apply false
    kotlin("android") version libs.versions.kotlin.get() apply false
    alias(libs.plugins.android.library) apply false
    idea
    `maven-publish`
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
