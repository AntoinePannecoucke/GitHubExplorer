package fr.lpiem.githubexplorer.ui.user_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.lpiem.githubexplorer.R
import fr.lpiem.githubexplorer.ui.user_list.UserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserDetailsFragment : Fragment() {

    private val viewModel: UserDetailsViewModel by viewModel()

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
        Log.d(TAG, "${arguments?.getInt("userId")}")
    }

}