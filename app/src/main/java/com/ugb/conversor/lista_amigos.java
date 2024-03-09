package com.ugb.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class lista_amigos extends AppCompatActivity {
    FloatingActionButton btnagregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_amigos);

        btnagregar = findViewById(R.id.fabagregaramigo);
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriractividad();
            }
        });
    }
    private void abriractividad(){
        Intent abriractividad = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(abriractividad);
    }
}