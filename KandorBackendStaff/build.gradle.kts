plugins {
	java
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "io.github.emanuelmcp"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.zaxxer:HikariCP:5.0.1")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains:annotations:23.0.0")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
