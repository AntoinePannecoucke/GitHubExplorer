package fr.lpiem.githubexplorer.data.paging

import androidx.paging.PagingSource
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import fr.lpiem.githubexplorer.data.datasource.mock.MockDataSourceModulesTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class RepositoryPagingSourceTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*PagingModulesTest.all)
    }

    private val repositoryPagingSource by inject<RepositoryPagingSource>()

    @Test
    fun load() = runBlocking {
        val expected = PagingSource.LoadResult.Page(
            data = ObjectProvider.userTwoRepositoriesPageOne,
            prevKey = null,
            nextKey = 2
        )

        val actual = repositoryPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        )

        assertEquals(expected, actual)
    }
}