package fr.lpiem.githubexplorer.data.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.lpiem.githubexplorer.core.manager.TestResourcesManager
import fr.lpiem.githubexplorer.core.model.Repository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get

class RepositoryRemoteDataSourceImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*TestDataSourceModules.all)
    }

    @Test
    fun getRepositoriesOf() = runBlocking {
        val repositoryRemoteDataSource = get<RepositoryRemoteDataSource>()
        val actual = repositoryRemoteDataSource.getRepositoriesOf(1,2).getOrNull()
        val expected = Pair<Int, List<Repository>>(
            2,
            Gson().fromJson(TestResourcesManager.loadResource("json/get_user_two_repositories_page_one.json"), object : TypeToken<List<Repository>>() {}.type)
        )
        assertEquals(actual, expected)
    }
}