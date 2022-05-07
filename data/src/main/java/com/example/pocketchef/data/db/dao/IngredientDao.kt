package com.example.pocketchef.data.db.dao

import androidx.room.*
import com.example.pocketchef.data.db.entities.Ingredient

@Dao
interface IngredientDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ingredient: Ingredient)

    @Delete
    suspend fun delete(ingredient: Ingredient)

    @Query("SELECT * FROM ingredients WHERE id = :id")
    fun getById(id: Long): Ingredient

    @Query("SELECT * FROM ingredients LIMIT :numberIngedients OFFSET :offset")
    fun getIngredients(numberIngedients: Long, offset: Long): List<Ingredient>
}