package com.example.barangfirebase.Barang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barangfirebase.Child.data_barang;
import com.example.barangfirebase.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText Kode, Nama, Jumlah, Satuan, Harga, Tanggal;
    private Button Simpan;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Kode=findViewById(R.id.kode);
        Nama=findViewById(R.id.nama);
        Jumlah=findViewById(R.id.jumlah);
        Satuan=findViewById(R.id.satuan);
        Harga=findViewById(R.id.harga);
        Tanggal=findViewById(R.id.expDate);

        Simpan=findViewById(R.id.save);
        Simpan.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:

                //Mendapatkan Instance dari Database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference getReference;

                //Menyimpan Data yang diinputkan User kedalam Variable
                String getkode = Kode.getText().toString();
                String getNama = Nama.getText().toString();
                String getJumlah = Jumlah.getText().toString();
                String getSatuan = Satuan.getText().toString();
                String getHarga = Harga.getText().toString();
                String getTanggal = Tanggal.getText().toString();

                getReference = database.getReference(); // Mendapatkan Referensi dari Database

                // Mengecek apakah ada data yang kosong
                if(isEmpty(getkode) || isEmpty(getNama) || isEmpty(getJumlah)){
                    //Jika Ada, maka akan menampilkan pesan singkan seperti berikut ini.
                    Toast.makeText(MainActivity.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
                    String getUserID = mAuth.getCurrentUser().getUid();
                    /*
                    Jika Tidak, maka data dapat diproses dan meyimpannya pada Database
                    Menyimpan data referensi pada Database berdasarkan User ID dari masing-masing Akun
                    */
                    getReference.child("Admin").child(getUserID).child("Barang").push()
                            .setValue(new data_barang(getkode, getNama, getSatuan, getTanggal, getHarga, getJumlah))
                            .addOnSuccessListener(this, new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    //Peristiwa ini terjadi saat user berhasil menyimpan datanya kedalam Database
                                    Kode.setText("");
                                    Nama.setText("");
                                    Satuan.setText("");
                                    Tanggal.setText("");
                                    Harga.setText("");
                                    Jumlah.setText("");
                                    Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                break;
        }

    }
}
