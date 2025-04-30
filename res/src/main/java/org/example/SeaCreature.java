package org.example;

import java.awt.*;

public class SeaCreature extends GameObject implements Runnable{
    boolean isRunning = true;
    int directionX = 1;
    int directionY = -1;
    @Override
    void update() {
     if(isRunning)
     {
         if()
         this.setX(getX() + (directionX * 3));

         if(getX() < 0 || getX() + directionX*5  >= 900) {
             directionX *=-1;
             System.out.println("else1");
         }
       /// border
         this.setY((getY() + directionY * 3));
        if(getY() <0 || (getY() + directionY * 5 > 720) ) {
            directionY *=-1;
        }
         /// border
     }
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
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


//זה מחלקה כללית על יצור ימי ושאני ארצה לעשות כריש מדוזה או כל אויב אחר במים אז הם ירשו מהמחלקה הזו
    //     כשאני מתודה אבסטרקטית במחלקה אבסטרקטית שלי אני אהיה חייבת לממש אותה כאן

}
