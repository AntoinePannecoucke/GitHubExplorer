package fr.lpiem.githubexplorer.core.provider

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.lpiem.githubexplorer.core.manager.ResourcesManager
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.model.User

object ObjectProvider {

    val userOne: User = Gson().fromJson<User>(
        ResourcesManager.loadResource("json/get_user_one.json"),
        object : TypeToken<User>() {}.type
    )

    val usersSinceZero: List<User> = Gson().fromJson<List<User>>(
        ResourcesManager.loadResource("json/get_users_since_zero.json"),
        object : TypeToken<List<User>>() {}.type
    )

    val userTwoRepositoriesPageOne: List<Repository> = Gson().fromJson<List<Repository>>(
        ResourcesManager.loadResource("json/get_user_two_repositories_page_one.json"),
        object : TypeToken<List<Repository>>() {}.type
    )

}