package com.codewithjoey.learningmvvm.data.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "pet_needs")
public class PetNeed implements Serializable {
    @PrimaryKey(autoGenerate = true)
    long petNeedId;

    @ForeignKey(entity = Pet.class, parentColumns = "petId", childColumns = "petId", onDelete = CASCADE)
    long petId;

    String mName;

    int mIconUrl;

    public long getPetNeedId() {
        return petNeedId;
    }

    public void setPetNeedId(long petNeedId) {
        this.petNeedId = petNeedId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(int iconUrl) {
        mIconUrl = iconUrl;
    }
}
