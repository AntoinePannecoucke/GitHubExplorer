package fr.lpiem.githubexplorer.ui.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.databinding.ViewHolderUserBinding

class UserViewHolder private constructor(
    private val binding: ViewHolderUserBinding,
    private val itemActions: RecyclerViewItemActions
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
    companion object {
        fun newInstance(parent: ViewGroup, itemActions: RecyclerViewItemActions): UserViewHolder {
            return UserViewHolder(
                ViewHolderUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                itemActions
            )
        }
    }

    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(user: User?) {
        binding.userLoginTextView.text = user?.login
        binding.userAvatarImageView.load(user?.avatar_url) {
            transformations(CircleCropTransformation())
            size(200)
        }
        binding.executePendingBindings()
    }

    override fun onClick(view: View?) {
        val position = absoluteAdapterPosition
        itemActions.onItemClicked(position)
    }
}