package com.example.stephen.capstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button first_btn = (Button)findViewById(R.id.first_grade_button);
        Button second_btn = (Button)findViewById(R.id.second_grade_button);
        Button third_btn = (Button)findViewById(R.id.third_grade_button);
        Button fourth_btn = (Button)findViewById(R.id.fourth_grade_button);
        Button fifth_btn = (Button)findViewById(R.id.fifth_grade_button);

        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstGradeActivity.class));
            }
        });

        second_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondGradeActivity.class));
            }
        });

        third_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThirdGradeActivity.class));
            }
        });

        fourth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FourthGradeActivity.class));
            }
        });

        fifth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FifthGradeActivity.class));
            }
        });
    }

}
