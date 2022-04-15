package fr.lpiem.githubexplorer.data.networking

import fr.lpiem.githubexplorer.core.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserNetworkingService {
    //#region User

    @GET("/users")
    suspend fun getAllUsersFromPage(
        @Query("since") since: Int?
    ) : Response<List<User>>

    //#endregion
}