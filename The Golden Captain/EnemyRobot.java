import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class CommonEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyRobot extends Enemy
{
    private final int MAX_SHOOT_DELAY = 300;
    private final int MAX_HEALTH = 30;
    private final int ENEMY_TYPE = 0;
    
    private int health = MAX_HEALTH;
    
    /**
     * Act - do whatever the CommonEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        World world = getWorld(); 
        
        shoot(MAX_SHOOT_DELAY, ENEMY_TYPE);
        
        if(incomingDamage()){
            Actor bullet = getOneIntersectingObject(Bullet.class);
            health -= 10;
            world.removeObject(bullet);
        }
        
        if(health == 0){
            death(ENEMY_TYPE);
        }
    }
}
