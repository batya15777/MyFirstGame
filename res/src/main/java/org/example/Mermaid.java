package org.example;

import javax.swing.*;
import java.awt.*;

public class Mermaid extends GameObject{
    private int score = 0;
    private int lives = 3;
    private int dx, dy;



    Mermaid(int x, int y )
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(40);
        this.setHeight(40);
        this.setImage(new ImageIcon("").getImage());
    }

    void setDirection(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }
    @Override
    void update() {
      this.setX(this.getX() + dx);
      this.setY(this.getY() + dy);
    }

    @Override
    void draw(Graphics g ) {
        g.drawImage(this.getImage(),getX(),getY(),getWidth(),getHeight(),null);

    }






    /// //
    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
//     כשאני מתודה אבסטרקטית במחלקה אבסטרקטית שלי אני אהיה חייבת לממש אותה כאן
}
