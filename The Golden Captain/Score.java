import greenfoot.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score extends World {
    private final String RUTA_ARCHIVO = "scores.txt";
    
    public Score() {
        super(800, 500, 1); 
        addObject(new Continue(), 0, 0);
        
        readScore();
    }
    
    private void readScore() {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            Scanner scanner = new Scanner(archivo);
            
            int y = 150; // Variable para controlar la posición vertical de los puntajes
            
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                int puntaje = Integer.parseInt(linea);
                
                showText("Puntaje: " + puntaje, getWidth() / 2, y);
                y += 30; // Incrementar la posición vertical para el siguiente puntaje
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


