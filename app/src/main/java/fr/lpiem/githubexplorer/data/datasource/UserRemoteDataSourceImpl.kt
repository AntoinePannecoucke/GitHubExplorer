package fr.lpiem.githubexplorer.data.datasource

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.lpiem.githubexplorer.BuildConfig
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.data.networking.UserNetworkingService
import java.lang.IllegalStateException

class UserRemoteDataSourceImpl(private val userNetworkingService : UserNetworkingService) : UserRemoteDataSource {

    companion object {
        private const val TAG = "UserRemoteDataSourceImp"
    }

    override suspend fun getUsersAtPage(pageNumber: Int): Result<Pair<Int?, List<User>>> {
        return try {
            val response = userNetworkingService.getAllUsersFromPage(pageNumber)

            if (response.isSuccessful && response.body() != null){
                val link = response.headers()["Link"]
                val links = link?.split(" ")

                val nextPage = links?.get(0)?.removePrefix("<" + BuildConfig.BASE_URL + "/users?since=")
                    ?.removeSuffix(">;")?.let {
                        Integer.parseInt(
                            it
                        )
                    }


                val userList = Gson().fromJson<List<User>>(
                    Gson().toJson(response.body()),
                    object : TypeToken<List<User>>() {}.type
                )

                return Result.success(Pair(nextPage, userList ?: listOf()))
            }
            else throw IllegalStateException(response.message())
        }
        catch (t: Throwable){
            Result.failure(t)
        }
    }
}