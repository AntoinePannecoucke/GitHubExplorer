package fr.lpiem.githubexplorer.ui.user_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import fr.lpiem.githubexplorer.R
import fr.lpiem.githubexplorer.core.model.Repository
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class UserDetailsFragment : Fragment() {

    private val viewModel: UserDetailsViewModel by viewModel { parametersOf(arguments?.getInt("userId") ?: 0)}
    private val pagingAdapter = RepositoryListAdapter(Repository)

    companion object {
        private const val TAG = "UserDetailsFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repositoriesRecyclerView = view.findViewById<RecyclerView>(R.id.user_repositories)
        repositoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(repositoriesRecyclerView)
        repositoriesRecyclerView.adapter = pagingAdapter

        lifecycleScope.launchWhenStarted {
            viewModel.allRepository.collectLatest {
                pagingAdapter.submitData(pagingData = it)
            }

        }

        viewModel.user.observe(viewLifecycleOwner) { user ->
            val userAvatarImageView : ImageView = view.findViewById(R.id.user_details_avatar_image_view)
            userAvatarImageView.load(user.avatar_url){
                transformations(CircleCropTransformation())
                size(500)
            }
            val userUsernameView : TextView = view.findViewById(R.id.user_details_login_text_view)
            userUsernameView.text = user.login
        }


    }

}