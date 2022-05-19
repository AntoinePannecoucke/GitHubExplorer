package fr.lpiem.githubexplorer.data.networking

import fr.lpiem.githubexplorer.core.manager.ResourcesManager
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals

class RepositoryNetworkingTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*NetworkingModulesTest.all)
    }

    private val server by inject<MockWebServer>()
    private val source by inject<RepositoryNetworkingService>()

    @Test
    fun getRepositoriesOfUser() = runBlocking {
        val expected = MockResponse().apply {
            setResponseCode(200)
            setBody(ResourcesManager.loadResource("json/get_user_two_repositories_page_one.json"))
        }
        server.enqueue(expected)

        val actual = source.getRepositoriesOfUser(2, 1).body()

        assertEquals(ObjectProvider.userTwoRepositoriesPageOne, actual)
    }

}