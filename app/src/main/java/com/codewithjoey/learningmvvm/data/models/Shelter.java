package com.codewithjoey.learningmvvm.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shelters")
public class Shelter {
    @PrimaryKey(autoGenerate = true)
    private long shelterId;

    private String mShelterName;

    private int mShelterImageUrl;

    private Double mDistance;

    public String getShelterName() {
        return mShelterName;
    }

    public void setShelterName(String shelterName) {
        mShelterName = shelterName;
    }

    public int getShelterImageUrl() {
        return mShelterImageUrl;
    }

    public void setShelterImageUrl(int shelterImageUrl) {
        mShelterImageUrl = shelterImageUrl;
    }

    public Double getDistance() {
        return mDistance;
    }

    public void setDistance(Double distance) {
        mDistance = distance;
    }

    public long getShelterId() {
        return shelterId;
    }

    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }
}
