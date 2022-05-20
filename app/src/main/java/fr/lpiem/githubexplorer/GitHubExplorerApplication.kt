package fr.lpiem.githubexplorer

import android.app.Application
import fr.lpiem.githubexplorer.data.datasource.DataSourceModules
import fr.lpiem.githubexplorer.data.networking.NetworkingModules
import fr.lpiem.githubexplorer.data.paging.PagingModules
import fr.lpiem.githubexplorer.data.repository.RepositoryModules
import fr.lpiem.githubexplorer.domain.DomainModules
import fr.lpiem.githubexplorer.ui.UIModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubExplorerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@GitHubExplorerApplication)
            // declare modules
            modules(
                *UIModules.all,
                *DomainModules.all,
                *RepositoryModules.all,
                *PagingModules.all,
                *DataSourceModules.all,
                *NetworkingModules.all
            )
        }
    }
}