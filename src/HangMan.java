
import acm.graphics.*;
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
            add(GGuess,10, 12 * wrongGuesses +15 );
        }
    }
    private void drawHangman(){
        GRect head = new GRect(20,20);
        GLine body = new GLine(getWidth()*.75 + head.getWidth()/2, getHeight()*.10+head.getHeight(), getWidth()*.75 + head.getWidth()/2, getHeight()*.10+head.getHeight()+100);
        GLine rArm = new GLine(body.getX(), body.getY()+body.getHeight()/2, body.getX()+50, body.getY()+body.getHeight()*.75);
        GLine lArm = new GLine(body.getX(), body.getY()+body.getHeight()/2, body.getX()-50, body.getY()+body.getHeight()*.75);
        GLine rLeg = new GLine(body.getX(), body.getY()+body.getHeight(), body.getX()+50, body.getY()+body.getHeight()*1.75);
        GLine lLeg = new GLine(body.getX(), body.getY()+body.getHeight(), body.getX()-50, body.getY()+body.getHeight()*1.75);
        GLine rEyeLeftRight = new GLine(getWidth()*.75 +head.getWidth() *.75,getHeight()*.10 + head.getHeight()*.25, getWidth()*.75 + head.getWidth()*.75+3,getHeight()*.10+ head.getHeight()*.25+3 );
        GLine rEyeRightLeft = new GLine(getWidth()*.75+head.getWidth()*.75+3,getHeight()*.10+head.getHeight()*.25, getWidth()*.75+head.getWidth()*.75,getHeight()*.10+head.getHeight()*.25+3 );
        GLine lEyeLeftRight = new GLine(getWidth()*.75 +head.getWidth() *.25,getHeight()*.10 + head.getHeight()*.25, getWidth()*.75 + head.getWidth()*.25+3,getHeight()*.10+ head.getHeight()*.25+3 );
        GLine lEyeRightLeft = new GLine(getWidth()*.75+head.getWidth()*.25+3,getHeight()*.10+head.getHeight()*.25, getWidth()*.75+head.getWidth()*.25,getHeight()*.10+head.getHeight()*.25+3 );
        switch (wrongGuesses){
            case 0:
                break;
            case 1:
                add(head, getWidth()*.75, getHeight()*.10);
                break;
            case 2:
                add(body);
                break;
            case 3:
                add(rArm);
                break;
            case 4:
                add(lArm);
                break;
            case 5:
                add(rLeg);
                break;
            case 6:
                add(lLeg);
                break;
            case 7:
                add(rEyeLeftRight);
                add(rEyeRightLeft);
                add(lEyeLeftRight);
                add(lEyeRightLeft);
                Dialog.showMessage("You Lost");
                System.exit(1);
                break;
        }
    }



    public static void main(String[] args) {
        new HangMan().start();
    }
}
