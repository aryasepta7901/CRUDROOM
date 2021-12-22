package com.example.a11roomuas.database.dao;
//metode yang digunakan untuk mengakses database.
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.a11roomuas.database.entitas.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {
    //View All Data
    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    //Add Data Mahasiswa
    @Query("INSERT INTO mahasiswa (nim,nama,kelas,nohp) VALUES(:nim, :nama,:kelas,:nohp)")
    void insertAll(String nim, String nama,String kelas,String nohp);

    //Delete Data Mahasiswa
    @Delete
    void delete(Mahasiswa mahasiswa);

    //Update Data Mahasiswa
    @Query("UPDATE mahasiswa SET nim=:nim, nama=:nama,kelas=:kelas,nohp=:nohp WHERE id=:id")
    void update(int id, String nim, String nama,String kelas,String nohp);

    //Detail Mahasiswa
    @Query("SELECT * FROM mahasiswa WHERE id=:id")
    Mahasiswa get(int id);
}