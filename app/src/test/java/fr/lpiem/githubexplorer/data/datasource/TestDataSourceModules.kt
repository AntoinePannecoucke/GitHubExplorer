package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.data.networking.NetworkingModules
import fr.lpiem.githubexplorer.data.paging.PagingModules
import fr.lpiem.githubexplorer.data.repository.RepositoryModules

object TestDataSourceModules {
    val all = arrayOf(*PagingModules.all, *DataSourceModules.all, *NetworkingModules.all)
}