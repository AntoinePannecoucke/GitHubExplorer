package fr.lpiem.githubexplorer.ui.user_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.databinding.ViewHolderRepositoryBinding
import fr.lpiem.githubexplorer.ui.user_list.RecyclerViewItemActions


class RepositoryViewHolder private constructor(
    private val binding : ViewHolderRepositoryBinding,
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(parent: ViewGroup) : RepositoryViewHolder {
            return RepositoryViewHolder(
                ViewHolderRepositoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(repository: Repository?){
        with(binding) {
            repositoryName.text = repository?.name
            starCount.text = "${repository?.stargazers_count}"
            languageName.text = repository?.language
            viewCount.text = "${repository?.watchers_count}"
        }
        binding.executePendingBindings()
    }
    
}