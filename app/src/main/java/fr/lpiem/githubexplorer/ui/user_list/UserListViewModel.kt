package fr.lpiem.githubexplorer.ui.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.domain.GetAllUserUseCase
import kotlinx.coroutines.flow.Flow

class UserListViewModel(
    useCase: GetAllUserUseCase
) : ViewModel() {

    val allUser: Flow<PagingData<User>> = useCase().cachedIn(viewModelScope)

}