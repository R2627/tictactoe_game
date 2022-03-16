package com.example.tictactoegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText first,second;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        first=(EditText) findViewById(R.id.first);
        second=(EditText) findViewById(R.id.second);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstname=first.getText().toString();
                String secondname=second.getText().toString();
                Intent intent=new Intent(MainActivity.this,Game.class);
                intent.putExtra("",firstname);
                intent.putExtra("",secondname);

                startActivity(intent);
            }
        });
    }
}