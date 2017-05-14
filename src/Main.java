import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        JFrame frame = new JFrame("Key Listener");
        Container contentPane = frame.getContentPane();
        JButton quit = new JButton("Quit");
        quit.addActionListener(new quit());
        JTextField text = new JTextField();
        JTextArea lyrics = new JTextArea("I wanna be the very best\n" +
                "Like no one ever was\n" +
                "To catch them is my real test\n" +
                "To train them is my cause5\n" +
                "\n" +
                "I will travel across the land\n" +
                "Searching far and wide\n" +
                "Each Pokemon to understand\n" +
                "The power that's inside4\n" +
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
                "Yeah");


        text.addKeyListener(test);
        contentPane.add(text, BorderLayout.SOUTH);
        contentPane.add(quit, BorderLayout.NORTH);
        contentPane.add(lyrics, BorderLayout.WEST);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class quit implements ActionListener {
        public void actionPerformed(ActionEvent e){

            try{
                System.out.println(test.getTimes());
                File output = new File("Output.csv");
                PrintWriter writer = new PrintWriter(output);
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

