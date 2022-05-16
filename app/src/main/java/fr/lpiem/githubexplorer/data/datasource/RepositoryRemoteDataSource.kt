package fr.lpiem.githubexplorer.data.datasource

import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.model.User

interface RepositoryRemoteDataSource {
    suspend fun getRepositoriesOf(pageNumber : Int, userId: Int) : Result<Pair<Int?, List<Repository>>>

}