import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by bernardzhao on 5/13/17.
 */
public class SongTimer implements KeyEventDispatcher{

    ArrayList<long[]> times;
    int lastkey = -1;
    long start;



    String song = "pokemon";
    String songlyrics = "I wanna be the very best\n" +
            "Like no one ever was\n" +
            "To catch them is my real test\n" +
            "To train them is my cause5\n" +
            "\n" +
            "I will travel across the land\n" +
            "Searching far and wide\n" +
            "Each Pokemon to understand\n" +
            "The power that's inside\n" +
            "\n" +
            "Pokemon, gotta catch 'em all\n" +
            "Its you and me\n" +
            "I know it's my destiny\n" +
            "Pokemon, oh, you're my best friend\n" +
            "In a world we must defend\n" +
            "Pokemon, gotta catch 'em all\n" +
            "A heart so true\n" +
            "Our courage will pull us through2\n" +
            "\n" +
            "You teach me and I'll teach you\n" +
            "Pokemon, gotta catch 'em all\n" +
            "Gotta catch 'em all\n" +
            "Yeah\n" +
            "\n" +
            "Every challenge along the way\n" +
            "With courage I will face\n" +
            "I will battle every day\n" +
            "To claim my rightful place\n" +
            "\n" +
            "Come with me, the time is right\n" +
            "There's no better team\n" +
            "Arm in arm we'll win the fight\n" +
            "It's always been our dream\n" +
            "\n" +
            "Pokemon, gotta catch 'em all\n" +
            "Its you and me\n" +
            "I know it's my destiny\n" +
            "Pokemon, oh, you're my best friend\n" +
            "In a world we must defend\n" +
            "Pokemon, gotta catch 'em all\n" +
            "A heart so true\n" +
            "Our courage will pull us through\n" +
            "\n" +
            "You teach me and I'll teach you\n" +
            "Pokemon, gotta catch 'em all\n" +
            "Gotta catch 'em all\n" +
            "Gotta catch 'em all\n" +
            "Gotta catch 'em all\n" +
            "Yeah";

    Media track;
    MediaPlayer mediaPlayer;

    public boolean dispatchKeyEvent(KeyEvent ke) {
        switch (ke.getID()) {
            case KeyEvent.KEY_PRESSED:
                int codigo1 = ke.getKeyCode();

                if(start>0){

                    if (codigo1 != lastkey) {
                        lastkey = codigo1;
                        if (codigo1 == KeyEvent.VK_SPACE) {
                            long[] temp = new long[2];
                            temp[0] = System.currentTimeMillis() - start;
                            times.add(temp);
                            System.out.println("Space pressed, times added to [1]: " + temp[0]);
                        }

                    }
                    if (codigo1 == KeyEvent.VK_X) {
                        printTimes();

                    }

                }
                break;

            case KeyEvent.KEY_RELEASED:
                int codigo2 = ke.getKeyCode();

                if(start == 0){
                    start = System.currentTimeMillis();
                    System.out.println("Starttime set: " + start);
                    mediaPlayer.play();
                }else {

                    if (codigo2 == KeyEvent.VK_SPACE) {
                        long temp = System.currentTimeMillis() - start;
                        times.get(times.size() - 1)[1] = temp;
                        System.out.println("Key released, times added to [2]: " + temp);
                    }
                }

                lastkey = -1;

        }
        return false;
    }


    public SongTimer(){

        //This must be here to work for some reason, will find out later.

        JFXPanel fxPanel = new JFXPanel();



        times = new ArrayList<long[]>();

        //I add the file extension at this point, bet aware that it might be different, something other than an mp3.
        track = new Media(new File(song).toURI().toString()+".mp3");
        mediaPlayer = new MediaPlayer(track);




    }
/*
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        int codigo = arg0.getKeyCode();

        if(start>0){

            if (codigo != lastkey) {
                lastkey = codigo;
                if (codigo == KeyEvent.VK_SPACE) {
                    long[] temp = new long[2];
                    temp[0] = System.currentTimeMillis() - start;
                    times.add(temp);
                    System.out.println("Space pressed, times added to [1]: " + temp[0]);
                }

            }
            if (codigo == KeyEvent.VK_X) {
                printTimes();

            }

        }

    }

    public void keyReleased(KeyEvent arg0) {
        int codigo = arg0.getKeyCode();

        if(start == 0){
            start = System.currentTimeMillis();
            System.out.println("Starttime set: " + start);
            mediaPlayer.play();
        }else {

            if (codigo == KeyEvent.VK_SPACE) {
                long temp = System.currentTimeMillis() - start;
                times.get(times.size() - 1)[1] = temp;
                System.out.println("Key released, times added to [2]: " + temp);
            }
        }

        lastkey = -1;

    }

    public void keyTyped(KeyEvent arg0) {

    }
    */

    public void printTimes() {
        System.out.println("Currently stored times:");
        for (long[] a : times) {
            System.out.println(a[0] + ", " + a[1]);
        }
        System.out.println("Stored times end.");
    }

    public ArrayList<long[]> getTimes() {
        return times;
    }

    public String getSong() {
        return song;
    }

    public String getSongLyrics() {
        return songlyrics;
    }

}
