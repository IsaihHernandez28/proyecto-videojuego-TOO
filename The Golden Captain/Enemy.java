import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int shootDelay;
    private int maxShootDelay;
    private int projectileType;
    private int health;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    
    public void shoot(int maxShootDelay, int projectileType){
        shootDelay++;
        if(shootDelay < maxShootDelay){
            return;
        }
        shootDelay = 0;
        
        if(projectileType == 1){
            EnemyBullet enemybullet = new EnemyBullet();
            getWorld().addObject(enemybullet,getX() - 20,getY() - 10);
        }else{
            EnemyRocket enemyrocket = new EnemyRocket();
            getWorld().addObject(enemyrocket,getX() - 20,getY() - 10);
        }
        
    }
    
    
    public boolean incomingDamage(){
        Actor bullet = getOneIntersectingObject(Bullet.class);
       
        
        if(bullet!= null){
                return true; 
            } 
        
        return false;
    }
    
    public void death(int enemyType){
        World world = getWorld();
        List<Soldier> soldierList = world.getObjects(Soldier.class);
        Soldier soldier = soldierList.get(0);
        world.removeObject(this);
        soldier.increaseScore(enemyType);
    }
}
