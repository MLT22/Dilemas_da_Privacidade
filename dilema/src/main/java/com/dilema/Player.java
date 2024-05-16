package com.dilema;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

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
        for (int i = 1; i <= numDado;i++){
            posX ++;
            posY ++;
            // animacaoAndarCasas(posX, posY);
            player.setTranslateX(tabulero.converteTela(tabulero.posicTabuleiroX[posX]));
            player.setTranslateY(tabulero.converteTela(tabulero.posicTabuleiroY[posY]));
            
            
        }
       
        
        
        
    }
    public void animacaoAndarCasas(int posicFinalX,int posicFinalY){
        TranslateTransition animacao = new TranslateTransition(Duration.millis(1000), player);
        animacao.setToX(tabulero.converteTela(tabulero.posicTabuleiroX[posX]));
        animacao.setToY(tabulero.converteTela(tabulero.posicTabuleiroY[posicFinalY]));
        animacao.setAutoReverse(false);
        animacao.play();
    }

}
