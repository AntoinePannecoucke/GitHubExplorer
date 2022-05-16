package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.core.model.User

interface UserRemoteDataSource {
    suspend fun getUsersAtPage(pageNumber : Int) : Result<Pair<Int?, List<User>>>
    suspend fun getUser(userId: Int) : Result<User>
}