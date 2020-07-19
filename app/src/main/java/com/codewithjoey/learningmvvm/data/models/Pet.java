package com.codewithjoey.learningmvvm.data.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "pets")
public class Pet {
    @PrimaryKey(autoGenerate = true)
    long petId;

    @ForeignKey
            (entity = Shelter.class,
                    parentColumns = "shelterId",
                    childColumns = "shelterId",
                    onDelete = CASCADE)
    long shelterId;

    String mPetName;

    String mType;

    int mPetImageUrl;

    String mBreed;

    int mAge;

    String mDescription;

    public long getShelterId() {
        return shelterId;
    }

    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return mPetName;
    }

    public void setPetName(String petName) {
        mPetName = petName;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public int getPetImageUrl() {
        return mPetImageUrl;
    }

    public void setPetImageUrl(int petImageUrl) {
        mPetImageUrl = petImageUrl;
    }

    public String getBreed() {
        return mBreed;
    }

    public void setBreed(String breed) {
        mBreed = breed;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
