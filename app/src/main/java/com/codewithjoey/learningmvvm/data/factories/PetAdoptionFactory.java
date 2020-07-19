package com.codewithjoey.learningmvvm.data.factories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codewithjoey.learningmvvm.viewmodels.PetAdoptionViewModel;

public class PetAdoptionFactory implements ViewModelProvider.Factory {
    private final Context mContext;

    public PetAdoptionFactory(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        PetAdoptionViewModel model = new PetAdoptionViewModel( mContext );
        return ( T ) model;
    }
}
