package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class InstructionScreen extends JPanel {
    private BufferedImage backgroundImage;
    private Image img;
    InstructionScreen(JFrame frame)
    {


//        try {
//            backgroundImage = ImageIO.read(new File("res/images.png")); // שימי את שם קובץ התמונה
//        } catch (Exception e) {
//            System.out.println("image error " + e.getMessage());
//        }


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        img = new ImageIcon(getClass().getResource("/second.PNG")).getImage();


        JTextArea instructions = new JTextArea(
                "Welcome to the Little Mermaid game!\n" +
                        "Your goal is to collect all the pearls.\n" +
                        "Be careful of the obstacles along the way!"
        );
        instructions.setEditable(false);
        instructions.setOpaque(false); // שקוף
        instructions.setFont(new Font("Arial", Font.BOLD, 30));
        instructions.setForeground(Color.white);
        instructions.setAlignmentX(Component.LEFT_ALIGNMENT);
//        instructions.setCo(Component.CENTER_ALIGNMENT);
        instructions.setHighlighter(null); // בלי סימון
        instructions.setFocusable(false);
        instructions.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        instructions.setMargin(new Insets(50,0,30,400));
        instructions.setMaximumSize(new Dimension(600, 180)); // גודל סביר
        add(instructions);
        add(Box.createVerticalStrut(40));
        add(Box.createVerticalStrut(30));

        ImageIcon startIcon = new ImageIcon(getClass().getResource("/button2.png"));
        Image scaledStartImg = startIcon.getImage().getScaledInstance(350,200,Image.SCALE_SMOOTH);
        ImageIcon resizedStartIcon = new ImageIcon(scaledStartImg);
        JButton startButton = new JButton(resizedStartIcon);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setOpaque(false);

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Arial", Font.BOLD, 22));
        startButton.addActionListener(e->{
             GameScreen game = new GameScreen(frame);
            frame.setContentPane(game);
            frame.revalidate();
            game.requestFocusInWindow();
            game.startGame();
                }
        );
        add(Box.createVerticalStrut(100));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(startButton);
        add(Box.createVerticalStrut(40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        if (backgroundImage != null) {
//        }
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

    }
 }
