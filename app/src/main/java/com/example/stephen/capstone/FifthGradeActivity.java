package com.example.stephen.capstone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Stephen on 2/17/2016.
 */
public class FifthGradeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_grade_subject_choice);

        Button math_btn = (Button) findViewById(R.id.math_button);

        math_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FifthGradeActivity.this, FifthGradeQuiz.class));
            }
        });


    }
}
