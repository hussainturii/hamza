package com.example.myapplication.hamza;
//import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        }

        Block[] blocks = {new Block(),new Block(),new Block(),
                new Block(),new Block(),new Block(),
                new Block(),new Block(),new Block()};
        public static int Turn = -1;
        public boolean game = true;
        TextView textView;
        ImageView img;

        public void Move (View view){
            if (!game)
            {
                resetGame(view);
            }
            img = (ImageView) view;
            if (Turn == -1) {
                blocks[Integer.parseInt(img.getTag().toString())] = new XBlock();
                img.setImageResource(R.drawable.x);
                Turn = 1;
                textView.setText("O's turn to play!");
            } else{
                blocks[Integer.parseInt(img.getTag().toString())] = new OBlock();
                img.setImageResource(R.drawable.o);
                Turn = -1;
                textView.setText("X's turn to play!");
            }
            checkWin();
            checkGameDrawn();
        }

        public void reset (View view) //button
        {
            resetGame(view);
        }

        public void checkWin() {
            if ((blocks[0] instanceof XBlock && blocks[1] instanceof XBlock && blocks[2] instanceof XBlock) ||
                    (blocks[3] instanceof XBlock && blocks[4] instanceof XBlock && blocks[5] instanceof XBlock) ||
                    (blocks[6] instanceof XBlock && blocks[7] instanceof XBlock && blocks[8] instanceof XBlock) ||
                    (blocks[2] instanceof XBlock && blocks[4] instanceof XBlock && blocks[6] instanceof XBlock) ||
                    (blocks[0] instanceof XBlock && blocks[3] instanceof XBlock && blocks[6] instanceof XBlock) ||
                    (blocks[0] instanceof XBlock && blocks[4] instanceof XBlock && blocks[8] instanceof XBlock) ||
                    (blocks[1] instanceof XBlock && blocks[4] instanceof XBlock && blocks[7] instanceof XBlock) ||
                    (blocks[2] instanceof XBlock && blocks[5] instanceof XBlock && blocks[8] instanceof XBlock)) {
                textView.setText("X has won");
                game = false;
            } else if ((blocks[0] instanceof OBlock && blocks[1] instanceof OBlock && blocks[2] instanceof OBlock) ||
                    (blocks[3] instanceof OBlock && blocks[4] instanceof OBlock && blocks[5] instanceof OBlock) ||
                    (blocks[6] instanceof OBlock && blocks[7] instanceof OBlock && blocks[8] instanceof OBlock) ||
                    (blocks[2] instanceof OBlock && blocks[4] instanceof OBlock && blocks[6] instanceof OBlock) ||
                    (blocks[0] instanceof OBlock && blocks[3] instanceof OBlock && blocks[6] instanceof OBlock) ||
                    (blocks[0] instanceof OBlock && blocks[4] instanceof OBlock && blocks[8] instanceof OBlock) ||
                    (blocks[1] instanceof OBlock && blocks[4] instanceof OBlock && blocks[7] instanceof OBlock) ||
                    (blocks[2] instanceof OBlock && blocks[5] instanceof OBlock && blocks[8] instanceof OBlock)) {
                textView.setText("O has won");
                game = false;
            }
        }

        public void resetGame(View view)
        {
            game = true;
            Turn = -1;
            for (int i = 0; i<blocks.length; i++)
            {
                blocks[i] = new Block();
            }
            ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
            textView.setText("Tap to Play!");
        }

        public void checkGameDrawn() {
            for (Block cell : blocks) {
                if (cell.getValue() == '-') {
                    return; // there are still empty cells left on the grid
                }
            }
            textView.setText("Game drawn!");
        }

    }


 class Block {
    private char value;
    Block(){
        this.value = '-';
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
    class XBlock extends Block{
        XBlock(){
            super.setValue('X');
        }
    }
    class OBlock extends Block{

        OBlock(){
            super.setValue('O');
        }
    }