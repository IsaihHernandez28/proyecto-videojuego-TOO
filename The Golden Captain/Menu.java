import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private int option = 0;
    private Pointer pointer = new Pointer();
    
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(600, 400, 1);
        prepare();
    }
    
    public void act(){
        int y = pointer.getY();
        Greenfoot.delay(8); //bloquea todo
        if (Greenfoot.isKeyDown("up") && option>0){
            option--;
            pointer.setLocation(210,y-92);
        }   
        if (Greenfoot.isKeyDown("down") && option<3){
            option++;
            pointer.setLocation(210,y+92);
        }
        
        if (Greenfoot.isKeyDown("enter")){
            switch(option){
                case 0:
                    Greenfoot.setWorld(new Level1());
                    break;
                case 1:
                    Greenfoot.setWorld(new Score());
                    break;
                case 2:
                    Greenfoot.setWorld(new Helpworld());
                    break;
                case 3:
                    Greenfoot.stop();
                    break;
            }
        }
    }    
    public void prepare(){
        addObject(pointer,210,80);
    } 
}