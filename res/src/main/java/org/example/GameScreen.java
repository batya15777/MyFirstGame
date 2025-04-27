package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameScreen extends JPanel implements Runnable, KeyListener {
    private Mermaid mermaid;
    private List<Pearls> pearlsList;
    private List<Shark> sharkList;
    private List<Jellyfish> jellyfishList;
    private boolean running = true;
    private boolean paused = false;
    private Thread gameThread;
    private Image bgImage ;
    private final int moveOfStep = 15;
    private final int NUMBER_OF_SHRAK = 3;
    private final int NUMBER_OF_JELLYFISH = 1;
    private final int NUMBER_OF_PEARLES = 10;



    GameScreen(JFrame frmae) {
    setFocusable(true);
    addKeyListener(this);
    mermaid = new Mermaid(100,100);
    bgImage = new ImageIcon(getClass().getResource("/bgImage.png")).getImage();
    pearlsList = new ArrayList<>();
    jellyfishList = new ArrayList<>();
    sharkList = new ArrayList<>();
    Random rand = new Random();
    for(int i =0; i<NUMBER_OF_SHRAK;i++)
    {
        Shark shrak = new Shark(rand.nextInt(900)+50,rand.nextInt(700)+50);
        sharkList.add(shrak);
        Thread th = new Thread(shrak);
        th.start();
    }
        for(int i =0; i<NUMBER_OF_JELLYFISH;i++)
        {
            Jellyfish jFish = new Jellyfish(rand.nextInt(900)+50,rand.nextInt(700)+50);
            jellyfishList.add(jFish);
            Thread th = new Thread(jFish);
            th.start();
        }
        for (int i = 0; i <NUMBER_OF_PEARLES ; i++)
        {
            Pearls pearls = new Pearls(rand.nextInt(900)+50,rand.nextInt(700)+50);
            pearlsList.add(pearls);
        }




    }
    public void startGame()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage,0,0,getWidth(),getHeight(),this);
        mermaid.draw(g);
        for(Shark shark : sharkList) shark.draw(g);
        for(Jellyfish jellyfish : jellyfishList) jellyfish.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPreessed");
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
              mermaid.setDirection(0,+moveOfStep);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            mermaid.setDirection(0,-moveOfStep);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            mermaid.setDirection(-moveOfStep,0);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mermaid.setDirection(moveOfStep,0);
        }
        mermaid.update();

//לבדוק אולי במקום לעשות ערכים במספרים לישות מתודה מגדילה לי את הס או מקטינה וכנל ל y
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (running)
        {
//            mermaid.update();
            checkCollision();
            repaint();
        }
        try
        {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkCollision() {
        Random rand = new Random();
        if(pearlsList.size()<10)
        {
            pearlsList.add( new Pearls(rand.nextInt(900)+50,rand.nextInt(700)+50));
        }
        Iterator<Pearls> iter = pearlsList.iterator();
        while(iter.hasNext())
        {
            Pearls pearl = iter.next();
            if(mermaid.getBounds().intersects(pearl.getBounds()))
            {
                mermaid.setScore(mermaid.getScore()+10);
                iter.remove();
            }

        }
        for(Shark shark: sharkList){
            if(mermaid.getBounds().intersects(shark.getBounds())){
                mermaid.setLives(mermaid.getLives()-1);
                mermaid.setX(50);
                mermaid.setY(50);
                if(mermaid.getLives()<=0)
                {
                    running=false;
                }
            }
        }
        for(Jellyfish jellyfish: jellyfishList){
            if(mermaid.getBounds().intersects(jellyfish.getBounds())){
                mermaid.setLives(mermaid.getLives()-1);
                mermaid.setX(50);
                mermaid.setY(50);
                if(mermaid.getLives()<=0)
                {
                    running=false;
                }
            }
        }
    }

    ;


    }
