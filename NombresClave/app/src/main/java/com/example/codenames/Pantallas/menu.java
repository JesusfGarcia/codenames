package com.example.codenames.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.codenames.R;
import com.example.codenames.utils.Constants;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class menu extends AppCompatActivity {
    private Button btnsettings;
    //private Socket mSocket;
    private Button btnrooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnsettings = findViewById(R.id.btnsettings);
        btnsettings.setOnClickListener(view -> settings());
        btnrooms = findViewById(R.id.btn_ingresar);
        btnrooms.setOnClickListener(view -> salas());

    }

    private void settings(){
        Intent intent = new Intent(this, Activity_profile.class);
        startActivity(intent);
    }

    private void salas(){
        Intent intent = new Intent(this,lobby.class);
        startActivity(intent);
    }
}
