package fr.lpiem.githubexplorer.data.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.lpiem.githubexplorer.core.manager.TestResourcesManager
import fr.lpiem.githubexplorer.core.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get

class UserRepositoryImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*TestRepositoryModules.all)
    }

    @Test
    fun getPaginatedUser() {
    }

    @Test
    fun getUser() = runBlocking {

        val userRepository = get<UserRepository>()
        val actual = userRepository.getUser(1)
        val expected = Gson().fromJson<User>(TestResourcesManager.loadResource("json/get_user_one.json"), object : TypeToken<User>() {}.type)

        Assert.assertEquals(expected, actual)
    }
}