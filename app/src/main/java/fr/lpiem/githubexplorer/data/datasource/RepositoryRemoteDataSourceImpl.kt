package fr.lpiem.githubexplorer.data.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.lpiem.githubexplorer.BuildConfig
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.data.networking.RepositoryNetworkingService

class RepositoryRemoteDataSourceImpl(private val repositoryNetworkingService: RepositoryNetworkingService) :
    RepositoryRemoteDataSource {
    override suspend fun getRepositoriesOf(
        pageNumber: Int,
        userId: Int
    ): Result<Pair<Int?, List<Repository>>> {
        return try {
            val response = repositoryNetworkingService.getRepositoriesOfUser(userId, pageNumber)

            if (response.isSuccessful && response.body() != null) {
                val link = response.headers()["Link"]
                val links = link?.split(" ")

                var nextPage: Int? = null
                for (i in 0..(links?.size ?: 0) step 2) {
                    if (links?.get(i + 1)?.contains("rel=\"next\"") == true) {
                        nextPage =
                            links[i].removePrefix("<" + BuildConfig.BASE_URL + "/user/${userId}/repos?page=")
                                .removeSuffix(">;").let {
                                    Integer.parseInt(
                                        it
                                    )
                                }
                        break
                    }

                }

                val repositoryList = Gson().fromJson<List<Repository>>(
                    Gson().toJson(response.body()),
                    object : TypeToken<List<Repository>>() {}.type
                )

                return Result.success(Pair(nextPage, repositoryList ?: listOf()))
            } else throw IllegalStateException(response.message())
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}