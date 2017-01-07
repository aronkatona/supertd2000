package logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;

public class Monster {
    
    private BufferedImage img = null;
    
    private double x, y;
    
    private double hp = 200;
    
    static AtomicInteger nextId = new AtomicInteger();
    
    private int id = 0;
    
    private int value = 2;
    
    
    public void moveMonster(){
        if(x <= 500){
            x+=1.0;
        }
        if(x > 500 && y <= 300){
            y+=1.0;    
        }
        if(x > 500 && y > 300){
            x+=1.0;
        }
    }

    public Monster(int x, int y) {
        id = nextId.incrementAndGet();
        this.x = x;
        this.y = y;
        try {
            img = ImageIO.read(new File("data/monster.png"));
        } catch (IOException exc) {
            //TODO: Handle exception.
        }
       

    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public BufferedImage getImg(){
        return img;
    }
    
}
