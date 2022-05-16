package fr.lpiem.githubexplorer.domain

import androidx.paging.PagingData
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.data.repository.RepositoryRepository
import kotlinx.coroutines.flow.Flow

class GetUserDetailsUseCase(private val repositoryRepository: RepositoryRepository) {
    operator fun invoke(userId: Int): Flow<PagingData<Repository>> {
        return repositoryRepository.getUserDetails(userId)
    }
}