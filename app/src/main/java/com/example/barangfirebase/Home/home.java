package com.example.barangfirebase.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.barangfirebase.Barang.MainActivity;
import com.example.barangfirebase.Barang.MyListData;
import com.example.barangfirebase.R;
import com.example.barangfirebase.Terjual.MyListDataTerjual;
import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity implements View.OnClickListener {
    Button ADD, SHOW, TERJUAL, LOGOUT;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ADD=findViewById(R.id.addBarang);
        SHOW=findViewById(R.id.showdata2);
        TERJUAL=findViewById(R.id.barangTerjual2);
        LOGOUT=findViewById(R.id.logout);

        ADD.setOnClickListener(this);
        SHOW.setOnClickListener(this);
        TERJUAL.setOnClickListener(this);
        LOGOUT.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addBarang :
                startActivity(new Intent(home.this, MainActivity.class));
                break;
            case R.id.showdata2 :
                startActivity(new Intent(home.this, MyListData.class));
                break;
            case R.id.barangTerjual2 :
                startActivity(new Intent(home.this, MyListDataTerjual.class));
                break;
            case R.id.logout :
                mAuth.signOut();
                break;
        }
    }
}
