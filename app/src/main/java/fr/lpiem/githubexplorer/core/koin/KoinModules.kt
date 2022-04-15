package fr.lpiem.githubexplorer.core.koin

import org.koin.dsl.module

object KoinModules {
    private val productionModules = module {

    }

    val all = arrayOf(productionModules)
}