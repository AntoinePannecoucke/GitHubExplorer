package fr.lpiem.githubexplorer.data.paging

import org.koin.dsl.module

object PagingModules {

    private val pagingModule = module {
        single {
            UserPagingSource(get())
        }

        single {
            RepositoryPagingSource(get())
        }
    }

    val all = arrayOf(pagingModule)

}