package marioparty;

import java.util.ArrayList;
import java.util.Scanner;


public class Partida {

    public static void main(String[] args) {
        
    //VARIABLES   
    int rondas;  
    ArrayList<Jugador> jugadores = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int nJugadores;
    String nombre = "";
    Boolean jugar = false;
    
    Tablero t = new Tablero();
    
    //CREAR TABLERO
    t.crearTablero();
    do{
    
        //EMPIEZA LA PARTIDA + RESETEO VARIABLES
        rondas = 0;
        jugadores.clear();
        jugar = false;

        System.out.println("BIENVENIDO AL MARIO PARTY");
        System.out.println("");


        //añadir explicacion
        System.out.println("Numero de Jugadores");
        nJugadores = sc.nextInt();
        sc.nextLine(); //Para limpiar el scanner

        //FOR -> CREAR LOS JUGADORES Y ASIGNARLES UN NOMBRE
        System.out.println("");
        for(int i=0; i<nJugadores; i++){
            System.out.println("Nombre del jugador " + (i+1) +": ");
            nombre = sc.nextLine().toUpperCase();

            jugadores.add(new Jugador(nombre, 0, 0, t.getInicio()));
        }

        //DEFINIR NUMERO DE RONDAS
        System.out.println("");
        System.out.println("¿Cuantas rondas quereis jugar?");
        rondas = sc.nextInt();
        System.out.println("");

        //RESUMEN PARA INICIO DEL JUEGO
        System.out.println("EMPIEZA EL JUEGO!");
        System.out.println("");


          System.out.println(""" 
                       ------------ TABLERO ------------
                             
                        c1 -->  c2 --> c3 ----
                                ^            |             
                                |            v             
                                c6 <-- c5 <- c4 <-- c10             
                                |            ^       |
                                v            |       |
                                c7 --> c8-->c9 ------
                       """);

        for (int i = 0; i<rondas; i++){

            //JUEGO COMO TAL 
            for (int j=0; j<nJugadores; j++){
                System.out.println("*************************");
                System.out.println("RONDA " + (i+1) + " | TURNO DE " + jugadores.get(j).getNombre());
                System.out.println("");

                //PREGUNTAR SI QUIERE VER TABLERO HASTA LA ESTRELLA O NO 
                System.out.println("¿Quieres ver el tablero? (1: Si | 2: No)");
                int verTablero = 0;
                while(verTablero != 1 && verTablero != 2){
                    verTablero = sc.nextInt();
                }
                if(verTablero == 1){
                    jugadores.get(j).verTablero();
}

                System.out.println(jugadores.get(j).getNombre() + " tira el dado.");
                System.out.println("");

                jugadores.get(j).tirarDado(jugadores);
                jugadores.get(j).getPosicion().efectoCasilla(jugadores.get(j), jugadores);  //para que funcione el efecto
            }


            //IMPRIMIR RESULTADOS
            System.out.println("");
            System.out.println("--------------------------");
            System.out.println("RESULTADOS RONDA "+ (i+1));
            for(int k=0; k<nJugadores; k++){
                    System.out.println( jugadores.get(k).getNombre() +
                                       " (Posicion: " + jugadores.get(k).getPosicion().getNombre() +
                                       " | Estrellas: " + jugadores.get(k).getEstrellas() +
                                       " | Monedas:  " + jugadores.get(k).getMonedas());
            }
            System.out.println("--------------------------");
            System.out.println("");
        }
        
        //IMPRIMIR RESULTADOS
        Jugador ganador = Jugador.getGanador(jugadores);
        System.out.println("==========================");
        System.out.println("¡¡ GANA " + ganador.getNombre() + " !!");
        System.out.println("Estrellas: " + ganador.getEstrellas() + " | Monedas: " + ganador.getMonedas());
        System.out.println("==========================");
        
        //PREGUNTA SI QUIERES VOLVER A JUGAR
        
        int respuesta = 0;
        while(respuesta != 1 && respuesta != 2){
            System.out.println("¿Quereis volver a jugar? (1: Si | 2: No)");
            respuesta = sc.nextInt();
            sc.nextLine();
        }
        if(respuesta == 2){
            jugar = false;
            System.out.println("¡Hasta la próxima!");
        } else
            jugar = true;
        
    }while(jugar == true);
    }
    
}

