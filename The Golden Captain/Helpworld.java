import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Howtoplayworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helpworld extends World
{

    /**
     * Constructor for objects of class Howtoplayworld.
     * 
     */
    public Helpworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 
        addObject(new Continue(), 0, 0);
    }
}
