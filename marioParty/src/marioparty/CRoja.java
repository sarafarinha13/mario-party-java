package marioparty;

import java.util.ArrayList;

public class CRoja extends Casilla {
    
    public CRoja(String nombre) {
        super(nombre);
    }
    
    public CRoja(){}
    
    
    @Override
    public void efectoCasilla(Jugador j, ArrayList<Jugador> jugadores){
        j.alterMonedas(-5);
        
        System.out.println(j.getNombre() + " pierde 5 monedas ;(");
        System.out.println("");
}

}