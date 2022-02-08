package com.example.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private TextView scoreView,numberQuestionView, questionName;
    private Button option1,option2,option3,option4;
    private ArrayList<QuizBody> quizList;
    Random random;
    int curPos, curScore=0, numQuest=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        numberQuestionView=findViewById(R.id.numberQuestion);
        scoreView=findViewById(R.id.scoreView);
        questionName=findViewById(R.id.questionName);
        option1=findViewById(R.id.opt1);
        option2=findViewById(R.id.opt2);
        option3=findViewById(R.id.opt3);
        option4=findViewById(R.id.opt4);
        quizList=new ArrayList<>();
        random=new Random();
    }
    private void GetQuiz(ArrayList<QuizBody> quizList){
        quizList.add(new QuizBody("1+1","2","3","4","5","2"));
        quizList.add(new QuizBody("1+2","2","3","4","5","3"));
        quizList.add(new QuizBody("1+3","2","3","4","5","4"));
        quizList.add(new QuizBody("1+4","2","3","4","5","5"));
        quizList.add(new QuizBody("1+5","2","6","4","5","6"));

    }
}