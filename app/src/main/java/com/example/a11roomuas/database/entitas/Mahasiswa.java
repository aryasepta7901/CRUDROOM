package com.example.a11roomuas.database.entitas;

//Merepresentasikan tabel dalam database


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey //Primary Key
    public  int id;

    //Data Field Kolom
    @ColumnInfo(name ="nim")
    public  String nim;

    @ColumnInfo(name="nama")
    public String nama;

    @ColumnInfo(name="kelas")
    public String kelas;

    @ColumnInfo(name="nohp")
    public String nohp;
}