package com.example.pocketchef.features.ingredients.presentation

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketchef.App
import com.example.pocketchef.R
import com.example.pocketchef.core.di.DaggerPresentationComponent
import com.example.pocketchef.databinding.FragmentIngredientsBinding
import javax.inject.Inject


class IngredientsFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val ingViewModel: IngredientsViewModel by navGraphViewModels(R.id.mobile_navigation) { factory }
    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: IngredientsAdapter
    private lateinit var ingredientsViewModel: IngredientsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerPresentationComponent.builder()
            .coreComponent(App.coreComponent(requireContext()))
            .build()
            .injectIngredientsFragment(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        ingredientsViewModel = ViewModelProvider(this, factory).get(IngredientsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDecorator()
        setAdapters()
        setObservers()
    }

    private fun setAdapters() {
        adapter = IngredientsAdapter(mutableListOf()) {
            ingredientId -> onIngredientClick(ingredientId)
        }
        binding.recyclerviewIngredients.adapter = adapter
    }

    private fun setObservers() {

    }

    private fun onIngredientClick(ingredientId: String) {

    }

    private fun setDecorator() {
        binding.recyclerviewIngredients.addItemDecoration(
            object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    if (parent.getChildLayoutPosition(view) == 0) {
                        outRect.top = resources.getDimension(R.dimen.list_item_spacing).toInt()
                    }
                    outRect.bottom = resources.getDimension(R.dimen.list_item_spacing).toInt()
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}