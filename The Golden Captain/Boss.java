import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    private final int MAX_SHOOT_DELAY_BULLET = 150;
    private final int PROJECTILE_TYPE = 1;
    private final int MAX_HEALTH = 100;
    private final int ENEMY_TYPE = 2;
    
    private int health = MAX_HEALTH;

    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shoot(MAX_SHOOT_DELAY_BULLET, 1);    
        World world = getWorld(); 
        
        if(incomingDamage()){
            Actor bullet = getOneIntersectingObject(Bullet.class);
            health -= 5;
            world.removeObject(bullet);
            updateHUD();
        }
        
        if(health == 0){
            death(ENEMY_TYPE);
        }
    }
    
    public void updateHUD(){
        World world = getWorld();
        world.showText("Boss Health:" + health + "%", world.getWidth()-700, 20);
    }
}
