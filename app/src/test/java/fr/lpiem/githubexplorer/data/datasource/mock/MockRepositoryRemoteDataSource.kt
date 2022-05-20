package fr.lpiem.githubexplorer.data.datasource.mock

import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.provider.ObjectProvider
import fr.lpiem.githubexplorer.data.datasource.RepositoryRemoteDataSource

class MockRepositoryRemoteDataSource : RepositoryRemoteDataSource {
    override suspend fun getRepositoriesOf(
        pageNumber: Int,
        userId: Int
    ): Result<Pair<Int?, List<Repository>>> {
        return Result.success(
            Pair(
                2,
                ObjectProvider.userTwoRepositoriesPageOne
            )
        )
    }
}