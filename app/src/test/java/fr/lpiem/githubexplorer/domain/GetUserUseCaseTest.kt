package fr.lpiem.githubexplorer.domain

import fr.lpiem.githubexplorer.core.provider.ObjectProvider
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
        modules(*DomainModulesTest.all)
    }

    @Test
    operator fun invoke() = runBlocking {

        val getUserUseCase = get<GetUserUseCase>()
        val actual = getUserUseCase(1)
        val expected = ObjectProvider.userOne

        assertEquals(expected, actual)
    }
}