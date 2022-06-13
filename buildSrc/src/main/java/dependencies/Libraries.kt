package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import dependencies.android.*
import dependencies.kotlin.*
import dependencies.retrofit_okhttp.*

fun DependencyHandler.appLibraries() {
    androidCore()
    materialDesign()
    testUnit()
    retrofit()
    okHttp()
    gson()
    coroutine()
    vmLifecycle()
    androidX()
    daggerHilt()
    glide()
    androidPaging()
    gander()
    navGraph()
}