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

            textView = findViewById(R.id.textView);
//            resetButton = findViewById(R.id.button2);
        }

        Block[] blocks = {new Block(),new Block(),new Block(),
                new Block(),new Block(),new Block(),
                new Block(),new Block(),new Block()};
        public int Turn = -1;
        public int gameState = 0;
        TextView textView;
        ImageView img;
        Button resetButton;
//        public void reset(){
//            for (int i = 0; i<blocks.length; i++){
//                blocks[i] = new Block();
//            }
//            gameState = 0;
//            for (int i = 0; i<blocks.length; i++){
//                ImageView tempImgVar = img.findViewById(i);
//                tempImgVar.setImageDrawable(null);
//            }
//        }
        public void checkWin(){
            if ((blocks[0] instanceof XBlock && blocks[1] instanceof XBlock && blocks[2] instanceof XBlock) ||
                    (blocks[3] instanceof XBlock && blocks[4] instanceof XBlock && blocks[5] instanceof XBlock) ||
                    (blocks[6] instanceof XBlock && blocks[7] instanceof XBlock && blocks[8] instanceof XBlock) ||
                    (blocks[2] instanceof XBlock && blocks[4] instanceof XBlock && blocks[6] instanceof XBlock) ||
                    (blocks[0] instanceof XBlock && blocks[3] instanceof XBlock && blocks[6] instanceof XBlock) ||
                    (blocks[0] instanceof XBlock && blocks[4] instanceof XBlock && blocks[8] instanceof XBlock) ||
                    (blocks[1] instanceof XBlock && blocks[4] instanceof XBlock && blocks[7] instanceof XBlock) ||
                    (blocks[2] instanceof XBlock && blocks[5] instanceof XBlock && blocks[8] instanceof XBlock) )
            {
                textView.setText("X has won");
                gameState = 1;
            } else if ((blocks[0] instanceof OBlock && blocks[1] instanceof OBlock && blocks[2] instanceof OBlock) ||
                    (blocks[3] instanceof OBlock && blocks[4] instanceof OBlock && blocks[5] instanceof OBlock) ||
                    (blocks[6] instanceof OBlock && blocks[7] instanceof OBlock && blocks[8] instanceof OBlock) ||
                    (blocks[2] instanceof OBlock && blocks[4] instanceof OBlock && blocks[6] instanceof OBlock) ||
                    (blocks[0] instanceof OBlock && blocks[3] instanceof OBlock && blocks[6] instanceof OBlock) ||
                    (blocks[0] instanceof OBlock && blocks[4] instanceof OBlock && blocks[8] instanceof OBlock) ||
                    (blocks[1] instanceof OBlock && blocks[4] instanceof OBlock && blocks[7] instanceof OBlock) ||
                    (blocks[2] instanceof OBlock && blocks[5] instanceof OBlock && blocks[8] instanceof OBlock) )
            {
                textView.setText("O has won");
                gameState = 1;
            } else {
                textView.setText("draw");
            }
        }

        public void Game(View view){
            if (gameState == 0){
                img = (ImageView) view;
                if (Turn == -1) {
                    blocks[Integer.parseInt(img.getTag().toString())] = new XBlock();
                    checkWin();
                    img.setImageResource(R.drawable.x);
                }
                if (Turn == 1){
                    blocks[Integer.parseInt(img.getTag().toString())] = new OBlock();
                    checkWin();
                    img.setImageResource(R.drawable.o);
                }
                Turn *= -1;
            }
//            if (gameState == 1){
//                reset();
//            }
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