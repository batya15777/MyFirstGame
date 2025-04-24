package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class InstructionScreen extends JPanel {
    private BufferedImage backgroundImage;
    InstructionScreen(JFrame frame)
    {
        try {
            backgroundImage = ImageIO.read(new File("res/images.png")); // שימי את שם קובץ התמונה
        } catch (Exception e) {
            System.out.println("image error " + e.getMessage());
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        // רווח מלמעלה
        add(Box.createVerticalStrut(50));

        // TextArea להוראות
        JTextArea instructions = new JTextArea(
                "ברוכה הבאה למשחק בת הים!\n" +
                        "המטרה שלך היא לאסוף את כל הפנינים.\n" +
                        "היזהרי מהמכשולים שבדרך!"
        );
        instructions.setEditable(false);
        instructions.setOpaque(false); // שקוף
        instructions.setFont(new Font("Arial", Font.BOLD, 30));
        instructions.setForeground(Color.red);
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructions.setHighlighter(null); // בלי סימון
        instructions.setFocusable(false);

        instructions.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        instructions.setMaximumSize(new Dimension(500, 100)); // גודל סביר
        add(instructions);
        add(Box.createVerticalStrut(40));


        JButton startButton = new JButton("התחל");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Arial", Font.BOLD, 22));
        startButton.addActionListener(e->{
             GameScreen game = new GameScreen(frame);
            frame.setContentPane(game);
            frame.revalidate();
                }
        );
        add(startButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
 }
