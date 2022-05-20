package fr.lpiem.githubexplorer.data.repository

import fr.lpiem.githubexplorer.data.datasource.DataSourceModules
import fr.lpiem.githubexplorer.data.networking.NetworkingModules
import fr.lpiem.githubexplorer.data.paging.PagingModules

object RepositoryModulesTest {
    val all = arrayOf(
        *RepositoryModules.all,
        *PagingModules.all,
        *DataSourceModules.all,
        *NetworkingModules.all
    )
}