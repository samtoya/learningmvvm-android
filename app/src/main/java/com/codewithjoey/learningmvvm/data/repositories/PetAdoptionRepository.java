package com.codewithjoey.learningmvvm.data.repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.codewithjoey.learningmvvm.data.database.AppDatabase;
import com.codewithjoey.learningmvvm.data.models.PetAdoption;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PetAdoptionRepository {
    public static PetAdoptionRepository instance;
    public LiveData<List<PetAdoption>> mPetAdoptions;
    AppDatabase mAppDatabase;
    Executor mExecutor = Executors.newSingleThreadExecutor();

    private PetAdoptionRepository(Context context) {
        mAppDatabase = AppDatabase.getInstance( context );
        mPetAdoptions = getPetAdoptions();
    }

    public static PetAdoptionRepository getInstance(Context context) {
        if ( instance == null ) {
            instance = new PetAdoptionRepository( context );
        }
        return instance;
    }

    public void create(final PetAdoption petAdoption) {
        mExecutor.execute( new Runnable() {
            @Override
            public void run() {
                mAppDatabase.mPetAdoptionDao().insert( petAdoption );
            }
        } );
    }

    private LiveData<List<PetAdoption>> getPetAdoptions() {
        LiveData<List<PetAdoption>> liveData = mAppDatabase.mPetAdoptionDao().all();
        if ( liveData != null ) {
            Log.i( getClass().getSimpleName(), String.valueOf( liveData.getValue() ) );
        } else {
            Log.i( getClass().getSimpleName(), "Live data is null" );
        }
        return liveData;
    }
}
