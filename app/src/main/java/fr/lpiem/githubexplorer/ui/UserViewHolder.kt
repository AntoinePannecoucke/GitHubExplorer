package fr.lpiem.githubexplorer.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import fr.lpiem.githubexplorer.R
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.databinding.ViewHolderUserBinding

class UserViewHolder private constructor(
    private val binding : ViewHolderUserBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(parent: ViewGroup) : UserViewHolder{
            return UserViewHolder(
                ViewHolderUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(user: User?){
        binding.userLoginTextView.text = user?.login
        binding.userAvatarImageView.load(user?.avatar_url){
            transformations(CircleCropTransformation())
            placeholder(R.drawable.ic_outline_image_24)
            size(200)
        }
        binding.executePendingBindings()
    }
}