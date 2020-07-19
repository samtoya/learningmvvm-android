package com.codewithjoey.learningmvvm.data.daos

import androidx.room.*
import com.codewithjoey.learningmvvm.data.models.Shelter

@Dao
interface ShelterDao {
    @Insert
    fun insert(shelter: Shelter?)

    @Update
    fun update(shelter: Shelter?)

    @Delete
    fun delete(shelter: Shelter?)

    @Query("SELECT * FROM shelters WHERE shelterId = :id LIMIT 1")
    fun findById(id: Int): Shelter?

    @Query("DELETE FROM shelters WHERE 1")
    fun deleteAll()

    @Query("SELECT * FROM shelters")
    fun all(): List<Shelter?>?
}