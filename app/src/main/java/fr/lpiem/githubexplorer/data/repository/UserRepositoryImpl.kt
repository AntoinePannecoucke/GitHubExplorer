package fr.lpiem.githubexplorer.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.data.datasource.UserRemoteDataSource
import fr.lpiem.githubexplorer.data.paging.UserPagingSource
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override fun getPaginatedUser(): Flow<PagingData<User>> {
        return Pager(PagingConfig(20)) {
            UserPagingSource(remoteDataSource)
        }.flow
    }

}