import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bernardzhao on 5/13/17.
 */
public class Main {

    static SongTimer test;

    public static void main(String[] args) {

        test = new SongTimer();
        JFrame frame = new JFrame("Lyric Time Generator");
        Container contentPane = frame.getContentPane();
        JButton quit = new JButton("Quit");
        quit.addActionListener(new quit());

        JTextArea lyrics = new JTextArea(test.getSongLyrics());


        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(test);
        contentPane.add(quit, BorderLayout.NORTH);
        contentPane.add(lyrics, BorderLayout.CENTER);
        lyrics.setEditable(false);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                new quit().quitprocess();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class quit implements ActionListener {
        public void actionPerformed(ActionEvent e){
            quitprocess();
        }

        public void quitprocess() {
            try{
                System.out.println(test.getTimes());
                String name = test.getSong()+"lyricdata";

                File output = new File(name + ".csv");
                PrintWriter writer = new PrintWriter(output);
                writer.println(name);
                for (long[] a : test.getTimes()) {
                    writer.println(a[0] + "," + a[1]);
                }
                writer.close();
            }
            catch (IOException a){
                a.printStackTrace();
            }

            System.exit(0);
        }

    }


}


