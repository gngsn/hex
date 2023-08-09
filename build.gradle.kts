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
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // Database
    implementation("com.h2database:h2:2.1.214")

    // querydsl
    implementation ("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Testing tools
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
