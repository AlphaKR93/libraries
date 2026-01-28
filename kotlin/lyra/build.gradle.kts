plugins {
    kotlin("multiplatform") version libs.versions.kotlin.get() apply false
    alias(libs.plugins.android.library.multiplatform) apply false
    alias(libs.plugins.android.library) apply false
    idea
}

idea {
    module {
        isDownloadSources = true
	isDownloadJavadoc = true
    }
}
