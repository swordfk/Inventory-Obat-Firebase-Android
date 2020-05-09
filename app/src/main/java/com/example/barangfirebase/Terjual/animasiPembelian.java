package com.example.barangfirebase.Terjual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.barangfirebase.Home.home;
import com.example.barangfirebase.R;

public class animasiPembelian extends AppCompatActivity {
    TextView backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animasi_pembelian);

        backhome=findViewById(R.id.backHome);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), home.class));
            }
        });
    }
}
