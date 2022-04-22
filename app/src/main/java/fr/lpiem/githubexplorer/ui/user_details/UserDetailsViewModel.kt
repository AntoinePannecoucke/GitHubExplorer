package fr.lpiem.githubexplorer.ui.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.domain.GetAllUserUseCase
import fr.lpiem.githubexplorer.domain.GetUserDetailsUseCase
import kotlinx.coroutines.flow.Flow

class UserDetailsViewModel(
    useCase: GetUserDetailsUseCase
) : ViewModel() {

    var userId = 0

    val allRepository: Flow<PagingData<Repository>> = useCase(userId).cachedIn(viewModelScope)

}