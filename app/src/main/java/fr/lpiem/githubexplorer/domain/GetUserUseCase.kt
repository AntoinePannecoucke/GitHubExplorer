package fr.lpiem.githubexplorer.domain

import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.data.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(userId: Int): User {
        return userRepository.getUser(userId)
    }
}