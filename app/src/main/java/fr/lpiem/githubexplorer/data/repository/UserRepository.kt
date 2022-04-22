package fr.lpiem.githubexplorer.data.repository

import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getPaginatedUser(): Flow<PagingData<User>>
    suspend fun getUser(userId: Int) : User
}