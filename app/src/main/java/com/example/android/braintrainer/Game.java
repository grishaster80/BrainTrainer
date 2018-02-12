package com.example.android.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Game extends AppCompatActivity {
    Button[] buttonsArray = new Button[4];
    TextView score, expression;
    Integer rightAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final TextView timeLeft = (TextView)findViewById(R.id.timeLeft);
        score = (TextView)findViewById(R.id.score);
        expression = (TextView)findViewById(R.id.expression);
        buttonsArray = new Button[4];
        buttonsArray[0] = (Button)findViewById(R.id.option0);
        buttonsArray[1] = (Button)findViewById(R.id.option1);
        buttonsArray[2] = (Button)findViewById(R.id.option2);
        buttonsArray[3] = (Button)findViewById(R.id.option3);



        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeLeft.setText("0:" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timeLeft.setText("done!");
            }
        }.start();

        startGame();
    }

    public void optionClicked(View view){

    }

    public void startGame(){
        Integer leftOperand,rightOperand,tmpOperation;
        String operation;
        Integer variants[] = new Integer[4];
        Random random = new Random();
        leftOperand = random.nextInt(9)+1;
        rightOperand = random.nextInt(9)+1;
        tmpOperation = random.nextInt(2);
        if(tmpOperation == 0){
            operation = "+";
            rightAns = leftOperand + rightOperand;
        }
        else{
            operation = "*";
            rightAns = leftOperand * rightOperand;
        }
        expression.setText(Integer.toString(leftOperand)+" "+operation+" "+rightOperand);
        for (int i =0;i<4;i++){
            Random tmpRandom = new Random();
            int tmpValue = tmpRandom.nextInt(81)+1;
            if(i==0){
                variants[0] = rightAns;
            }
            else if(tmpValue==variants[i-1]){
                while(true){
                    int myValue = tmpRandom.nextInt(81)+1;
                    if(myValue != tmpValue){
                        tmpValue = myValue;
                        break;
                    }
                variants[i] = tmpValue;
                }

            }
            else{
                variants[i] = tmpValue;
            }

        }


    }
}
