import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Actor
{
    int option = 0;
    
    /**
     * Act - do whatever the Selector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Pointer(){
        GreenfootImage myImage = getImage();
        myImage.scale(50,50);
        setImage(myImage);
    }
}
