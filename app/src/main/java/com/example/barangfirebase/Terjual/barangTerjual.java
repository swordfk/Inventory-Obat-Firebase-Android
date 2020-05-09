package com.example.barangfirebase.Terjual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barangfirebase.Child.data_terjual;
import com.example.barangfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class barangTerjual extends AppCompatActivity {
    //Deklarasi Variable
    private EditText kodeBeli, namaBeli, jumlahBeli, satuanBeli, tanggalBeli, hargaBeli;
    private Button Beli;
    private DatabaseReference database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_terjual);

        kodeBeli = findViewById(R.id.beli_kode);
        namaBeli = findViewById(R.id.beli_nama);
        jumlahBeli = findViewById(R.id.beli_jumlah);
        satuanBeli = findViewById(R.id.beli_satuan);
        tanggalBeli = findViewById(R.id.beli_tanggal);
        hargaBeli = findViewById(R.id.beli_harga);
        Beli = findViewById(R.id.beli);
        mAuth=FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance().getReference();
        getData();
        Beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mendapatkan Instance dari Database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference getReference;

                //Menyimpan Data yang diinputkan User kedalam Variable
                String getkode = kodeBeli.getText().toString();
                String getNama = namaBeli.getText().toString();
                String getJumlah = jumlahBeli.getText().toString();
                String getSatuan = satuanBeli.getText().toString();
                String getTanggal = tanggalBeli.getText().toString();
                String getHarga = hargaBeli.getText().toString();

                getReference = database.getReference(); // Mendapatkan Referensi dari Database

                // Mengecek apakah ada data yang kosong
                if(isEmpty(getJumlah)){
                    //Jika Ada, maka akan menampilkan pesan singkan seperti berikut ini.
                    Toast.makeText(barangTerjual.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
                    /*
                    Jika Tidak, maka data dapat diproses dan meyimpannya pada Database
                    Menyimpan data referensi pada Database berdasarkan User ID dari masing-masing Akun
                    */
                    getReference.child("Admin").child(mAuth.getUid()).child("Terjual").push().setValue(new data_terjual(getkode, getNama, getSatuan, getTanggal, getHarga,getJumlah));
                    Intent i = new Intent(getApplicationContext(),animasiPembelian.class);
                    startActivity(i);
                }
            }
        });
    }
    // Mengecek apakah ada data yang kosong, sebelum diupdate
    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void getData() {
        final String getKode = getIntent().getExtras().getString("dataKode1");
        final String getNama = getIntent().getExtras().getString("dataNama1");
        final String getSatuan = getIntent().getExtras().getString("dataSatuan1");
        final String getTanggal = getIntent().getStringExtra("dataTanggal1");
        final String getHarga = getIntent().getStringExtra("dataHarga1");
        kodeBeli.setText(getKode);
        namaBeli.setText(getNama);
        satuanBeli.setText(getSatuan);
        tanggalBeli.setText(getTanggal);
        hargaBeli.setText(getHarga);
        jumlahBeli.setText(jumlahBeli.getText().toString());
    }
}
