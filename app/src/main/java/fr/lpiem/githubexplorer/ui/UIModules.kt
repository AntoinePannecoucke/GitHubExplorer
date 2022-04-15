package fr.lpiem.githubexplorer.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {

    private val userListModule = module {
        viewModel {
            UserListViewModel(get())
        }
    }

    val all = arrayOf(userListModule)
}