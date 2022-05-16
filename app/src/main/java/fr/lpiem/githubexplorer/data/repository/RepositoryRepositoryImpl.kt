package fr.lpiem.githubexplorer.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.data.datasource.RepositoryRemoteDataSource
import fr.lpiem.githubexplorer.data.paging.RepositoryPagingSource
import kotlinx.coroutines.flow.Flow

class RepositoryRepositoryImpl (
    private val remoteDataSource: RepositoryRemoteDataSource
) : RepositoryRepository {

    override fun getUserDetails(userId: Int): Flow<PagingData<Repository>> {
        val pagingSource = RepositoryPagingSource(remoteDataSource)
        pagingSource.userId = userId
        return Pager(PagingConfig(20)) {
            pagingSource
        }.flow
    }

}