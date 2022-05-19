package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class RepositoryRemoteDataSourceImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*DataSourceModulesTest.all)
    }

    private val repositoryRemoteDataSource by inject<RepositoryRemoteDataSource>()

    @Test
    fun getRepositoriesOf() = runBlocking {
        val actual = repositoryRemoteDataSource.getRepositoriesOf(1, 2).getOrNull()
        val expected = Pair<Int, List<Repository>>(
            2,
            ObjectProvider.userTwoRepositoriesPageOne
        )
        assertEquals(expected, actual)
    }
}