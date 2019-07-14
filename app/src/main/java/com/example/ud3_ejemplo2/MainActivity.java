package com.example.ud3_ejemplo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método que crea un Intent explícito para abrir la Actividad 1
     *
     * @param view
     */
    public void abrirActividad1(View view){
        Intent intent = new Intent(MainActivity.this, Actividad1.class);
        startActivity(intent);
    }

    /**
     * Método que crea un Intent explícito para abrir la Actividad 2
     *
     * @param view
     */
    public void abrirActividad2(View view){
        Intent intent = new Intent(MainActivity.this, Actividad2.class);
        startActivity(intent);
    }
}
