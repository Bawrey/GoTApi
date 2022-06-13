package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dep:String) {
    add("implementation", dep)
}

fun DependencyHandler.testImplementation(dep: String) {
    add("testImplementation", dep)
}

fun DependencyHandler.androidTestImplementation(dep: String) {
    add("androidTestImplementation", dep)
}

fun DependencyHandler.annotationProcessor(dep: String) {
    add("annotationProcessor",dep)
}

fun DependencyHandler.kapt(dep: String) {
    add("kapt",dep)
}