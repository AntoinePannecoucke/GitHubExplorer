package fr.lpiem.githubexplorer.data.paging

import androidx.paging.PagingSource
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import fr.lpiem.githubexplorer.data.datasource.mock.MockDataSourceModulesTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class UserPagingSourceTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*PagingModulesTest.all)
    }

    private val userPagingSource by inject<UserPagingSource>()

    @Test
    fun load() = runBlocking {
        val expected = PagingSource.LoadResult.Page(
            data = ObjectProvider.usersSinceZero,
            prevKey = null,
            nextKey = 46
        )

        val actual = userPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        )

        assertEquals(expected, actual)
    }
}