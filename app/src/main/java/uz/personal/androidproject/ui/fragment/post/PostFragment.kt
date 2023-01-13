package uz.personal.androidproject.ui.fragment.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.personal.androidproject.R
import uz.personal.androidproject.databinding.FragmentPostBinding
import uz.personal.androidproject.ui.adapter.PostAdapter
import uz.personal.androidproject.ui.fragment.main.UserMainFragmentViewModel
import uz.personal.domain.model.PostUseCaseData


@AndroidEntryPoint
class PostFragment : Fragment(), PostAdapter.OnItemMainClickListener {
    private val viewModel: PostViewModel by viewModels()
    private var _binding: FragmentPostBinding? = null
    private val binding get() = requireNotNull(_binding)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = arguments?.get("userId") as Int

        viewModel.getPost(userId)

        binding.apply {
            recyclerview.layoutManager = LinearLayoutManager(requireContext())

            viewModel.postListLiveData.observe(viewLifecycleOwner) {
                progressCircular.visibility = View.GONE
                recyclerview.adapter = PostAdapter(it, this@PostFragment)
            }

            imageUser.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("userId", userId)
                findNavController().navigate(R.id.action_fragment_post_to_fragment_info, bundle)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemMainClickListener(userMainPageData: PostUseCaseData) {

    }
}