package com.codewithjoey.learningmvvm.ui.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.codewithjoey.learningmvvm.R;
import com.codewithjoey.learningmvvm.data.factories.PetAdoptionFactory;
import com.codewithjoey.learningmvvm.data.models.PetAdoption;
import com.codewithjoey.learningmvvm.databinding.PetAdoptOptionsActivityBinding;
import com.codewithjoey.learningmvvm.viewmodels.PetAdoptionViewModel;

import java.util.ArrayList;
import java.util.List;

public class PetAdoptOptionsActivity extends AppCompatActivity {
    PetAdoptOptionsActivityBinding mPetAdoptOptionsBinding;
    PetAdoptionViewModel mPetAdoptionViewModel;
    List<PetAdoption> mPetAdoptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mPetAdoptOptionsBinding = DataBindingUtil.setContentView( this, R.layout.pet_adopt_options_activity );

        initViewModel();
        initDataBinding();
    }

    private void initDataBinding() {
        mPetAdoptOptionsBinding.setViewmodel( mPetAdoptionViewModel );
        mPetAdoptOptionsBinding.setPetAdoption( new PetAdoption() );
        mPetAdoptOptionsBinding.executePendingBindings();
        mPetAdoptOptionsBinding.setLifecycleOwner( this );
    }

    private void initViewModel() {
        final Observer<List<PetAdoption>> liveDataObserver = new Observer<List<PetAdoption>>() {
            @Override
            public void onChanged(List<PetAdoption> petAdoptions) {
                Log.i( getClass().getSimpleName(), petAdoptions.toString() );
                mPetAdoptions.clear();
                mPetAdoptions.addAll( petAdoptions );
            }
        };

        mPetAdoptionViewModel = new ViewModelProvider( this, new PetAdoptionFactory( this ) )
                .get( PetAdoptionViewModel.class );
        mPetAdoptionViewModel.mPetAdoptionLiveData.observe( this, liveDataObserver );
    }
}