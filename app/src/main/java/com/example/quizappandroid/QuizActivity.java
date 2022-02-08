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
        getQuiz(quizList);
        curPos=random.nextInt(quizList.size());
        setView(curPos);
    }
    private void getQuiz(ArrayList<QuizBody> quizList){
        quizList.add(new QuizBody("1+1","2","3","4","5","2"));
        quizList.add(new QuizBody("1+2","2","3","4","5","3"));
        quizList.add(new QuizBody("1+3","2","3","4","5","4"));
        quizList.add(new QuizBody("1+4","2","3","4","5","5"));
        quizList.add(new QuizBody("1+5","2","6","4","5","6"));

    }
    private void setView(int curPos){
        numberQuestionView.setText("Number Question:" + this.numQuest+ "/" + this.quizList.size());
        scoreView.setText("Score:" + curScore);
        questionName.setText(quizList.get(curPos).getQuestion());
        option1.setText(quizList.get(curPos).getAns1());
        option2.setText(quizList.get(curPos).getAns2());
        option3.setText(quizList.get(curPos).getAns3());
        option4.setText(quizList.get(curPos).getAns4());
    }
}