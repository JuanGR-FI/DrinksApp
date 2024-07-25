package com.example.drinksapp.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.drinksapp.R
import com.example.drinksapp.data.model.UserProvider
import com.example.drinksapp.databinding.FragmentLoginBinding
import com.example.drinksapp.ui.viewmodel.UserViewModel

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareUI()
    }

    private fun prepareUI() {
        val etUserName = binding.etUser
        val etPassword = binding.etPassword

        etUserName.doOnTextChanged { _, _, _, _ ->
            binding.ilUser.error = null
        }

        etPassword.doOnTextChanged { _, _, _, _ ->
            binding.ilPassword.error = null
        }

        userViewModel.isNameValid.observe(viewLifecycleOwner, Observer { nameFlag ->
            if (!nameFlag)
                binding.ilUser.error = getString(R.string.invalid_field_error_text)
        })

        userViewModel.isPasswordValid.observe(viewLifecycleOwner, Observer { passwdFlag ->
            if (!passwdFlag)
                binding.ilPassword.error = getString(R.string.invalid_field_error_text)
        })

        binding.btnLogin.setOnClickListener {
            userViewModel.validateFields(
                etUserName.text.toString().trim(),
                etPassword.text.toString().trim()
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}