package com.example.ex081;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button redBtn, blueBtn;
    int redScore, blueScore;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBtn = (Button)findViewById(R.id.redBtn);
        blueBtn = (Button)findViewById(R.id.blueBtn);

        redScore = 0;
        blueScore = 0;

        redBtn.setOnLongClickListener(this);

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueScore++;
            }
        });

    }

    public void goResults(View view) {
        si = new Intent(this, resultActivity.class);
        si.putExtra("bluePlayer", blueScore);
        si.putExtra("redPlayer", redScore);
        startActivityForResult(si, 1);
    }

    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            blueScore = data_back.getIntExtra("returnValue",0);
            redScore = data_back.getIntExtra("returnValue",0);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        redScore+=2;
        return true;
    }
}