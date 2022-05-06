package com.example.pocketchef.data.db.dao

import androidx.room.*
import com.example.pocketchef.data.db.entities.Measure

@Dao
interface MeasureDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(measure: Measure)

    @Delete
    suspend fun delete(measure: Measure)

    @Query("SELECT * FROM measures WHERE id = :id")
    fun getById(id: Long): Measure
}