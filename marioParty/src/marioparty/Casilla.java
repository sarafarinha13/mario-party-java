package marioparty;

import java.util.ArrayList;

public abstract class Casilla {
    private String nombre;
    
    //SIRVE PARA CREAR EL TABLERO
    private ArrayList<Casilla> camino = new ArrayList<> ();

     
    //CONSTRUCTORES DE CASILLA
    public Casilla(String nombre){
        this.nombre = nombre;
    }
    
    
    public Casilla(){}


    //METODOS CASILLA
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }


    //METODOS PARA CREAR LOS CAMINOS DEL TABLERO
    public void addCamino(Casilla c){
        this.camino.add(c);
    }
    
    public ArrayList<Casilla> getCamino(){
        return this.camino;
    }
    
    
    //METODOS @OVERRIDE
    public abstract void efectoCasilla(Jugador j, ArrayList<Jugador> jugadores);
    
    }