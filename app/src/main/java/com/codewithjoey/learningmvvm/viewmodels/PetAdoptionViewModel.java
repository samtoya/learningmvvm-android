package com.codewithjoey.learningmvvm.viewmodels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.codewithjoey.learningmvvm.data.models.PetAdoption;
import com.codewithjoey.learningmvvm.data.repositories.PetAdoptionRepository;
import com.codewithjoey.learningmvvm.ui.activities.PetMainActivity;

import java.util.List;

public class PetAdoptionViewModel extends ViewModel {
    @SuppressLint("StaticFieldLeak")
    private static Context mApplication;
    public PetAdoption mPetAdoption;
    public LiveData<List<PetAdoption>> mPetAdoptionLiveData;
    private PetAdoptionRepository mPetAdoptionRepository;

    public PetAdoptionViewModel(Context application) {
        mApplication = application;
        mPetAdoptionRepository = PetAdoptionRepository.getInstance( application );
        mPetAdoption = new PetAdoption();
        mPetAdoptionLiveData = mPetAdoptionRepository.mPetAdoptions;
    }


    public void onPetTypeSelected(String type) {
        mPetAdoption.setPetType( type );
    }

    public void onGenderSelected(String gender) {
        mPetAdoption.setGender( gender );
    }

    public void onSizeSelected(String size) {
        mPetAdoption.setPetSize( Integer.parseInt( size ) );
    }

    public void findMyPetButtonClickListener() {
        mPetAdoptionRepository.create( mPetAdoption );
        Intent i = new Intent( mApplication, PetMainActivity.class );
        mApplication.startActivity( i );
    }
}
