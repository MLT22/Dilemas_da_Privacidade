package com.dilema;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.scene.shape.Circle;

public class Player {
    Tabulero tabulero = new Tabulero();

    public int posX = 0;
    public int posY = 0;
    public Circle player;
    public int numTeste;


    public Player(int tamanhoPlayer,String nome){
        player = new Circle(tamanhoPlayer);
        player.setId(nome);
        player.getStyleClass().add("style.css");
        player.setTranslateX(tabulero.converteTela(tabulero.posicTabuleiroX[posX]));
        player.setTranslateY(tabulero.converteTela(tabulero.posicTabuleiroY[posY]));
        
    }

    public int jogarDado(){// sortear um número aleatório entre 1 e 6
       var dado = new Random();
       int numDado = dado.nextInt(6) + 1;
       return numDado;
    }

    public void andarCasas(){
        int numDado = jogarDado();
        numTeste = numDado;
        posX += numDado;
        posY += numDado;
            
        
        player.setTranslateX(tabulero.converteTela(tabulero.posicTabuleiroX[posX]));
        player.setTranslateY(tabulero.converteTela(tabulero.posicTabuleiroY[posY]));
        
    }

}
