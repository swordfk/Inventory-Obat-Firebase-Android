package com.example.barangfirebase.Terjual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.barangfirebase.Adapter.RecyclerViewAdapter2;
import com.example.barangfirebase.Child.data_terjual;
import com.example.barangfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyListDataTerjual extends AppCompatActivity {

    //Deklarasi Variable untuk RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    //Deklarasi Variable Database Reference dan ArrayList dengan Parameter Class Model kita.
    private DatabaseReference reference;
    private ArrayList<data_terjual> dataTerjual;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_data_terjual);

        recyclerView = findViewById(R.id.datalist2);
        mAuth=FirebaseAuth.getInstance();
        MyRecyclerView();
        GetData();
    }

    private void GetData() {
        //Mendapatkan Referensi Database
        String getUserID = mAuth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Admin").child(getUserID).child("Terjual")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot2) {
                        //Inisialisasi ArrayList
                        dataTerjual = new ArrayList<>();

                        for (DataSnapshot snapshot2 : dataSnapshot2.getChildren()){
                            data_terjual barangTerjual = snapshot2.getValue(data_terjual.class);
                            dataTerjual.add(barangTerjual);
                        }
                        //Inisialisasi Adapter dan data Barang dalam bentuk Array
                        adapter = new RecyclerViewAdapter2(dataTerjual, MyListDataTerjual.this);

                        //Memasang Adapter pada RecyclerView
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
              /*
                Kode ini akan dijalankan ketika ada error dan
                pengambilan data error tersebut lalu memprint error nya
                ke LogCat
               */
                        Toast.makeText(getApplicationContext(),"Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                        Log.e("MyListActivity", databaseError.getDetails()+" "+databaseError.getMessage());
                    }
                });
    }

    private void MyRecyclerView() {
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }
}
