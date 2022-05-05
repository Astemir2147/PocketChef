package com.example.pocketchef.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pocketchef.data.db.dao.IngredientDao
import com.example.pocketchef.data.db.dao.MeasureDao
import com.example.pocketchef.data.db.dao.RecipeDao
import com.example.pocketchef.data.db.entities.Ingredient
import com.example.pocketchef.data.db.entities.Measure
import com.example.pocketchef.data.db.entities.Recipe

@Database(entities = [Ingredient::class, Measure::class, Recipe::class], version = 1)
public abstract class RecipesSQLiteDatabase : RoomDatabase() {
    abstract fun measureDao(): MeasureDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun recipeDao(): RecipeDao
}