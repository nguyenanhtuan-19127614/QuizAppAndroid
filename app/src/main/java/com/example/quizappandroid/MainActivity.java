package com.example.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button playBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn =(Button)findViewById(R.id.playButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputname=findViewById(R.id.inputName);
                String welcome= "Hello "+ inputname.getText().toString();
                Toast toast = Toast.makeText(MainActivity.this, welcome,  Toast.LENGTH_SHORT);
                toast.show();
                openQuizActivity();
            }
        });
    }
    public void openQuizActivity(){
        Intent quizActivity = new Intent(this, QuizActivity.class);
        startActivity(quizActivity);
    }
}