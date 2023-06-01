import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        prepare();
    }
    
    void prepare(){
        EnemySoldier enemysoldier = new EnemySoldier();
        addObject(enemysoldier, 470, 350);
        EnemySoldier enemysoldier1 = new EnemySoldier();
        addObject(enemysoldier1, 470, 440);
        EnemySoldier enemysoldier2 = new EnemySoldier();
        addObject(enemysoldier2, 375, 350);
        EnemyRobot enemyrobot = new EnemyRobot();
        addObject(enemyrobot, 675, 325);
        EnemyRobot enemyrobot1 = new EnemyRobot();
        addObject(enemyrobot1, 675, 435);
    }
}
