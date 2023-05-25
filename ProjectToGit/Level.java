import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Level extends World 
{
    protected static Soldier soldier = new Soldier();
    public Level()
    {
        super(800, 500, 1);
    }
}
