plugins {
    application
    kotlin("jvm") version "2.0.21"
}

repositories { mavenCentral() }

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

application { mainClass.set("com.example.game.MainKt") }

tasks.withType<JavaExec> {
    // 콘솔 한글 깨짐 방지(Windows)
    jvmArgs = listOf("-Dfile.encoding=UTF-8")
}

kotlin { jvmToolchain(17) }

tasks.test {
    useJUnitPlatform()
}