package uz.personal.androidproject.ui.fragment.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.personal.androidproject.R
import uz.personal.androidproject.databinding.FragmentUserPageBinding
import uz.personal.androidproject.ui.adapter.UserAdapter
import uz.personal.domain.model.UserPageData


@AndroidEntryPoint
class UserFragmentPage : Fragment(), UserAdapter.OnItemMainClickListener {
    private var _binding: FragmentUserPageBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: UserMainFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()

        binding.apply {
            recyclerview.layoutManager = LinearLayoutManager(requireContext())

            viewModel.userList.observe(viewLifecycleOwner) {
                Log.d(TAG, "onViewCreatedListData: $it")
                recyclerview.adapter = UserAdapter(it, this@UserFragmentPage)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemMainClickListener(userMainPageData: UserPageData) {
        val bundle = Bundle()
        bundle.putInt("userId", userMainPageData.userId)
        findNavController().navigate(R.id.action_home_fragment_to_fragment_post, bundle)
    }
}