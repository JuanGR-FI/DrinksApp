package com.example.drinksapp.ui.view.fragments

import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.drinksapp.R
import com.example.drinksapp.data.model.UserProvider
import com.example.drinksapp.databinding.FragmentLoginBinding
import com.example.drinksapp.ui.viewmodel.UserViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
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

        userViewModel.user.observe(viewLifecycleOwner, Observer { currentUser ->
            if (currentUser != null) {
                //findNavController().navigate(R.id.action_loginFragment_to_drinksFragment)
                Toast.makeText(requireContext(), "Usuario valido", Toast.LENGTH_SHORT).show()
            } else {
                showUserNotRegisteredDialog()
            }
        })

        binding.btnLogin.setOnClickListener {
            userViewModel.getUserByName(
                etUserName.text.toString().trim(),
                etPassword.text.toString().trim()
            )

            //******************** REGISTRO DE PRUEBA ****************//
            /*userViewModel.registerUser(
                etUserName.text.toString().trim(),
                etPassword.text.toString().trim()
            )*/
            //*******************************************************//
        }

        binding.btnExit.setOnClickListener {
            showExitDialog()
        }

    }

    private fun showUserNotRegisteredDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Usuario no encontrado!")
            .setMessage("Usuario y contraseña incorrectos, intente de nuevo.")
            .setNeutralButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showExitDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Aviso!")
            .setMessage("¿Deseas salir de la aplicación?")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
                activity?.finish()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}