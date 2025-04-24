package org.example;

import javax.swing.*;
import java.awt.*;

public class Pearls extends GameObject {

    Pearls(int x,int y)
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(20);
        this.setHeight(20);
        this.setImage(new ImageIcon("").getImage());

    }
    @Override
    void update() {

    }

    @Override
    void draw(Graphics g) {

    }


//     כשאני מתודה אבסטרקטית במחלקה אבסטרקטית שלי אני אהיה חייבת לממש אותה כאן

}
