package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class TicTacToe extends AppCompatActivity {

    public int count=0, loop_count=0;
    private int arr[][]={{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    private Intent playint;
    private String player1,player2;
    TextView player1_name,player2_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        playint = getIntent();
        player1=playint.getStringExtra("Player1");
        player2=playint.getStringExtra("Player2");

            player1_name= (TextView) findViewById(R.id.player1);
            player1_name.setText(player1);
            player1_name.setBackgroundResource(R.color.purple_200);
            player2_name= (TextView) findViewById(R.id.player2);
            player2_name.setText(player2);

    }

    public void actionOnTouch(View view) {
        ImageView image= (ImageView) view;
        String s =view.getResources().getResourceName(view.getId());
        int leng=s.length();
        int idrow = Integer.parseInt(s.substring(leng-1,leng));
        int idcol = Integer.parseInt(s.substring(leng-2,leng-1));
        loop_count++;

        if(count==0){
        image.setImageResource(R.drawable.black);

        Log.i("count",String.valueOf(count));
            count++;
            player1_name.setBackgroundResource(R.color.white);
            player2_name.setBackgroundResource(R.color.purple_200);
        }
        else {
            image.setImageResource(R.drawable.cross);
            Log.i("count",String.valueOf(count));
            count--;
            player2_name.setBackgroundResource(R.color.white);
            player1_name.setBackgroundResource(R.color.purple_200);
        }
        winnerOne(idrow,idcol);



    }

    private void winnerOne(int row, int column) {
       arr[row][column]=count;

        Intent inte = new Intent(this, showingWinner.class);
        if(result(row, column)){
            inte.putExtra("value","0");
            String winner= new String();
            if(count==1)
                winner=player1;
            else
                winner=player2;
            Log.i("tictacwinner",winner);
            //Log.i("loop count",String.valueOf(loop_count));
            inte.putExtra("Winner",winner);
            loop_count=(loop_count/2)+count;
            inte.putExtra("moves",String.valueOf(loop_count));
            startActivity(inte);
        } else if (loop_count==9) {
            inte.putExtra("draw","Draw");
            inte.putExtra("value","-1");
            startActivity(inte);
        }
    }

    private boolean result(int row, int column) {
        boolean ans = false;
        //for row
        ans=(arr[row][0]==count && arr[row][1]==count && arr[row][2]==count)?true:false;
        if(ans)
            return ans;
        //for column
        ans=(arr[0][column]==count && arr[1][column]==count && arr[2][column]==count)?true:false;
        if(ans)
            return ans;

        //for diagonal
        if((row==1 && column==1) || !(row==1 && column==1)) {
            ans=(arr[0][0]==count && arr[1][1]==count && arr[2][2]==count)?true:false;
            if(ans)
                return ans;
            ans=(arr[0][2]==count && arr[1][1]==count && arr[2][0]==count)?true:false;
            if(ans)
                return ans;
        }

        return ans;
    }
}