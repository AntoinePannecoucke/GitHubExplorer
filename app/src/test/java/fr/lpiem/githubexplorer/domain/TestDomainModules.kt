package fr.lpiem.githubexplorer.domain

import fr.lpiem.githubexplorer.data.datasource.DataSourceModules
import fr.lpiem.githubexplorer.data.networking.NetworkingModules
import fr.lpiem.githubexplorer.data.paging.PagingModules
import fr.lpiem.githubexplorer.data.repository.RepositoryModules

object TestDomainModules {
    val all = arrayOf(*DomainModules.all, *RepositoryModules.all, *PagingModules.all, *DataSourceModules.all, *NetworkingModules.all)
}