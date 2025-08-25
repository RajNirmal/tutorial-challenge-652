plugins {
  kotlin("jvm") version "2.1.21"
  application
}

repositories {
  google()
  mavenCentral()
}

dependencies {
}

application {
  mainClass.set("track.AppKt")
}

val jar by tasks.getting(Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
    	attributes["Main-Class"] = "track.AppKt"
    }
    configurations["runtimeClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}