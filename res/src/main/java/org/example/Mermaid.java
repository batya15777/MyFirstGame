package org.example;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
//import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Mermaid extends GameObject{
    private int score = 0;
    private int lives = Integer.MAX_VALUE;
    private int dx, dy;



    Mermaid(int x, int y )
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(100);
        this.setHeight(100);
        this.setImage(new ImageIcon(getClass().getResource("/mermaid.png")).getImage());
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
//      setDirection(0,0);
    }

    @Override
    void draw(Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        Image image = this.getImage();
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        if (dx < 0){
            g2d.drawImage(image,x + width ,y , -width ,height,null);
        }else {
            g2d.drawImage(image , x ,y , width ,height,null);


        }





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

}
