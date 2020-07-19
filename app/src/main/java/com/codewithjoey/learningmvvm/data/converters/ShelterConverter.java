package com.codewithjoey.learningmvvm.data.converters;

import androidx.room.TypeConverter;

import com.codewithjoey.learningmvvm.data.models.Shelter;

public class ShelterConverter {
    @TypeConverter
    public static String fromShelter(Shelter shelter) {
        return shelter.getShelterName();
    }
}
