package com.example.barangfirebase.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barangfirebase.Barang.MyListData;
import com.example.barangfirebase.Child.data_barang;
import com.example.barangfirebase.Barang.updateData;
import com.example.barangfirebase.R;
import com.example.barangfirebase.Terjual.barangTerjual;

import java.util.ArrayList;

//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    //Deklarasi Variable
    private ArrayList<data_barang> listBarang;
    private Context context;

    //Membuat Interfece
    public interface dataListener{
        void onDeleteData(data_barang data, int position);
    }

    //Deklarasi objek dari Interfece
    dataListener listener;

    //Membuat Konstruktor, untuk menerima input dari Database
    public RecyclerViewAdapter(ArrayList<data_barang> listBarang, Context context) {
        this.listBarang = listBarang;
        this.context = context;
        listener = (MyListData)context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Kode, Nama, Jumlah, Satuan, Tanggal, Harga;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Kode = itemView.findViewById(R.id.kode);
            Nama = itemView.findViewById(R.id.nama);
            Jumlah = itemView.findViewById(R.id.jumlah);
            Satuan = itemView.findViewById(R.id.satuan);
            Tanggal = itemView.findViewById(R.id.tanggal);
            Harga = itemView.findViewById(R.id.harga);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Kode = listBarang.get(position).getKode();
        final String Nama = listBarang.get(position).getNama();
        final String Jumlah = listBarang.get(position).getJumlah();
        final String Satuan = listBarang.get(position).getSatuan();
        final String Tanggal = listBarang.get(position).getExpDate();
        final String Harga = listBarang.get(position).getHarga();

        holder.Kode.setText("Kode           \t: "+Kode);
        holder.Nama.setText("Nama           \t: "+Nama);
        holder.Satuan.setText("Satuan       \t: "+Satuan);
        holder.Tanggal.setText("Kadaluwarsa \t: "+Tanggal);
        holder.Harga.setText("Harga         \t: "+Harga);
        holder.Jumlah.setText("Jumlah       \t: "+Jumlah);

        //Menampilkan Menu Update dan Delete saat user melakukan long klik pada salah satu item
        holder.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                final String[] action = {"Update", "Beli","Delete"};
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setItems(action,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
                                /*
                                  Berpindah Activity pada halaman layout updateData
                                  dan mengambil data pada listMahasiswa, berdasarkan posisinya
                                  untuk dikirim pada activity updateData
                                 */
                                Bundle bundle = new Bundle();
                                bundle.putString("dataKode", listBarang.get(position).getKode());
                                bundle.putString("dataNama", listBarang.get(position).getNama());
                                bundle.putString("dataSatuan", listBarang.get(position).getSatuan());
                                bundle.putString("dataTanggal", listBarang.get(position).getExpDate());
                                bundle.putString("dataharga", listBarang.get(position).getHarga());
                                bundle.putString("dataJumlah", listBarang.get(position).getJumlah());
                                bundle.putString("getPrimaryKey", listBarang.get(position).getKey());
                                Intent intent = new Intent(view.getContext(), updateData.class);
                                intent.putExtras(bundle);
                                context.startActivity(intent);
                                break;
                            case 1:
                                Bundle bundle1 = new Bundle();
                                bundle1.putString("dataKode1", listBarang.get(position).getKode());
                                bundle1.putString("dataNama1", listBarang.get(position).getNama());
                                bundle1.putString("dataSatuan1", listBarang.get(position).getSatuan());
                                bundle1.putString("dataTanggal1", listBarang.get(position).getExpDate());
                                bundle1.putString("dataHarga1", listBarang.get(position).getHarga());
                                bundle1.putString("getPrimaryKey", listBarang.get(position).getKey());
                                Intent intent1 = new Intent(view.getContext(), barangTerjual.class);
                                intent1.putExtras(bundle1);
                                context.startActivity(intent1);
                                break;
                            case 2:
                                //Menggunakan interface untuk mengirim data mahasiswa, yang akan dihapus
                                listener.onDeleteData(listBarang.get(position), position);
                                break;
                        }
                    }
                });
                alert.create();
                alert.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listBarang.size();
    }

}