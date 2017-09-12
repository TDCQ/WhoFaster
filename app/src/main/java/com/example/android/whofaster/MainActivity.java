package com.example.android.whofaster;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.android.whofaster.R.id.currentOfPlayerA;
import static com.example.android.whofaster.R.id.eyeOfPlayerA;
import static com.example.android.whofaster.R.id.messageBoxA;
import static com.example.android.whofaster.R.id.messageBoxB;

public class MainActivity extends AppCompatActivity {

    final int targetBlock = 144;
    int blockOfPlayerA = 0;
    int blockOfPlayerB = 0;
    String block = "█";
    boolean isGameEnd = true;
    boolean isStartA = false;
    boolean isStartB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // custom
        displayTarget();
        displayBlockOfA();
        displayBlockOfB();
    }

    public void displayTarget(){
        TextView blockOfPlayerA = (TextView) findViewById(R.id.targetOfPlayerA);
        blockOfPlayerA.setText("目标分：" + targetBlock);
        TextView blockOfPlayerB = (TextView) findViewById(R.id.targetOfPlayerB);
        blockOfPlayerB.setText("目标分：" + targetBlock);
    }

    public void displayBlockOfA(){
        String blocks = new String(new char[blockOfPlayerA]).replace("\0", block);
        if (blocks.length() == targetBlock){
            TextView BoxA = (TextView) findViewById(messageBoxA);
            BoxA.setText("恭喜， Player A 已经赢了");
            TextView BoxB = (TextView) findViewById(messageBoxB);
            BoxB.setText("很遗憾， Player A 已经赢了");
            endGame();
        }
        TextView blockOfPlayerA = (TextView) findViewById(R.id.blockOfPlayerA);
        blockOfPlayerA.setText(blocks);
        TextView PlayerA = (TextView) findViewById(currentOfPlayerA);
        PlayerA.setText("当前分：" + blocks.length());
        TextView eyePlayerA = (TextView) findViewById(eyeOfPlayerA);
        eyePlayerA.setText("敌方分数：" + blocks.length());


    }
    public void addOneForPlayerA(View view) {
        if (isGameEnd) { return;}
        if (blockOfPlayerA + 1  >= targetBlock) {
            blockOfPlayerA = targetBlock;
        }else {
            blockOfPlayerA = blockOfPlayerA + 1;
        }
        displayBlockOfA();
    }

    public void addTwoForPlayerA(View view) {
        if (isGameEnd) { return;}
        if (blockOfPlayerA + 2  >= targetBlock) {
            blockOfPlayerA = targetBlock;
        }else {
            blockOfPlayerA = blockOfPlayerA + 2;
        }
        displayBlockOfA();
    }

    public void addThreeForPlayerA(View view) {
        if (isGameEnd) { return;}
        if (blockOfPlayerA + 3  >= targetBlock) {
            blockOfPlayerA = targetBlock;
        }else {
            blockOfPlayerA = blockOfPlayerA + 3;
        }
        displayBlockOfA();
    }

    public void giveUpPlayerA(View view){
        if (isStartA && isStartB ) {
            TextView BoxB= (TextView) findViewById(messageBoxB);
            BoxB.setText("恭喜， Player A已经认输");
        }
        endGame();
    }

    private void endGame() {
        isStartB = false;
        isStartA = false;
        isGameEnd = true;
    }

    public void startPlayerA(View view){
        if (isGameEnd == false) return;
        isStartA = true;
        if (isStartB == true) {
            isGameEnd = false;
            blockOfPlayerA = 0;
            blockOfPlayerB = 0;
            displayBlockOfA();
            displayBlockOfB();
            cleanMessageBox();
        }
        // Button startA = (Button) findViewById(R.id.startPlayerA);
        // startA.setBackgroundColor(Color.RED);
    }

    public void displayBlockOfB(){
        String blocks = new String(new char[blockOfPlayerB]).replace("\0", block);
        if (blocks.length() == targetBlock){
            TextView BoxB = (TextView) findViewById(messageBoxB);
            BoxB.setText("恭喜， Player B 已经赢了");
            TextView BoxA = (TextView) findViewById(messageBoxA);
            BoxA.setText("很遗憾， Player B 已经赢了");
            endGame();
        }
        TextView blockOfB = (TextView) findViewById(R.id.blockOfPlayerB);
        blockOfB.setText(blocks);
        TextView currentOfPlayerB = (TextView) findViewById(R.id.currentOfPlayerB);
        currentOfPlayerB.setText("当前分：" + blocks.length());
        TextView eyeOfPlayerB = (TextView) findViewById(R.id.eyeOfPlayerB);
        eyeOfPlayerB.setText("敌方分数：" + blocks.length());


    }
    public void addOneForPlayerB(View view) {
        if (isGameEnd) { return;}
        if (blockOfPlayerB + 1  >= targetBlock) {
            blockOfPlayerB = targetBlock;
        }else {
            blockOfPlayerB = blockOfPlayerB + 1;
        }
        displayBlockOfB();
    }

    public void addTwoForPlayerB(View view) {
        if (isGameEnd) { return;}
        if (blockOfPlayerB + 2  >= targetBlock) {
            blockOfPlayerB = targetBlock;
        }else {
            blockOfPlayerB = blockOfPlayerB + 2;
        }
        displayBlockOfB();
    }

    public void addThreeForPlayerB(View view) {
        if (isGameEnd) { return;}
        if (blockOfPlayerB + 3  >= targetBlock) {
            blockOfPlayerB = targetBlock;
        }else {
            blockOfPlayerB = blockOfPlayerB + 3;
        }
        displayBlockOfB();
    }

    public void giveUpPlayerB(View view){
        if (isStartA && isStartB ) {
            TextView BoxA = (TextView) findViewById(messageBoxA);
            BoxA.setText("恭喜， Player B已经认输");
        }
        endGame();
    }

    public void startPlayerB(View view){
        if (isGameEnd == false) return;
        isStartB = true;
        if (isStartA == true) {
            isGameEnd = false;
            blockOfPlayerA = 0;
            blockOfPlayerB = 0;
            displayBlockOfA();
            displayBlockOfB();
            cleanMessageBox();
        }
    }

    private void cleanMessageBox() {
        TextView BoxB= (TextView) findViewById(messageBoxB);
        BoxB.setText("");
        TextView BoxA= (TextView) findViewById(messageBoxA);
        BoxA.setText("");
    }
}
