package com.example.pocketchef.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pocketchef.presentation.R
import com.example.pocketchef.presentation.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    // val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialogAuth()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun showDialogAuth(){

        MaterialAlertDialogBuilder(requireContext(), com.google.android.material.R.style.MaterialAlertDialog_Material3)
            .setTitle(resources.getString(R.string.title))
            .setMessage(resources.getString(R.string.supporting_text))
            .setNegativeButton(resources.getString(R.string.signIn)) { dialog, which ->
                findNavController().navigate(R.id.action_navigation_home_to_loginFragment)
            }
            .setPositiveButton(resources.getString(R.string.registration)) { dialog, which ->
            }
            .show()
    }
}