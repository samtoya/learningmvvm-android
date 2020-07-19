package com.codewithjoey.learningmvvm.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.codewithjoey.learningmvvm.R;
import com.codewithjoey.learningmvvm.databinding.PetDetailActivityBinding;

public class PetDetailActivity extends AppCompatActivity {
    PetDetailActivityBinding mPetDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mPetDetailBinding = DataBindingUtil.setContentView( this, R.layout.pet_detail_activity );
        mPetDetailBinding.setLifecycleOwner( this );
    }
}