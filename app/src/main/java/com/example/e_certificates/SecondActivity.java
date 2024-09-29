package com.example.e_certificates;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private TextView answer1,answer2;
    private String answer1Text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        answer1=findViewById(R.id.answer1);
        answer2=findViewById(R.id.answer2);
        ArrayList<String> question1 = getIntent().getStringArrayListExtra("question1");
       if(question1!=null) {
           for (String option : question1) {
               answer1Text = answer1Text + option + "\n";
           }
       }else{answer1Text="";}
        answer1.setText(answer1Text);
        answer2.setText(this.getIntent().getStringExtra("question2"));

    }
}