import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        prepare();
    }
    
    private void prepare(){
        Soldier soldier = new Soldier();
        addObject(soldier, 75, 434);
        EnemySoldier enemysoldier = new EnemySoldier();
        addObject(enemysoldier, 470, 400);
        EnemySoldier enemysoldier1 = new EnemySoldier();
        addObject(enemysoldier1, 470, 475);
        EnemyRobot enemyrobot = new EnemyRobot();
        addObject(enemyrobot, 650, 400);
    }
}
