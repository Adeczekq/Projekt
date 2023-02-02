package main;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("lista");
        frame.setContentPane(new lista().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
