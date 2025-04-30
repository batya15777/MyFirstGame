package org.example;

import javax.swing.*;

public class Shark extends SeaCreature{
    Shark(int x, int y)
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(120);
        this.setHeight(60);
        this.setImage(new ImageIcon(getClass().getResource("/shark.png")).getImage());

    }


}
