package fr.lpiem.githubexplorer.data.repository

import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.Repository
import kotlinx.coroutines.flow.Flow

interface RepositoryRepository {
    fun getUserDetails(userId: Int): Flow<PagingData<Repository>>
}