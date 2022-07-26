package com.example.pocketchef.presentation.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.core.App
import com.example.pocketchef.presentation.R
import com.example.pocketchef.presentation.databinding.FragmentHomeBinding
import com.example.pocketchef.presentation.ui.di.DaggerPresentationComponent
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val homeViewModel: HomeViewModel by navGraphViewModels(R.id.mobile_navigation) { factory }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerPresentationComponent.builder()
            .coreComponent(App.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.checkLogined()
        homeViewModel.homeLoginedResultLiveData.observe(viewLifecycleOwner, ::showDialogAuth)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
     private fun showDialogAuth(success: Boolean){
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