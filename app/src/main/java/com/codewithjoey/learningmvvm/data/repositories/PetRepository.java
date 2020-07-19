package com.codewithjoey.learningmvvm.data.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.codewithjoey.learningmvvm.data.daos.PetDao;
import com.codewithjoey.learningmvvm.data.database.AppDatabase;
import com.codewithjoey.learningmvvm.data.models.Pet;

import java.util.List;

public class PetRepository {
    PetDao mPetDao;
    LiveData<List<Pet>> mPets;
    private Application mApplication;

    public PetRepository(Application application) {
        mApplication = application;
        AppDatabase appDatabase = AppDatabase.getInstance( application );
        mPetDao = appDatabase.mPetDao();
        mPets = mPetDao.all();
    }

    public LiveData<List<Pet>> getPets() {
        return mPetDao.all();
    }

    public LiveData<Pet> findById(int id) {
        return mPetDao.find( id );
    }

    public void updatePet(Pet pet) {
        new UpdatePetAsyncTask( mPetDao ).execute( pet );
    }

    public void deletePet(Pet pet) {
        new DeletePetAsyncTask( mPetDao ).execute( pet );
    }

    public void deleteAllPets() {
        new DeleteAllPetsAsyncTask( mPetDao );
    }

    public void addPet(Pet pet) {
        new InsertPetAsyncTask( mPetDao ).execute( pet );
    }

    private static class InsertPetAsyncTask extends AsyncTask<Pet, Void, Void> {
        final private PetDao mPetDao;

        public InsertPetAsyncTask(PetDao petDao) {
            mPetDao = petDao;
        }

        @Override
        protected Void doInBackground(Pet... pets) {
            mPetDao.insert( pets[0] );
            return null;
        }
    }

    private static class UpdatePetAsyncTask extends AsyncTask<Pet, Void, Void> {
        final private PetDao mPetDao;

        public UpdatePetAsyncTask(PetDao petDao) {
            mPetDao = petDao;
        }

        @Override
        protected Void doInBackground(Pet... pets) {
            mPetDao.update( pets[0] );
            return null;
        }
    }

    private static class DeletePetAsyncTask extends AsyncTask<Pet, Void, Void> {
        final private PetDao mPetDao;

        public DeletePetAsyncTask(PetDao petDao) {
            mPetDao = petDao;
        }

        @Override
        protected Void doInBackground(Pet... pets) {
            mPetDao.delete( pets[0] );
            return null;
        }
    }

    private static class DeleteAllPetsAsyncTask extends AsyncTask<Void, Void, Void> {
        final private PetDao mPetDao;

        public DeleteAllPetsAsyncTask(PetDao petDao) {
            mPetDao = petDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mPetDao.deleteAll();
            return null;
        }
    }
}
