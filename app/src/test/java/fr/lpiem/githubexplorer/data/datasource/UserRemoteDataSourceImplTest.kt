package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class UserRemoteDataSourceImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*DataSourceModulesTest.all)
    }

    private val userRemoteDataSource by inject<UserRemoteDataSource>()

    @Test
    fun getUsersSince() = runBlocking {
        val actual = userRemoteDataSource.getUsersSince(0).getOrNull()
        val expected = Pair<Int, List<User>>(
            46,
            ObjectProvider.usersSinceZero
        )
        assertEquals(expected, actual)
    }

    @Test
    fun getUserOne() = runBlocking {

        val actual = userRemoteDataSource.getUser(1).getOrNull()
        val expected = ObjectProvider.userOne

        assertEquals(expected, actual)
    }
}