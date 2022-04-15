package fr.lpiem.githubexplorer.domain

import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetAllUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(): Flow<PagingData<User>> {
        return userRepository.getPaginatedUser()
    }
}