package com.example.codenames.Pantallas;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.codenames.Clases.Room;
import com.example.codenames.Clases.adapter_rv_cardview;
import com.example.codenames.R;
import com.example.codenames.fragments.ChangePasswordDialog;
import com.example.codenames.fragments.create_room_dialog;
import com.example.codenames.utils.Constants;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class lobby extends AppCompatActivity {

    FloatingActionButton fab;
    Button btn_menu;
    adapter_rv_cardview adapter;
    static ArrayList<Room> listasalas = new ArrayList<Room>();
    Socket mSocket ;
    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {
        }
    }

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        mSocket.connect();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->{
            //showdialog();
            ejemplo();
        });

        listasalas.clear();
        listasalas.add(new Room("No"));
        listasalas.add(new Room("Pagaremos"));
        listasalas.add(new Room("1"));
        listasalas.add(new Room("5"));
        listasalas.add(new Room("0"));
        listasalas.add(new Room("0"));
        listasalas.add(new Room("0"));
        rv = findViewById(R.id.rv_salas);

        rv.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new adapter_rv_cardview(listasalas, getApplicationContext(), rv);
        rv.setAdapter(adapter);

        //rv.setLayoutAnimation(layoutAnimationController);
        rv.getAdapter().notifyDataSetChanged();
        rv.scheduleLayoutAnimation();

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getApplicationContext(), "Picaste: " + listasalas.get(rv.getChildAdapterPosition(v)).getName(), Toast.LENGTH_SHORT).show();
                mSocket.disconnect();
            }
        });

    }

    private void showdialog(){
        create_room_dialog fragment = new create_room_dialog();
        fragment.show(getSupportFragmentManager(),create_room_dialog.TAG);
    }

    private void ejemplo(){
        mSocket.emit("event","hola");

    }
}
