package com.example.a11roomuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a11roomuas.database.AppDatabase;
import com.example.a11roomuas.database.entitas.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class UpdateMahasiswaActivity extends AppCompatActivity {

    private EditText nimEdt, namaEdt, kelasEdt, nohpEdt;
    private Button updateMahasiswaBtn ,deleteMahasiswBtn;
    private AppDatabase database;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mahasiswa);
        //Inisialisasi
        nimEdt = findViewById(R.id.nimEdtEditText);
        namaEdt = findViewById(R.id.namaEdtEditText);
        kelasEdt = findViewById(R.id.kelasEdtEditText);
        nohpEdt = findViewById(R.id.nohpEdtEditText);
        updateMahasiswaBtn = findViewById(R.id.updateButton);
        deleteMahasiswBtn =findViewById(R.id.deleteButton);

        //create a new Appdatabase
        database = AppDatabase.getInstance(getApplicationContext());
        //Ambil Data Detail By Id
        id =getIntent().getIntExtra("id",0);
        Mahasiswa mahasiswa =database.mahasiswaDao().get(id);

        nimEdt.setText(mahasiswa.nim);
        namaEdt.setText(mahasiswa.nama);
        kelasEdt.setText(mahasiswa.kelas);
        nohpEdt.setText(mahasiswa.nohp);


        updateMahasiswaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Update Data
                database.mahasiswaDao().update(id,nimEdt.getText().toString(),namaEdt.getText().toString(),
                        kelasEdt.getText().toString(),nohpEdt.getText().toString());
                //ALert Pesan
                Toast.makeText(UpdateMahasiswaActivity.this, "Mahasiswa telah di-Update.."
                        , Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateMahasiswaActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        //Delete Data
        deleteMahasiswBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mahasiswaDao().delete(mahasiswa);
                //Alert Pesan
                Toast.makeText(UpdateMahasiswaActivity.this, "Mahasiswa telah di-Delete.."
                        , Toast.LENGTH_SHORT).show();
                // Pindah Ke activity Main
                Intent i = new Intent(UpdateMahasiswaActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}