package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(1000,800);
        jFrame.setLocationRelativeTo(null);
        HomeScreen homeScreen = new HomeScreen(jFrame);
        jFrame.add(homeScreen);
        jFrame.setVisible(true);


        });
    }







}
