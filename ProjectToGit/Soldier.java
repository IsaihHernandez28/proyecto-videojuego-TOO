import greenfoot.*;

public class Soldier extends Person
{
    private int velocidad = 5; // Velocidad de movimiento del objeto
    
    public void act()
    {
        move();
        setImage("Soldier1.png");
    }

    public void move()
    {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - velocidad, getY()); // Mover hacia la izquierda
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + velocidad, getY()); // Mover hacia la derecha
        }
        if (Greenfoot.isKeyDown("space")){
            setLocation(getY() + velocidad, getX());
        }
    }
}
