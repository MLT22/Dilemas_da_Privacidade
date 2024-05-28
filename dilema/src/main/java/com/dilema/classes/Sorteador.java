package com.dilema.classes;

import java.util.Random;

public class Sorteador {
  
    public int sortearDado(){
        var dado = new Random();
        int numDado = dado.nextInt(6) + 1;
        return numDado;
    }
    public int sortearCasaEspecial(){
        var dado = new Random();
        int tipoCasaEspecial = dado.nextInt(2) + 1;
        return tipoCasaEspecial;
    }
    public int sortearNumCasas(){
        var dado = new Random();
        int numCasasAndar = dado.nextInt(3) + 2;
        return numCasasAndar;
    }

}
