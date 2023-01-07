group = "io.github.emanuelmcp"
version = "unspecified"

plugins{
    id ("com.github.johnrengelman.shadow") version ("7.1.2")
}
dependencies {
    implementation(project(":database"))
    implementation(project(":api"))
}