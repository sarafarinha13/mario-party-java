package marioparty;

import java.util.ArrayList;

public class CEstrella extends Casilla {
       
    public CEstrella(){}
    
    public CEstrella(String nombre){
        super (nombre);
    }
    
    
    
    
    public void efectoCasilla(Jugador j, ArrayList<Jugador> jugadores){
        
       
        
         if (j.getMonedas() >= 7) {
            j.alterMonedas(-7);      // le quita las 10 monedas
            j.alterEstrellas(1);      // le da la estrella
            System.out.println(j.getNombre() + " ha comprado una estrella por 7 monedas!");
            System.out.println("");
        } else {
            System.out.println(j.getNombre() + " no tiene suficientes monedas para comprar una estrella");
            System.out.println("");
        }
         
         j.avanzar(jugadores); //como no se puede quedar en la casilla, le sumamos una posición

         
    }
}