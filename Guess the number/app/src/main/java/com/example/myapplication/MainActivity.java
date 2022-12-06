package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText leftInput;
    private EditText rightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftInput = findViewById(R.id.number_in1);
        rightInput = findViewById(R.id.number_in2);
    }

    public void runGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        int left = Integer.parseInt(leftInput.getText().toString());
        int right = Integer.parseInt(rightInput.getText().toString());
        intent.putExtra("start",left);
        intent.putExtra("end",right);
        startActivity(intent);

    }
}