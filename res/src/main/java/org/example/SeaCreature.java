package org.example;

import java.awt.*;

public class SeaCreature extends GameObject implements Runnable{
    boolean isRunning = true;
    int directionX = 1;
    int directionY = -1;
    private boolean facingLeft = true;
    @Override
    void update() {
     if(isRunning)
     {

             this.setX(getX() + (directionX * 3));
         facingLeft = directionX < 0;


         if (getX() <= 0 || getX() + directionX * 5 >= 900) {
                 directionX *= -1;
             }
             this.setY((getY() + directionY * 3));
             if (getY() < 0 || (getY() + directionY * 5 > 720)) {
                 directionY *= -1;
             }

     }
    }

    @Override
    void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Image image = getImage();
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        if (!facingLeft){
            g.drawImage(image,x + width,y,-width,height,null);

        }else {
            g.drawImage(image,x,y,width,height,null);

        }
    }

    @Override
    public void run() {
        while(true)
        {
            update();
            try {
                Thread.sleep(30);
            }
            catch (InterruptedException e)
            {

            }
        }
    }

    public void setRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }



}
