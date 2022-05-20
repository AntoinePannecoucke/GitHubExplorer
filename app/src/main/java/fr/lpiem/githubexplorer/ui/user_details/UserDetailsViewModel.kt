package fr.lpiem.githubexplorer.ui.user_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.domain.GetUserDetailsUseCase
import fr.lpiem.githubexplorer.domain.GetUserUseCase
import kotlinx.coroutines.flow.Flow

class UserDetailsViewModel(
    val userId: Int,
    repositoryUseCase: GetUserDetailsUseCase,
    userUseCase: GetUserUseCase
) : ViewModel() {

    val allRepository: Flow<PagingData<Repository>> =
        repositoryUseCase(userId).cachedIn(viewModelScope)

    val user: LiveData<User> = liveData {
        emit(userUseCase(userId))
    }


}