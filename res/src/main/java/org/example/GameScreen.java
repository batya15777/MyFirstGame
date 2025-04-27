package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class GameScreen extends JPanel implements Runnable, KeyListener {
    private Mermaid mermaid;
    private List<Pearls> pearls;
//    private List<> shark;
//    private List<> jellyfish;
    private boolean running = true;
    private boolean paused = false;
    private Thread gameThread;
    private Image bgImage ;


    GameScreen(JFrame frmae) {


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
              mermaid.setY(5);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            mermaid.setY(-5);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            mermaid.setX(-5);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mermaid.setX(5);
        }

//לבדוק אולי במקום לעשות ערכים במספרים לישות מתודה מגדילה לי את הס או מקטינה וכנל ל y
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (running)
        {
            mermaid.update();
//            checkCollision();

        }
    };


    }
