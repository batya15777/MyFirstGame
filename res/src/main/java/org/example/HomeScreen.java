package org.example;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel{

    private Image img;
    public HomeScreen(JFrame frame)
    {
        BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxLayout);

        img = new ImageIcon(getClass().getResource("/first.PNG")).getImage();


        ImageIcon button = new ImageIcon(getClass().getResource("/button1.png"));
        Image scaledImage = button.getImage().getScaledInstance(350,200,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton jButton = new JButton(scaledIcon);
        jButton.setBorderPainted(false);
        jButton.setContentAreaFilled(false);
        jButton.setFocusPainted(false);
        jButton.setOpaque(false);

//        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton.setAlignmentX(0.3f);

        add(Box.createVerticalGlue());
        add(Box.createVerticalStrut(200));
//        add(jLabel);
        add(jButton);
        add(Box.createVerticalGlue());

        jButton.addActionListener(e->{
        InstructionScreen instructionPanel = new InstructionScreen(frame);
        frame.setContentPane(instructionPanel);
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
