import greenfoot.*;

public class Soldier extends Person
{
    private int velocidad = 5; // Velocidad de movimiento del objeto
    
    public void act()
    {
        move();
    }

    public void move()
    {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - velocidad); // Mover hacia arriba
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + velocidad); // Mover hacia abajo
        } else if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - velocidad, getY()); // Mover hacia la izquierda
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + velocidad, getY()); // Mover hacia la derecha
        }
    }
}
