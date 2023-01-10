package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Game extends AppCompatActivity {

    String[] field = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    int currentPlayer;
    int totalMoves = 0;
    int startPlayer = 0;
    int firstPlayerScore = 0;
    int secondPlayerScore = 0;

    View firstIcon;
    View secondIcon;

    View image1;
    View image2;
    View image3;
    View image4;
    View image5;
    View image6;
    View image7;
    View image8;
    View image9;
    View[] listOfView = new View[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        currentPlayer = startPlayer;

        firstIcon = findViewById(R.id.player1_icon);
        secondIcon = findViewById(R.id.player2_icon);

        image1 = (View)findViewById(R.id.textView1);
        image2 = (View)findViewById(R.id.textView2);
        image3 = (View)findViewById(R.id.textView3);
        image4 = (View)findViewById(R.id.textView4);
        image5 = (View)findViewById(R.id.textView5);
        image6 = (View)findViewById(R.id.textView6);
        image7 = (View)findViewById(R.id.textView7);
        image8 = (View)findViewById(R.id.textView8);
        image9 = (View)findViewById(R.id.textView9);
        listOfView[0] = image1;
        listOfView[1] = image2;
        listOfView[2] = image3;
        listOfView[3] = image4;
        listOfView[4] = image5;
        listOfView[5] = image6;
        listOfView[6] = image7;
        listOfView[7] = image8;
        listOfView[8] = image9;

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(0)){
                    setSign(0);

                }

            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(1)){
                    setSign(1);
                }


            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(2)){
                    setSign(2);
                }


            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(3)){
                    setSign(3);
                }


            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(4)){
                    setSign(4);
                }

            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(5)){
                    setSign(5);
                }

            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(6)){
                    setSign(6);
                }

            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(7)){
                    setSign(7);
                }

            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectable(8)){
                    setSign(8);
                }

            }
        });
    }

    private boolean isSelectable(int numberOfBox){
        if (field[numberOfBox]==" "){
            return true;
        }
        else{
            return false;
        }

    }

    private void setSign(int numberOfBox) {
        totalMoves += 1;
        field[numberOfBox] = String.valueOf(currentPlayer);
        ImageView img = (ImageView) listOfView[numberOfBox];
        if (currentPlayer == 0) {
            img.setImageResource(R.drawable.xtic);
            secondIcon.setBackgroundResource(R.drawable.current_mover);
            firstIcon.setBackground(null);

        } else {
            img.setImageResource(R.drawable.otic);
            firstIcon.setBackgroundResource(R.drawable.current_mover);
            secondIcon.setBackground(null);
        }

        if (checkWin(field)) {
            Winner winnerDialog = new Winner(Game.this, "Winner is player " + String.valueOf(currentPlayer + 1), Game.this);
            if (currentPlayer == 1){
                secondPlayerScore +=1;
            }
            else{
                firstPlayerScore +=1;
            }
            winnerDialog.setCancelable(false);
            winnerDialog.show();

        } else if (totalMoves == 9) {
            Winner winnerDialog = new Winner(Game.this, "It is a draw(", Game.this);
            winnerDialog.setCancelable(false);
            winnerDialog.show();
        } else {
            currentPlayer = 1 - currentPlayer;
        }
    }

    private boolean checkWin(String[] table){
        for (int i=0; i<3;i++){
            if (table[i] == table[i+3] && table[i+3] == table[i+6] && table[i+6] != " "){
                return true;
            }
        }
        for (int i=0; i<3;i++){
            if (table[3*i] == table[1+3*i] && table[1+i*3] == table[2+3*i] && table[2+3*i] != " "){
                return true;
            }
        }
        if (table[0] == table[4] && table[4] == table[8] && table[8] != " "){
            return true;
        }
        if (table[2] == table[4] && table[4] == table[6] && table[6] != " "){
            return true;
        }
        return false;

    }

    public void restartMatch(){

        for (View i: listOfView){
            ImageView img = (ImageView) i;
            img.setImageDrawable(null);
        }
        totalMoves = 0;
        currentPlayer = 1-startPlayer;
        startPlayer = currentPlayer;

        if (currentPlayer == 1) {
            secondIcon.setBackgroundResource(R.drawable.current_mover);
            firstIcon.setBackground(null);

        } else {
            firstIcon.setBackgroundResource(R.drawable.current_mover);
            secondIcon.setBackground(null);
        }

        TextView score = findViewById(R.id.score);
        score.setText(String.valueOf(firstPlayerScore)+":"+String.valueOf(secondPlayerScore));
        field = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    }

}


