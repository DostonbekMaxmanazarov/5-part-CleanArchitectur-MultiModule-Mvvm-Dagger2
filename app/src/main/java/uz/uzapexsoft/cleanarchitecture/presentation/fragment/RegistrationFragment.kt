package uz.uzapexsoft.cleanarchitecture.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.uzapexsoft.cleanarchitecture.R
import uz.uzapexsoft.cleanarchitecture.application.App
import uz.uzapexsoft.cleanarchitecture.databinding.FragmentRegistrationBinding
import uz.uzapexsoft.cleanarchitecture.presentation.utils.extensions.replaceFragment
import uz.uzapexsoft.cleanarchitecture.presentation.vm.RegistrationViewModel
import javax.inject.Inject

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var vm: RegistrationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentRegistrationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        clickView()
        observeData()
    }

    private fun clickView() = binding.apply {
        btnSaveData.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            vm.registration(email = email, password = password, phoneNumber = phoneNumber, confirmPassword = confirmPassword)
        }

        tvLogin.setOnClickListener {
            replaceFragment(container = R.id.container, fragment = LoginFragment(), addToBackStack = true)
        }
    }

    private fun observeData() {
        vm.resultLiveData.observe(viewLifecycleOwner) { success ->
            if (success) Toast.makeText(requireContext(), R.string.success, Toast.LENGTH_SHORT).show()
            else Toast.makeText(requireContext(), R.string.failed, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}