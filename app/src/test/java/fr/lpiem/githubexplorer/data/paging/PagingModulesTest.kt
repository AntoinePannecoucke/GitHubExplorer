package fr.lpiem.githubexplorer.data.paging

import fr.lpiem.githubexplorer.data.datasource.mock.MockDataSourceModulesTest

object PagingModulesTest {
    val all = arrayOf(*PagingModules.all, *MockDataSourceModulesTest.all)
}