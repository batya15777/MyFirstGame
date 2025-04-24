package org.example;

import java.awt.*;

public class SeaCreature extends GameObject implements Runnable{
    @Override
    void update() {

    }

    @Override
    void draw(Graphics g) {

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


//זה מחלקה כללית על יצור ימי ושאני ארצה לעשות כריש מדוזה או כל אויב אחר במים אז הם ירשו מהמחלקה הזו
    //     כשאני מתודה אבסטרקטית במחלקה אבסטרקטית שלי אני אהיה חייבת לממש אותה כאן

}
