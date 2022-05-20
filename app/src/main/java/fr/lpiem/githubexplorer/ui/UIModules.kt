package fr.lpiem.githubexplorer.ui

import fr.lpiem.githubexplorer.ui.user_details.UserDetailsViewModel
import fr.lpiem.githubexplorer.ui.user_list.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {

    private val userListModule = module {
        viewModel {
            UserListViewModel(get())
        }
        viewModel { parameters ->
            UserDetailsViewModel(userId = parameters.get(), get(), get())
        }
    }

    val all = arrayOf(userListModule)
}