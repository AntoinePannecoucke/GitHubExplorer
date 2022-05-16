package fr.lpiem.githubexplorer.ui.user_details

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.domain.GetUserDetailsUseCase
import fr.lpiem.githubexplorer.domain.GetUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    val userId: Int,
    repositoryUseCase: GetUserDetailsUseCase,
    userUseCase: GetUserUseCase
) : ViewModel() {

    val allRepository: Flow<PagingData<Repository>> = repositoryUseCase(userId).cachedIn(viewModelScope)

    val user : LiveData<User> = liveData {
        emit(userUseCase(userId))
    }


}