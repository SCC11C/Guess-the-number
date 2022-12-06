package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private int left;
    private int right;
    private TextView textOnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        left = intent.getIntExtra("start",0);
        right = intent.getIntExtra("end", 100);
        textOnShow = findViewById(R.id.text_to_show);
        textOnShow.setText(String.format("Ваше число больше %d",(right + left) / 2));
//        Toast.makeText(this, String.format("%d - %d",left, right), Toast.LENGTH_LONG).show();
    }

    private boolean isAnswerFind() {
        if (right - left == 1) {
            textOnShow.setText(String.format("Ваше число %d", right));
            return true;
        }
        return false;
    }

    public void clickYes(View view) {
        if (isAnswerFind()){
            return;
        }
        left = left + (right - left) / 2;
        textOnShow.setText(String.format("Ваше число больше %d", (right + left) / 2));
    }

    public void clickNo(View view) {
        if (isAnswerFind()){
            return;
        }
        right = right - (right - left) / 2;
        textOnShow.setText(String.format("Ваше число больше %d", (right + left) / 2));
    }
}