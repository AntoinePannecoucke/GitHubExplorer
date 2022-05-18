package fr.lpiem.githubexplorer.domain

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.lpiem.githubexplorer.core.manager.TestResourcesManager
import fr.lpiem.githubexplorer.core.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get

class GetUserUseCaseTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*TestDomainModules.all)
    }


    @Test
    operator fun invoke() = runBlocking {

        val getUserUseCase = get<GetUserUseCase>()
        val actual = getUserUseCase(1)
        val expected = Gson().fromJson<User>(TestResourcesManager.loadResource("json/get_user_one.json"), object : TypeToken<User>() {}.type)

        assertEquals(expected, actual)
    }
}