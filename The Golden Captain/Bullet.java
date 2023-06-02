import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Projectiles
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private final int VELOCITY = 5;
    private final int MAX_SHOOT_DELAY = 1;
    private final GreenfootImage right = new GreenfootImage("Bulletright.png");
    private final GreenfootImage left = new GreenfootImage("Bulletleft.png");  
    
    private int shootDelay;
    private int direction;
    
    
    public void act()
    {
        move(direction);
        
        dissapear();
    }
    
    public Bullet(int direction){
        this.direction = direction;
        
        if(direction == 0){
           setImage(left); 
        }else{
           setImage(right); 
        }
    }
    
    public void move(int direction){
        if(direction == 0){
          setLocation(getX() - VELOCITY, getY());  
        }else{
          setLocation(getX() + VELOCITY, getY());  
        }
    }
    
    

}
