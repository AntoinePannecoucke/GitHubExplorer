package fr.lpiem.githubexplorer.core.manager

import java.io.File

object TestResourcesManager {

    /** Resources URL */
    private const val RESOURCES_URI = "src/test/java/fr/lpiem/githubexplorer/resources/"

    fun loadResource(filename: String): String {
        return File(
            RESOURCES_URI,
            filename
        ).readText()
    }
}