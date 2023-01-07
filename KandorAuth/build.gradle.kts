plugins{
    java
}
subprojects{
    apply(plugin="java-library")
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://oss.sonatype.org/content/repositories/central")
    }
    dependencies{
        implementation("org.postgresql:postgresql:42.5.1")
        compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
        compileOnly ("org.projectlombok:lombok:1.18.24")
        annotationProcessor ("org.projectlombok:lombok:1.18.24")
        testCompileOnly ("org.projectlombok:lombok:1.18.24")
        testAnnotationProcessor ("org.projectlombok:lombok:1.18.24")
        implementation("com.google.inject:guice:5.1.0")
        implementation("org.jetbrains:annotations:23.1.0")
    }
}