package com.example.barangfirebase.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.barangfirebase.R;
import com.example.barangfirebase.Child.data_terjual;

import java.util.ArrayList;

//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{


    //Deklarasi Variable
    private ArrayList<data_terjual> listTerjual;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public RecyclerViewAdapter2(ArrayList<data_terjual> listTerjual, Context context) {
        this.listTerjual = listTerjual;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Kode, Nama, Satuan, Tanggal, Harga, Jumlah;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Kode = itemView.findViewById(R.id.kode1);
            Nama = itemView.findViewById(R.id.nama1);
            Jumlah = itemView.findViewById(R.id.jumlah1);
            Satuan = itemView.findViewById(R.id.satuan1);
            Tanggal = itemView.findViewById(R.id.tanggal1);
            Harga = itemView.findViewById(R.id.harga1);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.jual_design, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Kode = listTerjual.get(position).getKodeTerjual();
        final String Nama = listTerjual.get(position).getNamaTerjual();
        final String Satuan = listTerjual.get(position).getSatuanTerjual();
        final String Tanggal = listTerjual.get(position).getTanggalTerjual();
        final String Harga = listTerjual.get(position).getHargaTerjual();
        final String Jumlah = listTerjual.get(position).getJumlahTerjual();

        //Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.Kode.setText("Kode           \t: "+Kode);
        holder.Nama.setText("Nama           \t: "+Nama);
        holder.Satuan.setText("Satuan       \t: "+Satuan);
        holder.Tanggal.setText("Kadaluwarsa \t: "+Tanggal);
        holder.Harga.setText("Harga         \t: "+Harga);
        holder.Jumlah.setText("Jumlah       \t: "+Jumlah);
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listTerjual.size();
    }

}