package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOver extends JPanel {
    private Image img;
    GameOver(JFrame frame) throws InterruptedException {
        img = new ImageIcon(getClass().getResource("/gameOver.png")).getImage();






        ImageIcon button = new ImageIcon(getClass().getResource("/button3.png"));
        Image scaledImage = button.getImage().getScaledInstance(350,200,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton replay = new JButton(scaledIcon);
        replay.setBorderPainted(false);
        replay.setContentAreaFilled(false);
        replay.setFocusPainted(false);
        replay.setOpaque(false);

        replay.setAlignmentX(0.3f);

        add(Box.createVerticalGlue());
        add(Box.createVerticalStrut(1300));
        add(replay);
        add(Box.createVerticalGlue());
        SoundPlayer clickSound = new SoundPlayer("buttonClick.wav");
        replay.addActionListener(e->{
            clickSound.playOne();
            HomeScreen homeScreen = new HomeScreen(frame);
            frame.setContentPane(homeScreen);
            remove(this);
            frame.revalidate();

        });




    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,getWidth(),getHeight(),this);

    }



}
