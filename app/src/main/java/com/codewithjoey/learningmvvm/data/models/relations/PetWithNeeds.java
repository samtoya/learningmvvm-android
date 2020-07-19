package com.codewithjoey.learningmvvm.data.models.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.codewithjoey.learningmvvm.data.models.Pet;
import com.codewithjoey.learningmvvm.data.models.PetNeed;

import java.util.List;

public class PetWithNeeds {
    @Embedded
    public Pet mPet;

    @Relation(parentColumn = "petId",
            entityColumn = "petId")
    public List<PetNeed> mPetNeeds;

    public Pet getPet() {
        return mPet;
    }

    public void setPet(Pet pet) {
        mPet = pet;
    }

    public List<PetNeed> getPetNeeds() {
        return mPetNeeds;
    }

    public void setPetNeeds(List<PetNeed> petNeeds) {
        mPetNeeds = petNeeds;
    }
}
