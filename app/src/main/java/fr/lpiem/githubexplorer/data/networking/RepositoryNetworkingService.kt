package fr.lpiem.githubexplorer.data.networking

import fr.lpiem.githubexplorer.core.model.Repository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepositoryNetworkingService {

    @GET("/user/{userId}/repos")
    suspend fun getRepositoriesOfUser(
        @Path("userId") userId: Int,
        @Query("page") page: Int?
    ): Response<List<Repository>>

}