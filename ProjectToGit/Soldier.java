import greenfoot.*;

public class Soldier extends Person
{
    private int velocidad; // Velocidad de movimiento del objeto
    private int velocidadGravedad;
    private int piso;
    private boolean space;
    GreenfootImage right1;
    GreenfootImage right2;
    GreenfootImage left1;
    GreenfootImage left2;
    
    public Soldier()
    {
        velocidad = 3;
        velocidadGravedad = 7;
        piso = 434;
        space = false;
        right1 = new GreenfootImage("0.png");
        right2 = new GreenfootImage("1.png");
        left1 = new GreenfootImage("3.png");
        left2 = new GreenfootImage("2.png");
    }
    public void move()
    {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - velocidad, getY()); // Mover hacia la izquierda
            setImage(left1);
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + velocidad, getY()); // Mover hacia la derecha
            setImage(right1);
        }
         if (Greenfoot.isKeyDown("space") && !space) {
            setLocation(getX(), getY() - 100); // Salto
            space = true; // Establecer la variable de control a verdadero
        }
        if (!Greenfoot.isKeyDown("space")) {
            space = false; // Restablecer la variable de control cuando se suelta la tecla
        }
    }
    
    public void gravedad()
    {
        if(getY()<piso)
        {
            setLocation(getX(), getY() + velocidadGravedad);
        }
    }
    public void act()
    {
        move();
        gravedad();
    }
}
