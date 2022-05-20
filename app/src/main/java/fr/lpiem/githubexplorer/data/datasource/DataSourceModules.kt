package fr.lpiem.githubexplorer.data.datasource

import org.koin.dsl.module

object DataSourceModules {

    private val dataSourceModule = module {
        single<UserRemoteDataSource> {
            UserRemoteDataSourceImpl(get())
        }

        single<RepositoryRemoteDataSource> {
            RepositoryRemoteDataSourceImpl(get())
        }
    }

    val all = arrayOf(dataSourceModule)

}