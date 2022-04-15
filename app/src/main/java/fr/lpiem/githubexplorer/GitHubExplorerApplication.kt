package fr.lpiem.githubexplorer

import android.app.Application
import fr.lpiem.githubexplorer.core.koin.KoinModules
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
            modules(*KoinModules.all)
        }
    }
}