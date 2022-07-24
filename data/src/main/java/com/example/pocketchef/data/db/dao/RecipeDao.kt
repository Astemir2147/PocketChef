package com.example.pocketchef.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pocketchef.data.db.entities.Recipe

@Dao
interface RecipeDao {

    @Insert
    suspend fun insert(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM recipes WHERE id = :id")
    fun getById(id: Long): Recipe

    @Query("SELECT * FROM recipes LIMIT :numberRecipes OFFSET :offset")
    fun getRecipes(numberRecipes: Long, offset: Long): List<Recipe>
}