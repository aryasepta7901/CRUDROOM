package com.example.a11roomuas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a11roomuas.database.entitas.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaRVAdapter extends RecyclerView.Adapter<MahasiswaRVAdapter.ViewHolder> {

    private ArrayList<Mahasiswa> mahasiswaList;
    private Context context;

    public MahasiswaRVAdapter(ArrayList<Mahasiswa> mahasiswaList, Context context) {
        this.mahasiswaList = mahasiswaList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .mahasiswa_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa modal = mahasiswaList.get(position);
        holder.nimTV.setText(modal.nama);
        holder.namaTV.setText(modal.nim);
        holder.kelasTV.setText(modal.kelas);
        holder.nohpTV.setText(modal.nohp);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UpdateMahasiswaActivity.class);
                    i.putExtra("id", modal.id);


                    context.startActivity(i);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nimTV, namaTV, kelasTV, nohpTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nimTV = itemView.findViewById(R.id.nimTextView);
            namaTV = itemView.findViewById(R.id.namaTextView);
            kelasTV = itemView.findViewById(R.id.kelasTextView);
            nohpTV = itemView.findViewById(R.id.nohpTextView);
        }
    }
}
