plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.serialization") version "2.2.20"  // Добавьте эту строку
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")  // Добавьте эту строку
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(24)
}