pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MylecE"
include(":app")
include(":eweek04a")
include(":eweek05a")
include(":eweek06a")
include(":dolldressup")
include(":eweek07a")
include(":eweek07b")
include(":week09")
include(":week10")
include(":broadcast")
include(":week12")
