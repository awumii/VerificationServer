plugins {
    id("java")
}

group = "me.awumii"
version = "3.0"

repositories {
    mavenCentral()
}

tasks.withType<Jar>() {
    manifest {
        attributes["Main-Class"] = "me.awumii.VerificationServer"
        attributes["Premain-Class"] = "me.awumii.Agent"
    }
}
