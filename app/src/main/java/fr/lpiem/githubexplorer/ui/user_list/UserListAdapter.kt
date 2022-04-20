package fr.lpiem.githubexplorer.ui.user_list

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import fr.lpiem.githubexplorer.core.model.User

class UserListAdapter(
    diffCallback: DiffUtil.ItemCallback<User>,
    private val itemActions: RecyclerViewItemActions
) : PagingDataAdapter<User, UserViewHolder>(diffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        return UserViewHolder.newInstance(parent, itemActions)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}