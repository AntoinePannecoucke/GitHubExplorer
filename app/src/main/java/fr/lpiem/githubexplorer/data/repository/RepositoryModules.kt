package fr.lpiem.githubexplorer.data.repository

import org.koin.dsl.module

object RepositoryModules {

    private val userRepositoryModule = module {
        single<UserRepository> {
            UserRepositoryImpl(get())
        }

        single<RepositoryRepository> {
            RepositoryRepositoryImpl(get())
        }
    }

    val all = arrayOf(userRepositoryModule)

}