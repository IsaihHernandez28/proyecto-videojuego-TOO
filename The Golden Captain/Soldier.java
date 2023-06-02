import greenfoot.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;

public class Soldier extends Actor
{
    private final GreenfootImage right1 = new GreenfootImage("0.png");
    private final GreenfootImage left1 = new GreenfootImage("3.png");
    private final int MAX_SHOOT_DELAY = 100;
    private final int BULLET_DIRECTION_RIGHT = 1;
    private final int BULLET_DIRECTION_LEFT = 0;
    
    private int shootDelay;
    private int bulletDirection = BULLET_DIRECTION_RIGHT;
    private boolean jumping;
    private int velocidad; // Velocidad de movimiento del objeto
    private int velocidadGravedad;
    private int piso;
    private boolean space;
    private int score;
    private int health = 100;
    private int levelCounter;
    private boolean initializeHUD = true;
    
    public Soldier()
    {
        piso = 375;
        velocidad = 3;
        velocidadGravedad = 7;
        space = false;
        levelCounter = 2;
    }
    public void move()
    {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - velocidad, getY()); // Mover hacia la izquierda
            setImage(left1);
            bulletDirection = BULLET_DIRECTION_LEFT;
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + velocidad, getY()); // Mover hacia la derecha
            setImage(right1);
            bulletDirection = BULLET_DIRECTION_RIGHT;
        }
        
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX() , getY() + velocidad);
        }
        
        if (Greenfoot.isKeyDown("up") && getY()>350) {
            setLocation(getX() , getY() - velocidad);
        }
        
        if (Greenfoot.isKeyDown("space") && !jumping) {
            jumping = true; // Salto
            velocidadGravedad = -40;
            //space = true; // Establecer la variable de control a verdadero
        }
        if (!Greenfoot.isKeyDown("space")) {
            space = false; // Restablecer la variable de control cuando se suelta la tecla
        }
    }
    
    public void gravedad()
    {
        if(jumping)
        {
            setLocation(getX(), getY() + velocidadGravedad);
            velocidadGravedad += 4;
            
            if(getY()>=piso){
                jumping = false;
            }
        }
        
    }
    
    public void shoot(){  
        if(shootDelay > 0){
            shootDelay--;
            return;
        }
        
        if(Greenfoot.isKeyDown("D")){
            shootDelay = MAX_SHOOT_DELAY;
            Bullet bullet = new Bullet(bulletDirection);
            getWorld().addObject(bullet,getX(),getY());
        }     
    }
    
    private void updateHud(){
        World world = getWorld();
        world.showText("Score:" + score, world.getWidth()-100, 20);
        world.showText("Health:" + health, world.getWidth()-200, 20);
    }
    
    public boolean incomingDamage(){
        Actor enemybullet = getOneIntersectingObject(EnemyBullet.class);
        
        if(enemybullet!= null){
            getWorld().removeObject(enemybullet);
            health -= 10;
            return true;
        }
        
        
        Actor enemyrocket = getOneIntersectingObject(EnemyRocket.class);
        
        if(enemyrocket!= null){
            getWorld().removeObject(enemyrocket);
            health -= 30;
            return true;
        }
        
        Actor bomb = getOneIntersectingObject(Bomb.class);
        
        if(bomb!= null){
            getWorld().removeObject(bomb);
            health -= 20;
            return true;
        }
        
        return false;
    }
    
    public boolean atEdge(){
        if(getX() == 780){
            return true;
        }
        return false;
    }
    public void increaseScore(int enemyType){
        if(enemyType == 0){
            score += 300;
        }
        
        if(enemyType == 1){
            score += 100;
        }
        
        if(enemyType == 2){
            score += 600;
        }
        
        updateHud();
    }
    
    
    public void act()
    {   
        move();
        gravedad();
        shoot();
        
        if(incomingDamage() || initializeHUD){
         updateHud();   
         initializeHUD = false;
        }
        
        if(atEdge()){
         if(levelCounter == 2){
             Level2 level2 = new Level2();
             Greenfoot.setWorld(level2);
             level2.addObject(this,75, 434);
             levelCounter++;
             initializeHUD = true;
         }else if(levelCounter == 3){
             Level3 level3 = new Level3();
             level3.addObject(this,75, 434);
             Greenfoot.setWorld(level3);
             levelCounter++;
             initializeHUD = true;
         }else {
             Final final1 = new Final();
             Greenfoot.setWorld(final1);
             saveScore();
         }
        }
        
        if(health <= 0){
            Greenfoot.setWorld(new Gameover());
            saveScore();
        }
        
    }
    private void saveScore() {
        try {
            List<Integer> puntajes = readScore();
            puntajes.add(score);
            Collections.sort(puntajes, Collections.reverseOrder());
            if (puntajes.size() > 5) {
                puntajes = puntajes.subList(0, 5);
            }
            writeScore(puntajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Integer> readScore() throws IOException {
        List<Integer> puntajes = new ArrayList<>();
        File archivo = new File("scores.txt");
        if (archivo.exists()) {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                int puntaje = Integer.parseInt(linea);
                puntajes.add(puntaje);
            }
            scanner.close();
        }
        return puntajes;
    }

    private void writeScore(List<Integer> puntajes) throws IOException {
        FileWriter writer = new FileWriter("scores.txt");
        for (int puntaje : puntajes) {
            writer.write(String.valueOf(puntaje));
            writer.write(System.lineSeparator());
        }
        writer.close();
    }
/*    private void saveScore() {
        try {
            FileWriter writer = new FileWriter("scores.txt", true);            
            writer.write(String.valueOf(score));
            writer.write(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}