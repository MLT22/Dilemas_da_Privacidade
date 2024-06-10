package com.dilema.classes;

import java.util.Random;

public class Sorteador {
    Random sorteador = new Random();
  
    public int sortearDado(){       
        int numDado = sorteador.nextInt(6) + 1;
        return 6;
    }
    public int sortearCasaEspecial(){        
        int tipoCasaEspecial = sorteador.nextInt(2) + 1;
        return tipoCasaEspecial;
    }
    public int sortearNumCasas(){      
        int numCasasAndar = sorteador.nextInt(3) + 2;
        return numCasasAndar;
    }
    public int sortrearIdCarta(int tamanhoLista){
        int idCarta = sorteador.nextInt(tamanhoLista);
        return idCarta;
    }

}
