package fr.lpiem.githubexplorer.ui.user_list

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.ui.UserViewHolder

class UserListAdapter(
    diffCallback: DiffUtil.ItemCallback<User>
) : PagingDataAdapter<User, UserViewHolder>(diffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        return UserViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}