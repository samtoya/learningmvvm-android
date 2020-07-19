package com.codewithjoey.learningmvvm.data.models.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.codewithjoey.learningmvvm.data.models.Pet;
import com.codewithjoey.learningmvvm.data.models.Shelter;

import java.util.List;

public class ShelterWithPets {
    @Embedded
    private Shelter mShelter;
    @Relation(parentColumn = "shelterId",
            entityColumn = "shelterId")
    private List<Pet> mPets;

    public Shelter getShelter() {
        return mShelter;
    }

    public void setShelter(Shelter shelter) {
        mShelter = shelter;
    }

    public List<Pet> getPets() {
        return mPets;
    }

    public void setPets(List<Pet> pets) {
        mPets = pets;
    }
}
