package marioparty;

import java.util.ArrayList;

public class CVerde extends Casilla {
        
    public CVerde(){}
    
    public CVerde(String nombre){
        super (nombre);
    }
    
    
    @Override
    public void efectoCasilla(Jugador j, ArrayList<Jugador> jugadores){
        int opcion = (int)(Math.random()*3)+1;
        
        switch(opcion){

        case 1:  //Le da 5 monedas a todos los jugadores
            for(Jugador jugador : jugadores){
                jugador.alterMonedas(+5);
            }
            System.out.println("Todos los  jugadores ganan 5 monedas!");
            break;

        case 2: //Genera un número random y hace que el for ejecute ese número de veces el método avanzar() del jugador
            
            int aMover = (int)((Math.random()*6)+1);
            
            System.out.println("Te ha tocado: VOLVER A TIRAR EL DADO. Ha salido un " + aMover);
            
            for(int i=0; i<aMover; i++){
                j.avanzar(jugadores);
            }
            
            System.out.println(j.getNombre() + " ahora está en la casilla " + j.getPosicion().getNombre());
            j.getPosicion().efectoCasilla(j, jugadores);
            System.out.println("");
            break;
            
        case 3:
            System.out.println("Lo siento... No hay te ha tocado ningún efecto");
            System.out.println("");
            break;

        
        }
    }
}