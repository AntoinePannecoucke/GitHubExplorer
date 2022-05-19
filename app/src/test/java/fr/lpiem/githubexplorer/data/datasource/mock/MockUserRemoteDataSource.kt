package fr.lpiem.githubexplorer.data.datasource.mock

import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import fr.lpiem.githubexplorer.data.datasource.UserRemoteDataSource

class MockUserRemoteDataSource : UserRemoteDataSource {
    override suspend fun getUsersSince(pageNumber: Int): Result<Pair<Int?, List<User>>> {
        return Result.success(
            Pair(
                46,
                ObjectProvider.usersSinceZero
            )
        )
    }

    override suspend fun getUser(userId: Int): Result<User> {
        TODO("Not yet implemented")
    }
}