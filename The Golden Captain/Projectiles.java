import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectiles extends Actor
{
    private final int ENEMY_BULLET_VELOCITY = 3;
    private final int ENEMY_ROCKET_VELOCITY = 2;
    private final int FALL_SPEED = 3;
    
    private int projectile_velocity;
    /**
     * Act - do whatever the Projectiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    
    public void moveEnemyProjectiles(int projectile_velocity){
        setLocation(getX() - projectile_velocity, getY());
    }
    
    public void dissapear(){
        World world = getWorld();
        
        if (this.isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    public void fallProjectile(){
        setLocation(getX() , getY() + FALL_SPEED);
    }
}
