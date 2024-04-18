plugins {
    id("java")
}

group = "io.github.lumine1909"
version = "1.1"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}