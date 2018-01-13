build.gradle
http://tutorials.jenkov.com/gradle/gradle-tutorial.html
Build Java code
-----------------------
apply plugin: 'java'

gradle tasks

gradle build

repositories {
    mavenCentral()
}

jar {
    baseName = 'gs-gradle'
    version =  '0.1.0'
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile "joda-time:joda-time:2.2"
    testCompile "junit:junit:4.12"
}
