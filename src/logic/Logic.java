package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logic {
    
    public List<Monster> monsters;
    public List<Tower> towers;
    
    private int numberOfKilledMonsters = 0;
    
    private int life = 30;
    
    private int money = 10;
    
    private boolean clicked = false;
    
    private boolean Active = false;
    
    private int priceOfFirstTower = 5;
    
    public Logic(){
        monsters = new ArrayList<>();
        towers = new ArrayList<>();
        newGame();
    }
    
    public void newGame(){
        for(int i = 1; i < 30; ++i){
            monsters.add(new Monster(i * -80, 100));
        }    
    }
    
    public void newGame(int x, int y){
        if(x >= 900 && x <= 975 && y >= 570 && y <= 645){
            monsters.clear();
            towers.clear();
            Active = false;
            money = 10;
            life = 30;
            clicked = false;
            numberOfKilledMonsters = 0;
            newGame();
        }
    }
    
    public void attackMonster(){
        
        Iterator it;
        
        for(Tower t: towers){
            it = monsters.iterator();
            while(it.hasNext()){
                 Object asd = it.next();
                 Monster m = (Monster) asd;
                 if( Math.sqrt( Math.pow( Math.abs( t.getX() - m.getX() ),2 ) + Math.pow( Math.abs( t.getY() - m.getY() ),2 ) ) <= t.getRange()  ){      

                     if(!t.isAttack()){
                          t.setWhichMonster(m.getId());
                          t.setAttack(true);
                     }
                     
                     if(t.isAttack() && m.getId() == t.getWhichMonster()){
                         m.setHp(m.getHp() - t.getDmg());
                     }
                                  
                     if(m.getHp() <= 0) {
                         for(Tower to : towers){
                             if(to.getWhichMonster() == t.getWhichMonster()) to.setAttack(false);  
                         }
                         money += m.getValue();
                         numberOfKilledMonsters++;
                         t.setAttack(false);
                         it.remove();
                     }
                }
                  if( Math.sqrt( Math.pow( Math.abs( t.getX() - m.getX() ),2 ) + Math.pow( Math.abs( t.getY() - m.getY() ),2 ) ) > t.getRange()  ){
                      t.setAttack(false);
                  }
   
            }
        }
    }
    
    public void buyTower(int x, int y){
        if(clicked){
            if(money >= priceOfFirstTower){
                 money -= priceOfFirstTower;
                 towers.add(new Tower(x-25,y-25));
                 clicked = false;
            }
           
        }
        if(!clicked){
            if(x >= 200 && x <= 274 && y >= 550 && y <= 624)  
            clicked = true;
        }
        
         
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(int x, int y) {
       
        if(x >= 740 && x <= 815 && y >= 570 && y <= 645){
            Active = true;
        }
        if(x >= 820 && x <= 895 && y >= 570 && y <= 645){
            Active = false;
        }
    }

    public int getMoney() {
        return money;
    }
    
    
    public int getNumberOfMonster(){
        return monsters.size();
    }
    
    public int getNumberOfKilledMonsters(){
        return numberOfKilledMonsters;
    }

    public int getLife() {
        return life;
    }
    
    public void setLife(){
        for(Monster m : monsters){
            if(m.getX() == 1000 && m.getY() == 301) --life;
        }
    }
}
