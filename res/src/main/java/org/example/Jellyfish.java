package org.example;

import javax.swing.*;
import java.util.Objects;

public class Jellyfish extends SeaCreature
{
    Jellyfish(int x , int y){
        this.setX(x);
        this.setY(y);
        this.setWidth(120);
        this.setHeight(60);
        this.setImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jellyfish.jpeg"))).getImage());



    }
}
