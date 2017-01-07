package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class TDGui extends JFrame implements MouseListener,MouseMotionListener {
    
    public GamePanel gamePanel;        
    
    public TDGui(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Super TD 2000");
        
        setSize(1000,700);
        
        setResizable(true);
                
        
        gamePanel = new GamePanel();
        
        gamePanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                gamePanel.logic.buyTower(x, y);
                gamePanel.logic.setActive(x,y);
                gamePanel.logic.newGame(x,y);
            }
        });
        
        add(gamePanel);
        
        setLocationRelativeTo(null); 


        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
  
    
    
    
    
}
