plugins {
    id("java")
    id("java-library")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.lumine1909"
version = "alpha-1.2"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    implementation(project(":api"))
}
tasks {
    assemble {
        dependsOn(shadowJar)
    }
    shadowJar {
        exclude(":example-plugin")
        archiveFileName.set("RegistryAPI-$version.jar")
    }
    test {
        useJUnitPlatform()
    }
}
