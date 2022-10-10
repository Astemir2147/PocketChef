package com.example.pocketchef.features.ingredients.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketchef.R
import com.example.pocketchef.databinding.ItemIngredientsBinding
import com.example.pocketchef.features.ingredients.presentation.models.IngredientsListItem

class IngredientsAdapter(
    private val ingredients: MutableList<IngredientsListItem>,
    private val onItemClicked: (ingredientId: String) -> Unit = {}
) : RecyclerView.Adapter<IngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder = IngredientsViewHolder(
        ItemIngredientsBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ingredients, parent,false)
        )
    )

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        with(holder.itemBinding) {
            ingredientName.text = ingredients[position].name
            ingredientCount.text = ingredients[position].count.toString()
        }
    }

    fun addIngredient(newIngredient: IngredientsListItem) {
        ingredients.add(newIngredient)
        notifyItemChanged(ingredients.size-1)
    }

    fun refreshData(newIngredients: List<IngredientsListItem>) {
        ingredients.clear()
        ingredients.addAll(newIngredients)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = ingredients.size

}

class IngredientsViewHolder(val itemBinding: ItemIngredientsBinding) : RecyclerView.ViewHolder(itemBinding.root) {

}