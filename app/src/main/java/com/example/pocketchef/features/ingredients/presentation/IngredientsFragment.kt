package com.example.pocketchef.features.ingredients.presentation

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketchef.R
import com.example.pocketchef.databinding.FragmentIngredientsBinding


class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: IngredientsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ingredientsViewModel =
            ViewModelProvider(this)[IngredientsViewModel::class.java]

        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setDecorator()
        setAdapter()
        return root
    }

    private fun setAdapter() {
        adapter = IngredientsAdapter(mutableListOf()) {
            ingredientId -> onIngredientClick(ingredientId)
        }
        binding.recyclerviewIngredients.adapter = adapter
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