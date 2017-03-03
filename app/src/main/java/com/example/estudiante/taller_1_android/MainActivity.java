package com.example.estudiante.taller_1_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Comunicacion com;
    ImageButton up;
    ImageButton down;
    ImageButton left;
    ImageButton right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = (ImageButton) findViewById(R.id.up);
        down = (ImageButton) findViewById(R.id.down);
        right = (ImageButton) findViewById(R.id.right);
        left = (ImageButton) findViewById(R.id.left);

        up.setOnClickListener(this);
        down.setOnClickListener(this);
        right.setOnClickListener(this);
        left.setOnClickListener(this);
    }

    public void onClick(View v){
        String mensaje = null;
        if (v.getId() == up.getId()){
            mensaje = "up";
            com.getInstance().enviar(mensaje.getBytes());
        }
        if (v.getId() == down.getId()){
            mensaje = "down";
            com.getInstance().enviar(mensaje.getBytes());
        }
        if (v.getId() == right.getId()){
            mensaje = "right";
            com.getInstance().enviar(mensaje.getBytes());
        }
        if (v.getId() == left.getId()){
            mensaje = "left";
            com.getInstance().enviar(mensaje.getBytes());
        }

    }
}