package com.example.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickPlayBtn(View view){
        TextView showname=findViewById(R.id.showname);
        EditText inputname=findViewById(R.id.inputName);
        showname.setText("Your name is: "+ inputname.getText().toString());
    }
}