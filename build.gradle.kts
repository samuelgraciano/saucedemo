plugins {
    java
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.2.1"
}

group = "com.saucedemo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val serenityVersion = "4.2.1"
val cucumberVersion = "7.18.1"

dependencies {
    implementation("net.serenity-bdd:serenity-core:$serenityVersion")
    implementation("net.serenity-bdd:serenity-screenplay:$serenityVersion")
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityVersion")
    implementation("org.slf4j:slf4j-simple:2.0.13")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    testImplementation("net.serenity-bdd:serenity-cucumber:$serenityVersion")
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")
    testImplementation("org.junit.platform:junit-platform-suite:1.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    systemProperties(System.getProperties().mapKeys { it.key.toString() })
    testLogging.showStandardStreams = true
    finalizedBy("aggregate")
}
