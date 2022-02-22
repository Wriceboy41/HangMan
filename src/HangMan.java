
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import svu.csc213.Dialog;
import java.awt.*;
import java.util.Locale;

public class HangMan extends GraphicsProgram {

    private int numberLetters;
    private String Word = "hello";

    @Override
    public void init(){
        String Word = "hello";
        numberLetters = Word.length();


        for (int i = 0; i <= numberLetters; i++) {
            GRect letter = new GRect(25, 1);
            add(letter, 50 * i + letter.getWidth()+50, getHeight()/2);
            int letterNumber = i;
        }
        gameHappen();
    }

    private void gameHappen(){
        while (true){
            String guess = Dialog.getString("what is your guess").toUpperCase();



            if(guess.length() > 1 || String.valueOf() > 90 || String.copyValueOf() < 65){
                Dialog.showMessage("invalid guess");
            }

        }

    }









    public static void main(String[] args) {
        new HangMan().start();
    }
}
