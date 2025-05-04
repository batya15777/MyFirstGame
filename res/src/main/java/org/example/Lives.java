package org.example;

import javax.swing.*;
import java.awt.*;

public class Lives extends GameObject {

    Lives(int x,int y)
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(40);
        this.setHeight(40);
        this.setImage(new ImageIcon(getClass().getResource("/live.png")).getImage());

    }
    @Override
    void update() {

    }

    @Override
    void draw(Graphics g) {
        g.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
    }




}
