package com.example.tictactoegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    char[][] playBoard;
    TableLayout grid_board;
    TextView result;
    char turn;
    Button reset;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        initialize();
        reset=(Button)findViewById(R.id.reset);
        back=(ImageView) findViewById(R.id.back);

        Button reset_btn = (Button) findViewById(R.id.reset);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent current = getIntent();
                finish();
                startActivity(current);
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    void initialize(){
        result=(TextView)findViewById(R.id.result);
        playBoard= new char[3][3];
        turn='X';
        grid_board=(TableLayout) findViewById(R.id.grid_board);
        for(int row=0;row<grid_board.getChildCount();row++){
            TableRow tbRow=(TableRow) grid_board.getChildAt(row);
            for(int col =0;col<tbRow.getChildCount();col++){
                TextView cell =(TextView) tbRow.getChildAt(col);
                cell.setText("-");
                cell.setOnClickListener(move(row,col,cell));
            }

        }
    }

    View.OnClickListener move(int row, int col, TextView cell) {
        return   new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playBoard[row][col]=turn;
                if(turn=='X'){
                    cell.setText("X");
                    turn='O';
                }else if(turn=='O'){
                    cell.setText("O");
                    turn='X';
                }
                diagionalWin();
                horizontalWin();
                verticalWin();
            }
        };
    }
    void diagionalWin(){

        if( playBoard[0][0]=='X'&&playBoard[1][1]=='X'&& playBoard[2][2]=='X'){
            result.setText( " Player Win");
        }
        else if( playBoard[0][0]=='O'&&playBoard[1][1]=='O'&& playBoard[2][2]=='O'){
            result.setText("Second Player Win");
        }
        else if( playBoard[0][2]=='X'&&playBoard[1][1]=='X'&& playBoard[2][0]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[0][2]=='O'&&playBoard[1][1]=='O'&& playBoard[2][0]=='O'){
            result.setText("Second Player Win");
        }

    }
    void horizontalWin(){
        if( playBoard[0][0]=='X'&&playBoard[0][1]=='X'&& playBoard[0][2]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[0][0]=='O'&&playBoard[0][1]=='O'&& playBoard[0][2]=='O'){
            result.setText("Second Player Win");
        }
        else if( playBoard[1][0]=='X'&&playBoard[1][1]=='X'&& playBoard[1][2]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[1][0]=='O'&&playBoard[1][1]=='O'&& playBoard[1][2]=='O'){
            result.setText("Second Player Win");
        }else if( playBoard[2][0]=='X'&&playBoard[2][1]=='X'&& playBoard[2][2]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[2][0]=='O'&&playBoard[2][1]=='O'&& playBoard[2][2]=='O'){
            result.setText("Second Player Win");
        }


    }
    void  verticalWin(){

        if( playBoard[0][0]=='X'&&playBoard[1][0]=='X'&& playBoard[2][0]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[0][0]=='O'&&playBoard[1][0]=='O'&& playBoard[2][0]=='O'){
            result.setText("Second Player Win");
        }
        else if( playBoard[0][1]=='X'&&playBoard[1][1]=='X'&& playBoard[2][1]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[0][1]=='O'&&playBoard[1][1]=='O'&& playBoard[2][1]=='O'){
            result.setText("Second Player Win");

        }else if( playBoard[0][2]=='X'&&playBoard[1][2]=='X'&& playBoard[2][2]=='X'){
            result.setText("First Player Win");
        }
        else if( playBoard[0][2]=='O'&&playBoard[1][2]=='O'&& playBoard[2][2]=='O'){
            result.setText("Second Player Win");
        }

    }

};
