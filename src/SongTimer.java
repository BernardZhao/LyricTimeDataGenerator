import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by bernardzhao on 5/13/17.
 */
public class SongTimer implements KeyListener {

    ArrayList<long[]> times;
    int lastkey = -1;
    long start;
    String song = "pokemon.mp3";


    Media track;
    MediaPlayer mediaPlayer;

    public SongTimer(){
        times = new ArrayList<long[]>();

        JFXPanel fxPanel = new JFXPanel();

        track = new Media(new File(song).toURI().toString());
        mediaPlayer = new MediaPlayer(track);

    }

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
            mediaPlayer.play();
        }else {

            if (codigo == KeyEvent.VK_SPACE) {
                times.get(times.size() - 1)[1] = System.currentTimeMillis() - start;

            }
        }

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void printTimes() {
        for (long[] a : times) {
            System.out.println(a[0] + ", " + a[1]);
        }
    }

    public ArrayList<long[]> getTimes() {
        return times;
    }



}
