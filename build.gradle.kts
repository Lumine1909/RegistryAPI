plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.lumine1909"
version = "alpha-1.1"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven {
        name = "OSSRH"
        url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
        credentials {
            username = System.getenv("MAVEN_USERNAME")
            password = System.getenv("MAVEN_PASSWORD")
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
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