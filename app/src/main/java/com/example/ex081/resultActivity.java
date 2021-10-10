package com.example.ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    TextView scoreRed, scoreBlue, theWinner;
    Intent gi;
    int redFinal, blueFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreRed = (TextView) findViewById(R.id.scoreRed);
        scoreBlue = (TextView) findViewById(R.id.scoreBlue);
        theWinner = (TextView) findViewById(R.id.theWinner);

        gi = getIntent();
        redFinal = gi.getIntExtra("redPlayer", 0);
        blueFinal = gi.getIntExtra("bluePlayer", 0);

        scoreRed.setText("Red Score:\n  " + redFinal);
        scoreBlue.setText("Blue Score:\n  " + blueFinal);

        if (redFinal > blueFinal)
        {
            theWinner.setText("The winner is red");
        }
        else if (redFinal < blueFinal)
        {
            theWinner.setText("The winner is blue");
        }
        else
        {
            theWinner.setText("There is tie");
        }
    }

    public void goBack(View view) {
        gi.putExtra("returnValue", 0);
        setResult(RESULT_OK,gi);
        finish();
    }
}