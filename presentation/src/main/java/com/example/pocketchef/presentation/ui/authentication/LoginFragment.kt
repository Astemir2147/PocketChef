package com.example.pocketchef.presentation.ui.authentication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar

import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.pocketchef.presentation.R
import com.example.pocketchef.presentation.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import model.AuthDateUser

class LoginFragment : Fragment() {
    private val navController by lazy {
        Navigation.findNavController(
            requireActivity(),
            R.id.nav_host_fragment_activity_main
        )
    }

    private var loginBinding: FragmentLoginBinding? = null
    private val binding get() = loginBinding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth


        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authAsGuest.setOnClickListener { successAuth() }
        binding.loginButton.setOnClickListener {
            binding.root.hideKeyboard()
            signIn() }
    }

    private fun getAuthenticateUser(): AuthDateUser {
        val email = binding.loginLoginEditText.text.toString()
        val password = binding.loginPasswordEditText.text.toString()
        return AuthDateUser(email, password)
    }

    private fun successAuth() {
        findNavController().navigate(R.id.navigation_home)
    }

    private fun signIn() {

        val user = getAuthenticateUser()
        auth.signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener(requireActivity())
        { task ->
            if (task.isSuccessful) {
                auth.currentUser
                successAuth()
            }
            else toast("fail")
        }
    }
    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
    private fun toast(message: String) {

       Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}