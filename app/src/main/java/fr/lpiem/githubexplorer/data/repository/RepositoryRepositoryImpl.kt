package fr.lpiem.githubexplorer.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.data.datasource.RepositoryRemoteDataSource
import fr.lpiem.githubexplorer.data.datasource.UserRemoteDataSource
import fr.lpiem.githubexplorer.data.paging.RepositoryPagingSource
import fr.lpiem.githubexplorer.data.paging.UserPagingSource
import kotlinx.coroutines.flow.Flow

class RepositoryRepositoryImpl (
    private val remoteDataSource: RepositoryRemoteDataSource
) : RepositoryRepository {

    override fun getUserDetails(userId: Int): Flow<PagingData<Repository>> {
        return Pager(PagingConfig(20)) {
            RepositoryPagingSource(remoteDataSource, userId)
        }.flow
    }

}