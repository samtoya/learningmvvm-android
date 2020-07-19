package com.codewithjoey.learningmvvm.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.codewithjoey.learningmvvm.data.converters.ShelterConverter;
import com.codewithjoey.learningmvvm.data.daos.PetAdoptionDao;
import com.codewithjoey.learningmvvm.data.daos.PetDao;
import com.codewithjoey.learningmvvm.data.daos.ShelterDao;
import com.codewithjoey.learningmvvm.data.models.Pet;
import com.codewithjoey.learningmvvm.data.models.PetAdoption;
import com.codewithjoey.learningmvvm.data.models.PetNeed;
import com.codewithjoey.learningmvvm.data.models.Shelter;

import java.util.Arrays;
import java.util.List;

@Database(entities = {Pet.class, Shelter.class, PetAdoption.class}, version = 1, exportSchema = false)
@TypeConverters({ShelterConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase instance;
    public static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate( db );
            new PopulateDatabaseAsyncTask( instance ).execute();
        }
    };

    public static synchronized AppDatabase getInstance(Context context) {
        if ( instance == null ) {
            instance = Room.databaseBuilder( context, AppDatabase.class, "pet_adoption.db" )
                    .fallbackToDestructiveMigration()
//                    .addCallback( roomCallback )
                    .build();
        }
        return instance;
    }

    public abstract PetDao mPetDao();

    public abstract ShelterDao mShelterDao();

    public abstract PetAdoptionDao mPetAdoptionDao();

    public static class PopulateDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {

        private final PetDao mPetDao;
        private final ShelterDao mShelterDao;


        public PopulateDatabaseAsyncTask(AppDatabase appDatabase) {
            mPetDao = appDatabase.mPetDao();
            mShelterDao = appDatabase.mShelterDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Create objects to prepopulate the DB here.
            Shelter saintLazarus = new Shelter();
            saintLazarus.setShelterName( "St. Lazarus Shelter" );
            saintLazarus.setDistance( 3.2 );
            saintLazarus.setShelterImageUrl( 1 );

            mShelterDao.insert( saintLazarus );

            // Ped Needs
            PetNeed petNeed1 = new PetNeed();
            petNeed1.setName( "Food" );
            petNeed1.setIconUrl( 1 );
            PetNeed petNeed2 = new PetNeed();
            petNeed2.setName( "Water" );
            petNeed2.setIconUrl( 1 );
            PetNeed petNeed3 = new PetNeed();
            petNeed3.setName( "Home" );
            petNeed3.setIconUrl( 1 );
            PetNeed petNeed4 = new PetNeed();
            petNeed4.setName( "Walk" );
            petNeed4.setIconUrl( 1 );
            PetNeed petNeed5 = new PetNeed();
            petNeed5.setName( "Love" );
            petNeed5.setIconUrl( 1 );

            List<PetNeed> laraNeeds = Arrays.asList( petNeed1, petNeed2, petNeed3, petNeed4 );
            List<PetNeed> sashaNeeds = Arrays.asList( petNeed1, petNeed2, petNeed3 );
            List<PetNeed> captainMinnieNeeds = Arrays.asList( petNeed5, petNeed4, petNeed3 );

            Pet lara = new Pet();
            lara.setPetName( "Lara" );
            lara.setType( "Dog" );
            lara.setAge( 1 );
            lara.setBreed( "Mutt" );

            Pet sasha = new Pet();
            sasha.setPetName( "Sasha" );
            sasha.setType( "Dog" );
            sasha.setAge( 1 );
            sasha.setBreed( "Maltese" );

            Pet captainMinie = new Pet();
            captainMinie.setPetName( "Captain Minnie" );
            captainMinie.setType( "Cat" );
            captainMinie.setAge( 1 );
            captainMinie.setBreed( "Fluffy" );

            mPetDao.insert( lara );
            mPetDao.insert( sasha );
            mPetDao.insert( captainMinie );
            return null;
        }
    }
}
