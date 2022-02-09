package com.example.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
    String playerName;
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
        EditText inputname=findViewById(R.id.inputName);

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
                    changeColorAnimation(opt,Color.parseColor("#6200EE"),Color.GREEN);
                }
                else
                {
                    opt.setBackgroundColor(Color.RED);
                    changeColorAnimation(opt,Color.parseColor("#6200EE"),Color.RED);
                }

                //opt.setBackgroundColor(Color.parseColor("#6200EE"));
                numQuest++;
                curPos=random.nextInt(quizList.size());
                setView(curPos);
            }
        });
    }
    private void changeColorAnimation(Button opt, int colorFrom, int colorTo){
        ValueAnimator colorAnimation1 = ValueAnimator.ofObject(new ArgbEvaluator(),
                colorFrom,  colorTo);

        colorAnimation1.setDuration(1000); // milliseconds
        colorAnimation1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                opt.setBackgroundColor((int) valueAnimator.getAnimatedValue());
            }
        });
        colorAnimation1.start();

        ValueAnimator colorAnimation2 = ValueAnimator.ofObject(new ArgbEvaluator(),
                colorTo,  colorFrom);

        colorAnimation2.setDuration(500); // milliseconds
        colorAnimation2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                opt.setBackgroundColor((int) valueAnimator.getAnimatedValue());
            }
        });
        colorAnimation2.setStartDelay(1000);
        colorAnimation2.start();
    }
    private void setView(int curPos){
        numberQuestionView.setText(" Number Question:" + numQuest+ "/" + quizList.size());
        scoreView.setText("Score:" + curScore);
        if(this.numQuest==this.quizList.size())
        {
            showResultDialog();

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
    private void showResultDialog(){
        AlertDialog.Builder resultDialog = new AlertDialog.Builder(this);

        resultDialog.setTitle("RESULT");
        resultDialog.setMessage("NAME: ");
        resultDialog.setMessage("SCORE: " + curScore);
        resultDialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        resultDialog.setNegativeButton("Replay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                curScore=0;
                numQuest=0;
                numberQuestionView.setText(" Number Question:" + numQuest+ "/" + quizList.size());
                scoreView.setText("Score:" + curScore);

                curPos=random.nextInt(quizList.size());
                questionName.setText(quizList.get(curPos).getQuestion());
                option1.setText(quizList.get(curPos).getAns1());
                option2.setText(quizList.get(curPos).getAns2());
                option3.setText(quizList.get(curPos).getAns3());
                option4.setText(quizList.get(curPos).getAns4());
                
                dialog.cancel();
            }
        });
        AlertDialog al = resultDialog.create();
        al.show();
    }
}
