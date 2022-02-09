package com.example.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private TextView scoreView,numberQuestionView, questionName;
    private Button option1,option2,option3,option4;
    private ArrayList<QuizBody> quizList;
    Random random;
    int curPos, curScore=0, numQuest=0;
    Drawable originBtnColor;
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
        originBtnColor=option1.getBackground();
        quizList=new ArrayList<>();
        random=new Random();
        //lấy dữ liệu quiz
        getQuiz(quizList);
        curPos=random.nextInt(quizList.size());
        //set data lên màn hình
        setView(curPos);
        //handle button answer click
        optionClick(option1);
        optionClick(option2);
        optionClick(option3);
        optionClick(option4);
    }

    private void getQuiz(ArrayList<QuizBody> quizList){
        quizList.add(new QuizBody("1+1","2","3","4","5","2"));
        quizList.add(new QuizBody("1+2","2","3","4","5","3"));
        quizList.add(new QuizBody("1+3","2","3","4","5","4"));
        quizList.add(new QuizBody("1+4","2","3","4","5","5"));
        quizList.add(new QuizBody("1+5","2","6","4","5","6"));

    }
    private void optionClick(Button opt)
    {
        opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizList.get(curPos).getTrueAns().trim().toLowerCase().equals(
                        opt.getText().toString().trim().toLowerCase()))
                {
                    curScore+=1;
                    opt.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    opt.setBackgroundColor(Color.RED);
                }

                numQuest++;
                curPos=random.nextInt(quizList.size());
                setView(curPos);
            }
        });
    }
    private void setView(int curPos){
        numberQuestionView.setText(" Number Question:" + this.numQuest+ "/" + this.quizList.size());
        scoreView.setText("Score:" + curScore);
        if(this.numQuest==this.quizList.size())
        {
            String result= "Your Score Is: "+ curScore;
            Toast toast = Toast.makeText(QuizActivity.this, result,  Toast.LENGTH_SHORT);
            toast.show();
            this.curPos=random.nextInt(quizList.size());
            curScore=0;
            numQuest=0;
            numberQuestionView.setText(" Number Question:" + this.numQuest+ "/" + this.quizList.size());
            scoreView.setText("Score:" + curScore);
        }
        else
        {

            questionName.setText(quizList.get(curPos).getQuestion());
            option1.setText(quizList.get(curPos).getAns1());
            option2.setText(quizList.get(curPos).getAns2());
            option3.setText(quizList.get(curPos).getAns3());
            option4.setText(quizList.get(curPos).getAns4());
        }
    }
}