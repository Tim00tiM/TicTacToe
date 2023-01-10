package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Winner extends Dialog {

    private final String message;
    private final Game activity;
    public Winner(@NonNull Context context, String message, Game activity){
        super(context);
        this.activity = activity;
        this.message = message;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog);

        TextView winText = findViewById(R.id.winnerText);
        Button restart = findViewById(R.id.restart_button);

        winText.setText(message);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.restartMatch();
                dismiss();
            }
        });
    }
}
