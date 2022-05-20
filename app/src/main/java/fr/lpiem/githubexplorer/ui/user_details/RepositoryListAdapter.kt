package fr.lpiem.githubexplorer.ui.user_details

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import fr.lpiem.githubexplorer.core.model.Repository


class RepositoryListAdapter(
    diffCallback: DiffUtil.ItemCallback<Repository>,
) : PagingDataAdapter<Repository, RepositoryViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        return RepositoryViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}