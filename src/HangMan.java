
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import svu.csc213.Dialog;

import javax.swing.*;
import java.awt.*;


public class HangMan extends GraphicsProgram {

    private int numberLetters;
    private String Word = "HELLO";
    private int wrongGuesses = 0;
    private boolean wrong;

    @Override
    public void init(){

        numberLetters = Word.length();


        for (int i = 0; i < numberLetters; i++) {
            GRect letter = new GRect(25, 1);
            add(letter, 50 * i + letter.getWidth()+50, getHeight()/2);
            int letterNumber = i;
        }
        add(new GLabel("Wrong Guesses"), 0, 10);
        gameHappen();
    }

    private void gameHappen(){
        while (true){
            String guess = Dialog.getString("what is your guess").toUpperCase();


            if(guess.length() > 1 || guess.charAt(0) < 64 || guess.charAt(0) > 90){
                Dialog.showMessage("invalid guess");
             } else {
                GLabel GGuess = new GLabel(guess);
                checkRight( guess);
                checkWrong(GGuess);
                drawHangman();
            }
        }
    }

    private void checkRight( String guess){
        int right = 0;
        wrong = false;
        for (int i = 0; i < Word.length(); i++) {
            if (guess.charAt(0) == Word.charAt(i)) {
                GLabel GGuess = new GLabel(guess);
                add(GGuess, i * 50 + 85, getHeight() / 2 - 3);
                right++;
            }

        }
        if(right == 0){
            wrongGuesses++;
            wrong = true;
        }
    }

    private void checkWrong(GLabel GGuess){
        if (wrong){
            add(GGuess,10, 10 * wrongGuesses +10 );

        }
    }
    private void drawHangman(){
        GOval head = new GOval(20,20);
        GLine body = new GLine(head.getX(), head.getY(), head.getX(), head.getY()+100);
        switch (wrongGuesses){
            case 0:
                break;
            case 1:
                add(head, getWidth()*.75, getHeight()*.10);
                break;
            case 2:
                add(body);
                break;
        }
    }



    public static void main(String[] args) {
        new HangMan().start();
    }
}
