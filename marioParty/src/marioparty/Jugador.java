package marioparty;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    private Scanner sc = new Scanner(System.in);
    private int respuesta;

    private String nombre;
    private int monedas;
    private int estrellas;
    private Casilla posicion;

    //CONSTRUCTOR
    public Jugador(String nombre, int monedas, int estrellas, Casilla posicion) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.estrellas = estrellas;
        this.posicion = posicion;
    }

    //METODOS JUGADOR
    public String getNombre() {
        return nombre;
    }

    //METODOS MONEDAS
    public void alterMonedas(int monedas) {
        this.monedas += monedas;

        if (this.monedas < 0) {
            this.monedas = 0;
        }
    }

    public int getMonedas() {
        return this.monedas;
    }

    //METODOS ESTRELLAS
    public void alterEstrellas(int estrellas) {
        this.estrellas += estrellas;

        if (this.estrellas < 0) {
            this.estrellas = 0;
        }
    }

    public int getEstrellas() {
        return this.estrellas;
    }

    public Casilla getPosicion() {
        return this.posicion;
    }

    //METODOS ESPECIALES - avanzar
    public void avanzar(ArrayList<Jugador> jugadores) {

        if (this.posicion.getCamino().size() == 2) {

            System.out.println("ANTENCION! Hay una bifurcacion");

            while (respuesta != 1 && respuesta != 2) {
                System.out.println("¿Que camino eliges: 1: " + this.posicion.getCamino().get(0).getNombre() + " | 2: " + this.posicion.getCamino().get(1).getNombre() + " ?");
                respuesta = sc.nextInt();
            }
            
          
            this.posicion = this.posicion.getCamino().get(respuesta-1);
            respuesta = 0;

        } else {
            this.posicion = this.posicion.getCamino().get(0);
        }
        
        if(this.posicion instanceof CEstrella){
            this.posicion.efectoCasilla(this, jugadores);
        }
     
        
    }

    //METODOS ESPECIALES - Tirar dado 
    public void tirarDado(ArrayList<Jugador> jugadores) {
        int dado = (int) ((Math.random() * 6) + 1);

        System.out.println("Sale un " + dado);
        System.out.println("");
        
        for (int i = 0; i < dado; i++) {
            this.avanzar(jugadores);
            
       
        }

        System.out.println("Se mueve hasta la casilla " + this.getPosicion().getNombre());
        System.out.println("");
    }
    
    //METODO PARA DECIR QUIEN ES GANADOR
    public static Jugador getGanador(ArrayList<Jugador> jugadores){
        Jugador ganador = jugadores.get(0);
        for(Jugador jugador : jugadores){
            if(jugador.getEstrellas() > ganador.getEstrellas()){
                ganador = jugador;
            } else if(jugador.getEstrellas() == ganador.getEstrellas()){
                if(jugador.getMonedas() > ganador.getMonedas()){
                    ganador = jugador;
                }
            }
        }
    return ganador;
    }
    
    //METODO PARA VER TABLERO DESDE LA POSICION DEL JUGAGOR
    
    public void verTablero(){
    Casilla actual = this.posicion;
    int distancia = 1;
    
    while(!actual.getCamino().isEmpty()){
        actual = actual.getCamino().get(0);
        
        String tipo = "";
        if(actual instanceof CAzul)     tipo = "Azul";
        if(actual instanceof CRoja)     tipo = "Roja";
        if(actual instanceof CVerde)    tipo = "Verde";
        if(actual instanceof CEstrella) tipo = "Estrella";
        
        System.out.println("Distancia " + distancia + ": " + actual.getNombre() + " -> " + tipo);
        distancia++;
        
        if(actual instanceof CEstrella) break;
    }
}

    
   
}

