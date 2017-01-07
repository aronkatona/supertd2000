package gui;

import java.awt.Color;
import java.awt.Font;
import logic.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
    public Logic logic;
       
    private BufferedImage mapImg = null;
    
    private BufferedImage towerImg = null;
    
    private int priceOfFirstTower = 5;
  
    
    public GamePanel(){
        logic = new Logic();
        
         try {
            mapImg = ImageIO.read(new File("data/map.png"));
        } catch (IOException exc) {
            //TODO: Handle exception.
        }
         
         try {
            towerImg = ImageIO.read(new File("data/tower.png"));
        } catch (IOException exc) {
            //TODO: Handle exception.
        }
          
    }
    
    @Override
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial",Font.CENTER_BASELINE, 20));
    
        g2d.drawImage(mapImg, 0, 0, this);
        
        //shop
        g2d.fillRect(200,550 , 74, 74);
        g2d.drawImage(towerImg, 212 , 562 , this);
        g2d.drawString("Laser tower", 185,650);
        g2d.setColor(Color.yellow);
        g2d.drawString(String.valueOf(priceOfFirstTower),233, 540);
        
        //play,stop
        g2d.setColor(Color.green);
        g2d.fillRect(740,570,75,75);
        g2d.setColor(Color.red);
        g2d.fillRect(820,570,75,75);
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(900,570,75,75);
        g2d.setColor(Color.black);   
        g2d.drawString("START",745,615);
        g2d.drawString("STOP",830,615);
        g2d.drawString("REPEAT",899,615);
        
        
        for(Tower i : logic.towers){
            g2d.drawImage(i.getImg(),i.getX(), i.getY(), this);
           
        //    g2d.drawOval(i.getX()-175, i.getY()-175,400,400);
        }
        
        for(Monster i : logic.monsters){
            g2d.drawImage(i.getImg(), (int)i.getX(), (int)i.getY(), this);
     
            //lovedek
            g2d.setColor(Color.blue);
            for(Tower t : logic.towers){
                if( 
               Math.sqrt( Math.pow( Math.abs( t.getX() - i.getX() ),2 ) 
                        + Math.pow( Math.abs( t.getY() - i.getY() ),2 ) ) <= t.getRange()
                    && t.getWhichMonster() == i.getId())
            g2d.drawLine((int)i.getX() + 25, (int)i.getY() + 25, t.getX() + 42 , t.getY() + 16);
            }
            
            
           
            // hp
            g2d.setColor(Color.green);
            g2d.fillRect((int)i.getX(), (int)i.getY() , (int)i.getHp()/4, 5);    
            g2d.setColor(Color.red);
            g2d.fillRect( (int)i.getX() + (int)i.getHp()/4, (int)i.getY() , (int)(50 - i.getHp()/4) ,5);
          //  g2d.drawString(String.valueOf((int)i.getHp()),(int)i.getX()+15, (int)i.getY());
        } 
        
            //stats
            g2d.setColor(Color.red);            
            g2d.drawString("Lives: " + String.valueOf(logic.getLife()) , 30, 550);
            g2d.drawString("Gold: " + String.valueOf(logic.getMoney()), 30, 600);
            g2d.drawString("Killed: " + String.valueOf(logic.getNumberOfKilledMonsters()) , 30, 650);      
            
          
    }
    
    public void repaint(Graphics g){
        paint(g);
    }
    
}
