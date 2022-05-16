package fr.lpiem.githubexplorer.core.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("language") val language : String,
    @SerializedName("stargazers_count") val stargazers_count : Int,
    @SerializedName("watchers_count") val watchers_count : Int,
    @SerializedName("owner") val owner : User
) {
    companion object : DiffUtil.ItemCallback<Repository>(){
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem == newItem
        }
    }
}

