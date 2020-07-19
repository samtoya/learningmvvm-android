package com.codewithjoey.learningmvvm.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codewithjoey.learningmvvm.data.models.Pet

@Dao
interface PetDao {
    @Query("SELECT * FROM pets")
    fun all(): LiveData<List<Pet?>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pet: Pet?)

    @Update
    fun update(pet: Pet?)

    @Delete
    fun delete(pet: Pet?)

    @Query("SELECT * FROM pets WHERE petId = :id LIMIT 1")
    fun find(id: Int): LiveData<Pet?>?

    @Query("SELECT * FROM pets WHERE mType = :type ORDER BY CASE WHEN :latest = 1 THEN petId END DESC, CASE WHEN :latest = 0 THEN petId END ASC")
    fun findWhereType(type: String?, latest: Boolean): LiveData<List<Pet?>>?

    @Query("DELETE FROM pets")
    fun deleteAll()

//    @Transaction
//    @Query( "SELECT * FROM pets" )
//    List<PetWithNeeds> getAllPetsWithNeeds();
}