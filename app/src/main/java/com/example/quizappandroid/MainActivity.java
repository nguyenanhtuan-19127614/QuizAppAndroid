package com.example.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickPlayBtn(View view){
        EditText inputname=findViewById(R.id.inputName);
        String welcome= "Hello "+ inputname.getText().toString();
        Toast toast = Toast.makeText(MainActivity.this, welcome,  Toast.LENGTH_SHORT);
        toast.show();
    }
}