plugins {
    id("java")
    id("java-library")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.lumine1909"
version = "alpha-1.1"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:spigot:1.20.4-R0.1-SNAPSHOT")
    implementation(project(":api"))
}
tasks {
    assemble {
        dependsOn(shadowJar)
    }
    shadowJar {
        exclude(":exampleplugin")
        archiveFileName.set("RegistryAPI-alpha-1.1.jar")
    }
    test {
        useJUnitPlatform()
    }
}