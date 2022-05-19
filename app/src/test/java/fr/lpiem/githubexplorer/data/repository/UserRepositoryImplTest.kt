package fr.lpiem.githubexplorer.data.repository

import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class UserRepositoryImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*RepositoryModulesTest.all)
    }

    private val userRepository by inject<UserRepository>()

    @Test
    fun getPaginatedUser() {
    }

    @Test
    fun getUserOne() = runBlocking {

        val actual = userRepository.getUser(1)
        val expected = ObjectProvider.userOne

        Assert.assertEquals(expected, actual)
    }
}