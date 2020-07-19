package com.codewithjoey.learningmvvm.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.codewithjoey.learningmvvm.data.models.PetAdoption

@Dao
interface PetAdoptionDao {
    @Query("SELECT * FROM pet_adoptions")
    fun all(): LiveData<List<PetAdoption?>>?

    @Insert
    fun insert(petAdoption: PetAdoption?)
}