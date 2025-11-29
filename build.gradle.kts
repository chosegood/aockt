plugins {
    kotlin("jvm") version "2.2.21"
}

group = "com.github.chosegood"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.hamcrest:hamcrest:3.0")
    testImplementation("io.strikt:strikt-core:0.34.0")
}

tasks {
    test { useJUnitPlatform() }
    wrapper { gradleVersion = "9.2.0"}
}

kotlin {
    jvmToolchain(21)
}