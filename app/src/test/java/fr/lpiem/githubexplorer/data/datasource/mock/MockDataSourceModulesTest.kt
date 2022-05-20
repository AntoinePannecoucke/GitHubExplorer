package fr.lpiem.githubexplorer.data.datasource.mock

import fr.lpiem.githubexplorer.data.datasource.RepositoryRemoteDataSource
import fr.lpiem.githubexplorer.data.datasource.UserRemoteDataSource
import org.koin.dsl.module

object MockDataSourceModulesTest {
    private val mockDataSourceModule = module {
        single<UserRemoteDataSource> {
            MockUserRemoteDataSource()
        }

        single<RepositoryRemoteDataSource> {
            MockRepositoryRemoteDataSource()
        }
    }

    val all = arrayOf(mockDataSourceModule)
}