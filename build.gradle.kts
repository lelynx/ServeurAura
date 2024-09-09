plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("io.ktor.plugin") version "2.3.3"
}

application {
    mainClass.set("com.aura.MainKt")
}

group = "com.aura"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")

    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0-RC")

    implementation("io.ktor:ktor-server-cors:2.3.3")
    implementation("io.ktor:ktor-server-swagger:2.3.3")

    testImplementation(kotlin("test"))

    // POur les traces
    implementation("ch.qos.logback:logback-classic:1.2.11")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}