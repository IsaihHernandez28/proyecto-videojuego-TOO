import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private final int BOMBDELAY = 50;
    
    private int bombDelay = BOMBDELAY;
    
    
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        prepare();
    }
    
    public void prepare(){
        Boss boss = new Boss();
        addObject(boss, 650, 325);
    }
    
    public void createBomb(){
        if(bombDelay > 0){
            bombDelay--;
            return;
        }
        
        Random random = new Random();
        
        int x = random.nextInt(500);
        
        bombDelay=BOMBDELAY;
        Bomb bomb = new Bomb();
        addObject(bomb, x, 20);
        
    }
    
    public void act(){
        createBomb();    
    }
}
