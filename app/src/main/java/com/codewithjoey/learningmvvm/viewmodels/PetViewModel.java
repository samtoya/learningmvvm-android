package com.codewithjoey.learningmvvm.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.codewithjoey.learningmvvm.data.models.Pet;
import com.codewithjoey.learningmvvm.data.repositories.PetRepository;

import java.util.List;

public class PetViewModel extends AndroidViewModel {
    PetRepository mPetRepository;
    LiveData<List<Pet>> mPets;

    public PetViewModel(@NonNull Application application) {
        super( application );
        mPetRepository = new PetRepository( application );
        mPets = mPetRepository.getPets();
    }

    void insert(Pet pet) {
        mPetRepository.addPet( pet );
    }

    void update(Pet pet) {
        mPetRepository.updatePet( pet );
    }

    void deletePet(Pet pet) {
        mPetRepository.deletePet( pet );
    }

    void deleteAllPets() {
        mPetRepository.deleteAllPets();
    }

    LiveData<Pet> find(int id) {
        return mPetRepository.findById( id );
    }
}
