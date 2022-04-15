package fr.lpiem.githubexplorer.data.repository

import org.koin.dsl.module

object RepositoryModules {

    private val userRepositoryModule = module {
        single<UserRepository> {
            UserRepositoryImpl(get())
        }
    }

    val all = arrayOf(userRepositoryModule)

}