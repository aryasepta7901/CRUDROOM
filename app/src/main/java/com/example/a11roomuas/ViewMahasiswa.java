package com.example.a11roomuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a11roomuas.database.AppDatabase;
import com.example.a11roomuas.database.entitas.Mahasiswa;

import java.util.ArrayList;

public class ViewMahasiswa extends AppCompatActivity {

    private ArrayList<Mahasiswa> mahasiswaList;
    private AppDatabase database;
    private MahasiswaRVAdapter mahasiswaRVAdapter;
    private RecyclerView mahasiswaRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mahasiswa);


        database = AppDatabase.getInstance(getApplicationContext());

        mahasiswaList = (ArrayList<Mahasiswa>) database.mahasiswaDao().getAll();

        mahasiswaRVAdapter = new MahasiswaRVAdapter(mahasiswaList, ViewMahasiswa.this);
        mahasiswaRV = findViewById(R.id.idRVMahasiswa);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMahasiswa.this,
                RecyclerView.VERTICAL, false);

        mahasiswaRV.setLayoutManager(linearLayoutManager);

        mahasiswaRV.setAdapter(mahasiswaRVAdapter);


    }
}