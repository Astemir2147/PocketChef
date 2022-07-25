package com.example.pocketchef.presentation.ui.authentication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.core.App
import com.example.core.extension.showSnackBar
import com.example.pocketchef.presentation.R
import com.example.pocketchef.presentation.databinding.FragmentLoginBinding
import com.example.pocketchef.presentation.ui.di.DaggerPresentationComponent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.example.pocketchef.data.db.model.AuthDateUser
import javax.inject.Inject

class LoginFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val postsViewModel: LoginViewModel by navGraphViewModels(R.id.mobile_navigation) { factory }
    private var loginBinding: FragmentLoginBinding? = null
    private val binding get() = loginBinding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var loginViewModel: LoginViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerPresentationComponent.builder()
            .coreComponent(App.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this, factory)
            .get(LoginViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authAsGuest.setOnClickListener { successAuth() }
        binding.loginButton.setOnClickListener {
            binding.root.hideKeyboard()
            signIn()
        }
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
        if (postsViewModel.validateFields(user)) {
            auth.signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener(requireActivity())
            { task ->
                if (task.isSuccessful) {
                    auth.currentUser
                    successAuth()
                }
            }
        }
        else{
            showSnackBar("fail","cancel")
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).setAction(cancel) {}.show()
    }

    companion object {
        const val cancel = "cancel"
    }
}