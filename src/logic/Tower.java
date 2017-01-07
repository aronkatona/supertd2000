package logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tower {
    
     private BufferedImage img = null;
     
     private int range = 200;
     
     private double dmg = 1.0;
     
     private boolean attack = false;
     
     private int whichMonster ;
     
     private static int value = 5;
     
    
     private int x, y;

    public Tower(int x, int y) {
       this.x = x;
        this.y = y;
        try {
            img = ImageIO.read(new File("data/tower.png"));
        } catch (IOException exc) {
            //TODO: Handle exception.
        }
    }

    public int getValue() {
        return value;
    }

    public int getWhichMonster() {
        return whichMonster;
    }

    public void setWhichMonster(int whichMonster) {
        this.whichMonster = whichMonster;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public int getRange() {
        return range;
    }

    public double getDmg() {
        return dmg;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
     
    
    
}
