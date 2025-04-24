package org.example;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel{

    private Image img;
    public HomeScreen(JFrame frame)
    {
        BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        img = new ImageIcon(("src/images.png")).getImage();

//        אולי לא צריך את הכותרת ונעשה שגם ההוראות יהיו בכתפור
//        JLabel jLabel = new JLabel("הוראות");
        JButton jButton = new JButton("INSTRUCTION");

//        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
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
