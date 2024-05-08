plugins {
    id("java")
    id("maven-publish")
}

group = "io.github.lumine1909"
version = "alpha-1.2"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Lumine1909/RegistryAPI")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("NAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId = "io.github.lumine1909"
            artifactId = "registry-api"
            version = "alpha-1.2"
            from(components["java"])
        }
    }
}