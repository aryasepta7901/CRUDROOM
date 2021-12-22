package com.example.a11roomuas.database;

//Berisi penampung database dan berfungsi sebagai titik akses utama bagi koneksi saat ini ke data
// relasional aplikasi yang persisten.



import android.content.Context;


import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.a11roomuas.database.dao.MahasiswaDao;
import com.example.a11roomuas.database.entitas.Mahasiswa;


@Database(entities = {Mahasiswa.class} , version = 1) //Version DB
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    @VisibleForTesting
    //Database Name
    public static final  String DATABASE_NAME ="mahasiswa";
    public abstract MahasiswaDao mahasiswaDao();

    private void setDatabaseCreated()
    {
        mIsDatabaseCreated.postValue(true);
    }
    private void  updateDatabaseCreated(final Context context)
    {
        if(context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    //Build Database
    public static AppDatabase buildDatabase(final Context context)
    {
        return Room.databaseBuilder(context, AppDatabase.class,DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        AppDatabase database = AppDatabase.getInstance(context);
                        database.setDatabaseCreated();
                    }
                }).allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
    public static AppDatabase getInstance(final Context context)
    {
        if (sInstance == null)
        {
            synchronized (AppDatabase.class)
            {
                if (sInstance == null)
                {
                    sInstance = buildDatabase(context);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }
}
