plugins {
    kotlin("jvm") version "1.4.10"
    id("io.gitlab.arturbosch.detekt") version "1.14.1"
}

group = "com.github.andrelugomes"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    "testImplementation"("junit:junit:4.13.1")
    "testImplementation"("org.assertj:assertj-core:3.17.2")
}
