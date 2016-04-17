package com.example.stephen.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Stephen on 3/18/2016.
 */

public class ScoreActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView textResult = (TextView) findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        switch(score)
        {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: textResult.setText("Your score is " + " " + score + " out of 10. Looks like you need more practice!");
            case 6:
            case 7: textResult.setText("Your score is " + " " + score + " out of 10. Good job!");
            case 8:
            case 9: textResult.setText("Your score is " + " " + score + " out of 10. Great job!");
            case 10: textResult.setText("Your score is " + " " + score + " out of 10. Perfect score great job!");
                break;

        }
    }

    public void playagain(View o) {
        Intent intent = new Intent(this, FifthGradeQuiz.class);
        startActivity(intent);
    }
}
