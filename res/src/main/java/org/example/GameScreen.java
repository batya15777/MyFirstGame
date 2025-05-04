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
    private List<SeaCreature> seaCreatures;
    private List<Lives> lives;
    private boolean running = true;
    private boolean paused = false;
    private Thread gameThread;
    private Image bgImage ;
    private final int MOVE_OF_STEP = 15;
    private final int NUMBER_OF_SHRAK = 3;
    private final int NUMBER_OF_JELLYFISH = 2;
    private final int NUMBER_OF_PEARLES = 10;
    private JFrame frame;
    private SoundPlayer backgroundMusic;


    GameScreen(JFrame frmae) {
        backgroundMusic = new  SoundPlayer("electronic-background-1min-seamless.wav");
        backgroundMusic.playLoop();
    this.frame = frmae;
    setFocusable(true);
    addKeyListener(this);
    mermaid = new Mermaid(100,100);
    bgImage = new ImageIcon(getClass().getResource("/bgImage.png")).getImage();
    pearlsList = new ArrayList<>();
    lives = new ArrayList<>();



    seaCreatures = new ArrayList<>();
    Random rand = new Random();
    for(int i =0; i<mermaid.getLives();i++)
    {
         lives.add(new Lives(10 + i*35,20));

    }
    for(int i =0; i<NUMBER_OF_SHRAK;i++)
    {
        Shark shrak = new Shark(rand.nextInt(900),rand.nextInt(700));
        seaCreatures.add(shrak);
        Thread th = new Thread(shrak);
        th.start();
    }
        for(int i =0; i<NUMBER_OF_JELLYFISH;i++)
        {
            Jellyfish jFish = new Jellyfish(rand.nextInt(900),rand.nextInt(700));
            seaCreatures.add(jFish);
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
        g.setColor(Color.white);
        g.setFont(new Font("Ariel",Font.BOLD,24));
        Image scoreIcon = new ImageIcon(getClass().getResource("/score.png")).getImage();
        g.drawImage(scoreIcon,868,8,30,30,this);
        g.drawString("x "+mermaid.getScore(),900,30);







        mermaid.draw(g);
        for(SeaCreature sea : seaCreatures) sea.draw(g) ;
        for(Lives live : lives) live.draw(g);
        for(Pearls pearl : pearlsList) pearl.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void stopAllCreature(boolean pause)
    {
        for(SeaCreature sea : seaCreatures)
        {
            sea.setRunning(!paused);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {


            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                mermaid.setDirection(0, +MOVE_OF_STEP);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                mermaid.setDirection(0, -MOVE_OF_STEP);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                mermaid.setDirection(-MOVE_OF_STEP, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                mermaid.setDirection(MOVE_OF_STEP, 0);
            }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            paused = !paused;
            stopAllCreature(paused);
            SoundPlayer pauseSound = new SoundPlayer("pause.wav");
            pauseSound.playOne();
            if (paused) {
                backgroundMusic.stop();

            }else {
                backgroundMusic.playLoop();

            }

        }
        if(e.getKeyCode() != KeyEvent.VK_SPACE && !paused) {
            mermaid.update();
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (running)
        {

                checkCollision();
                repaint();

        }
        try
        {
            Thread.sleep(30);
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
                SoundPlayer collectSound = new SoundPlayer("pearlSound.wav");
                collectSound.playOne();

                        mermaid.setScore(mermaid.getScore()+10);
                iter.remove();
            }

        }
        for(SeaCreature sea: seaCreatures){
            if(mermaid.getBounds().intersects(sea.getBounds())){
                SoundPlayer hitSound = new SoundPlayer("collisions.wav");
                hitSound.playOne();
                lives.remove(lives.size()-1);
                mermaid.setLives(mermaid.getLives()-1);
                mermaid.setX(50);
                mermaid.setY(50);
                if(mermaid.getLives()<=0)
                {
                    running=false;
                    stopAllCreature(true);
                    backgroundMusic.stop();
                    SoundPlayer gameOver = new SoundPlayer("gameOver.wav");
                    gameOver.playOne();
                    try {
                        GameOver gmOver =new GameOver(frame);
                        frame.setContentPane(gmOver);
                        frame.remove(this);
                        frame.revalidate();
                    } catch (InterruptedException e) {
                        System.out.println("failed");
                        throw new RuntimeException(e);
                    }

                }
            }
        }

    }

    ;


    }
