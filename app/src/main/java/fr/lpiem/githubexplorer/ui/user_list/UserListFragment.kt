package fr.lpiem.githubexplorer.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import fr.lpiem.githubexplorer.R
import fr.lpiem.githubexplorer.core.model.User
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.http.POST


class UserListFragment : Fragment(), RecyclerViewItemActions {

    companion object {
        private const val TAG = "UserListFragment"
    }

    private val viewModel: UserListViewModel by viewModel()
    private val pagingAdapter = UserListAdapter(User.Companion, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.user_recycler_view)
        recyclerView.adapter = pagingAdapter

        lifecycleScope.launchWhenStarted {
            viewModel.allUser.collectLatest {
                Log.i(TAG, "onViewCreated: $it")
                pagingAdapter.submitData(pagingData = it)
            }
        }

    }

    override fun onItemClicked(position: Int) {
        pagingAdapter.snapshot()[position]?.login?.let { Log.d(TAG, it) }
    }

}