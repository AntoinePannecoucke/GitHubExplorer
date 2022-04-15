package fr.lpiem.githubexplorer.domain

import org.koin.dsl.module

object DomainModules {

    private val useCaseModule = module {
        factory {
            GetAllUserUseCase(get())
        }
    }

    val all = arrayOf(useCaseModule)

}