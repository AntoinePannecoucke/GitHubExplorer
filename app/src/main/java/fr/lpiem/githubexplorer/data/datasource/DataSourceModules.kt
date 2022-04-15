package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.data.paging.UserPagingSource
import org.koin.dsl.module

object DataSourceModules {

    private val userDataSourceModule = module {
        single<UserRemoteDataSource> {
            UserRemoteDataSourceImpl(get())
        }
    }

    val all = arrayOf(userDataSourceModule)

}