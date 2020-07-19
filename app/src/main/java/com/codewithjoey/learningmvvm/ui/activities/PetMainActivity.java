package com.codewithjoey.learningmvvm.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.codewithjoey.learningmvvm.R;
import com.codewithjoey.learningmvvm.databinding.PetMainActivityBinding;

public class PetMainActivity extends AppCompatActivity {
    PetMainActivityBinding mPetMainActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mPetMainActivityBinding = DataBindingUtil.setContentView( this, R.layout.pet_main_activity );
        mPetMainActivityBinding.setLifecycleOwner( this );
    }
}