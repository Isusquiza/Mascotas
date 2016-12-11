package com.llavador.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Bio extends AppCompatActivity {
    private Toolbar toolBar;
    Button bVolver;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        bVolver = (Button) findViewById(R.id.bVolver);
        activity = this;

        if (toolBar != null){
            setSupportActionBar(toolBar);
            getSupportActionBar().setIcon(R.drawable.ic_huella_gato);
        }
        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });
    }
}
