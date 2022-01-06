package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int PLAYER_X=1;
    int PLAYER_O=0;

    private int activePlayer =PLAYER_O;
    private int []filledPos ={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        setContentView(binding.getRoot());
        SetGame();

        binding.playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restartgame();
            }
        });



    }
    public void Restartgame(){
        ResetGame();
        filledPos = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        SetGame();
    }
    public void checkGameState(){
        int [][] winning ={{0,1,2},{0,3,6},{0,4,8},{2,4,6},{2,5,8},{6,7,8},{3,4,5},{2,5,8}};
        if(filledPos[0]!=-1 && filledPos[1]!=-1 && filledPos[2]!=-1 && filledPos[3]!=-1 && filledPos[4]!=-1 && filledPos[5]!=-1 && filledPos[6]!=-1 && filledPos[7]!=-1 && filledPos[8]!=-1 ){
            Toast.makeText(this, "GameDraw", Toast.LENGTH_SHORT).show();
            Restartgame();
        }
        for(int []array : winning){
            if(filledPos[array[0]]==PLAYER_O && filledPos[array[1]]==PLAYER_O && filledPos[array[2]]==PLAYER_O){
                Toast.makeText(this, "Player O Won", Toast.LENGTH_SHORT).show();
                Restartgame();
            }
            if(filledPos[array[0]]==PLAYER_X && filledPos[array[1]]==PLAYER_X && filledPos[array[2]]==PLAYER_X){
                Toast.makeText(this, "Player X Won", Toast.LENGTH_SHORT).show();
                Restartgame();
            }

        }



    }
    public void SetGame(){
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked(v);
                checkGameState();
            }
        });
    }

    public void onclicked(View v){
        Button clickedBtn=findViewById(v.getId());
        int clickedTag= Integer.parseInt(v.getTag().toString());
       if(filledPos[clickedTag-1] != -1)
           return;
        filledPos[clickedTag-1]=activePlayer;
        if(activePlayer==PLAYER_O){
            clickedBtn.setText("O");
            activePlayer=PLAYER_X;
            binding.playerTurn.setText("X");
        }else {
            clickedBtn.setText("X");
            activePlayer=PLAYER_O;
            binding.playerTurn.setText("O");
        }

    }
    public void ResetGame() {
        binding.button1.setText(" ");
        binding.button2.setText(" ");
        binding.button3.setText(" ");
        binding.button4.setText(" ");
        binding.button5.setText(" ");
        binding.button6.setText(" ");
        binding.button7.setText(" ");
        binding.button8.setText(" ");
        binding.button9.setText(" ");
    }
}