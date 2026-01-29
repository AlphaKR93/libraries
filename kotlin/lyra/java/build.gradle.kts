plugins {
    `java-library`
    `maven-publish`
}

dependencies {
    api(libs.jspecify)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            artifactId = "java"
            groupId = rootProject.group.toString()
            version = rootProject.version.toString()
            from(components["java"])
        }
    }
}
