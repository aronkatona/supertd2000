package towerdefense;

import gui.TDGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import logic.Monster;

public class TowerDefense {

   
    public static void main(String[] args) throws InterruptedException {
      final TDGui Gui = new TDGui();
      Gui.setVisible(true);      
     
      
      ActionListener refresh = new ActionListener() {
    		@Override
  			public void actionPerformed(ActionEvent event) {
    			   			
    		          
    		         if(Gui.gamePanel.logic.isActive()){
    		              for(Monster i: Gui.gamePanel.logic.monsters){
    		              i.moveMonster();
    		              }
    		              Gui.gamePanel.logic.setLife();
    		              Gui.gamePanel.logic.attackMonster();
    		          }
    		          
    		      
          
    		          Gui.repaint();
    		

  			}

       };
      
      Timer timer = new Timer(10, refresh);
      
      timer.start();

      
    
    }
}
