package marioparty;

import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
    
    ArrayList<Casilla> tablero = new ArrayList<>();
  
    //CREAR CASILLAS Y SU TIPO
        Casilla c1 = new CAzul("c1");
        Casilla c2 = new CAzul("c2");
        Casilla c3 = new CVerde("c3");
        Casilla c4 = new CRoja("c4");
        Casilla c5 = new CAzul("c5");
        Casilla c6 = new CAzul("c6");
        Casilla c7 = new CAzul("c7");
        Casilla c8 = new CEstrella("c8");
        Casilla c9 = new CVerde("c9");
        Casilla c10 = new CEstrella("c10");
        
    public void crearTablero(){      
        
    //CREAR RECORRICO DEL TABLERO - LLAMAMOS AL MÉTODO DE AÑADIR AL ARRAY LIST DE CAMINOS
        c1.addCamino(c2);
        c2.addCamino(c3);
        c3.addCamino (c4);
        c4.addCamino (c5);
        c5.addCamino (c6);
        c6.addCamino (c7); //Bifurcacion
        c6.addCamino (c2); //Bifurcacion
        c7.addCamino (c8);
        c8.addCamino (c9);
        c9.addCamino (c10); //Bifurcacion
        c9.addCamino (c4); // Bifurcacion
        c10.addCamino (c4); 
       
        

    }
    
    //Se lo asignamos a los jugadores que creemos
    public Casilla getInicio(){
        return c1;
    }
    
}