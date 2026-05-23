package marioparty;

import java.util.ArrayList;


public class CAzul extends Casilla {
   
    public CAzul(){}
    
    public CAzul(String nombre){
        super (nombre);
    }
    
    
    //METODO 
    @Override
    public void efectoCasilla(Jugador j, ArrayList<Jugador> jugadores){
        j.alterMonedas(+3);
        
        System.out.println(j.getNombre() + " gana 3 monedas!");
        System.out.println("");
    }
    
}