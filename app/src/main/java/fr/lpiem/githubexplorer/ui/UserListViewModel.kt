package fr.lpiem.githubexplorer.ui

import androidx.lifecycle.ViewModel
import fr.lpiem.githubexplorer.domain.GetAllUserUseCase

class UserListViewModel(private val useCase : GetAllUserUseCase) : ViewModel() {
}