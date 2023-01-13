package uz.personal.androidproject.ui.fragment.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.personal.androidproject.R
import uz.personal.androidproject.databinding.FragmentUserBinding
import uz.personal.androidproject.ui.fragment.main.UserMainFragmentViewModel


@AndroidEntryPoint
class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: UserInfoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = arguments?.get("userId") as Int
        viewModel.getUserById(userId)

        binding.apply {
            viewModel.user.observe(viewLifecycleOwner) {
                txtName.text = it.name
                txtEmail.text = it.email
                txtPhone.text = it.phone
                txtUsername.text = it.userName
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}