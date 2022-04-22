package fr.lpiem.githubexplorer.ui.user_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.load
import fr.lpiem.githubexplorer.R
import fr.lpiem.githubexplorer.ui.user_list.UserListViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class UserDetailsFragment : Fragment() {

    private val viewModel: UserDetailsViewModel by viewModel { parametersOf(arguments?.getInt("userId") ?: 0)}

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
        Log.d(TAG, "onViewCreated:")

        lifecycleScope.launchWhenStarted {
            viewModel.allRepository.collectLatest {

            }

            viewModel.user.collectLatest {
                val userAvatarImageView : ImageView = view.findViewById(R.id.user_details_avatar_image_view)
                userAvatarImageView.load(it.avatar_url)
            }
        }

    }

}