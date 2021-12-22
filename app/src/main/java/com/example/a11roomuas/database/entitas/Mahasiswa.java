package com.example.a11roomuas.database.entitas;




import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey
    public  int id;

    @ColumnInfo(name ="nim") //ini adalah nama table
    public  String nim;

    @ColumnInfo(name="nama")
    public String nama;

    @ColumnInfo(name="kelas")
    public String kelas;

    @ColumnInfo(name="nohp")
    public String nohp;
}