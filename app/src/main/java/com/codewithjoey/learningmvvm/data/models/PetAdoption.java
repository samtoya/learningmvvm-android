package com.codewithjoey.learningmvvm.data.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "pet_adoptions")
public final class PetAdoption {
    @Ignore
    public static final String MALE = "Male";
    @Ignore
    public static final String FEMALE = "Female";
    @Ignore
    public static final String DOG = "Dog";
    @Ignore
    public static final String CAT = "Cat";

    @PrimaryKey(autoGenerate = true)
    public long petAdoptionId;
    public String mGender, mLocation;
    public String mPetType;
    public int mPetSize;

    @Ignore
    public PetAdoption(String gender, String location, String petType, int petSize) {
        mGender = gender;
        mLocation = location;
        mPetType = petType;
        mPetSize = petSize;
    }

    public PetAdoption(long petAdoptionId, String gender, String location, String petType, int petSize) {
        this.petAdoptionId = petAdoptionId;
        mGender = gender;
        mLocation = location;
        mPetType = petType;
        mPetSize = petSize;
    }

    @Ignore
    public PetAdoption() {
        mPetType = "Cat";
        mPetSize = 100;
        mGender = "Male";
        mLocation = "18 McCarthy Lane, McCarthy Hills, Ghana";
    }

    public long getPetAdoptionId() {
        return petAdoptionId;
    }

    public void setPetAdoptionId(long petAdoptionId) {
        this.petAdoptionId = petAdoptionId;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getPetType() {
        return mPetType;
    }

    public void setPetType(String petType) {
        mPetType = petType;
    }

    public int getPetSize() {
        return mPetSize;
    }

    public void setPetSize(int petSize) {
        mPetSize = petSize;
    }

    @Ignore
    @Override
    public String toString() {
        return "PetAdoption{" +
                "mGender='" + mGender + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mPetType=" + mPetType +
                ", mPetSize=" + mPetSize +
                '}';
    }
}
