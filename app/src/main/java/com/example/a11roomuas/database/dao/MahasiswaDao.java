package com.example.a11roomuas.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.a11roomuas.database.entitas.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {
    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("INSERT INTO mahasiswa (nim,nama,kelas,nohp) VALUES(:nim, :nama,:kelas,:nohp)")
    void insertAll(String nim, String nama,String kelas,String nohp);

    @Delete
    void delete(Mahasiswa mahasiswa);


    @Query("UPDATE mahasiswa SET nim=:nim, nama=:nama,kelas=:kelas,nohp=:nohp WHERE id=:id")
    void update(int id, String nim, String nama,String kelas,String nohp);

    @Query("SELECT * FROM mahasiswa WHERE id=:id")
    Mahasiswa get(int id);
}