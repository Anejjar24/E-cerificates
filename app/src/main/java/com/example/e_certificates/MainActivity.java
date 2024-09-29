package com.example.e_certificates;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button suivant,quitter;
    private CheckBox option1,option2,option3,option4;
    private ArrayList<CheckBox> options= new ArrayList<>();
    private ArrayList<String> question1=new ArrayList<>();
    private String question2;


    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.radioGroup);
        suivant=findViewById(R.id.suivant);
        quitter=findViewById(R.id.quitter);

        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        suivant.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        for(CheckBox option:options){
                                            if(option.isChecked()){
                                                question1.add(option.getText().toString());
                                            }

                                        }
                                        RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                                        question2=selectedRadioButton.getText().toString();
                                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                        intent.putStringArrayListExtra("question1", question1);
                                        intent.putExtra("question2", question2);
                                        startActivity(intent);
                                        //Toast.makeText(MainActivity.this, gender+" "+ lastName.getText()+ firstName.getText()+" habite à "+cities.getSelectedItem(), Toast.LENGTH_LONG).show();
                                    }
                                }
        );
        quitter.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           MainActivity.this.finish();

                                       }
                                   }
        );

    }
}