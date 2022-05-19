package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.core.model.User

interface UserRemoteDataSource {
    suspend fun getUsersSince(pageNumber : Int) : Result<Pair<Int?, List<User>>>
    suspend fun getUser(userId: Int) : Result<User>
}