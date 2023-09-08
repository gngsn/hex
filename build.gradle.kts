plugins {
    val kotlinVersion = "1.8.21"

    kotlin("jvm") version "1.8.20"
    kotlin("plugin.spring") version "1.3.61"
    kotlin("plugin.jpa") version "1.9.0"
    kotlin("kapt") version kotlinVersion

    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.2"
}

val queryDslVersion = "5.0.0"

group = "com.gngsn"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot modules
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Spring Cloud modules
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2022.0.1"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.1")

    // OCR
    implementation("net.sourceforge.tess4j:tess4j:5.8.0")

    // Database
    implementation("org.postgresql:postgresql")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // debugging
    implementation("p6spy:p6spy:3.9.1")

    // Testing tools
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.testcontainers:postgresql:1.18.0")
}

tasks.test {
    useJUnitPlatform()
}


kotlin {
    jvmToolchain(17)
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}