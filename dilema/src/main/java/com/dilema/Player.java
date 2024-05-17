package com.dilema;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    Tabulero tabulero = new Tabulero();
    Sorteador sorteador = new Sorteador();

    public int posX = 0;
    public int posY = 0;
    public Circle player;
    public int numTeste;


    public Player(int tamanhoPlayer,String nome){
        player = new Circle(tamanhoPlayer);
        player.setId(nome);
        player.getStyleClass().add("style.css");
        player.setTranslateX(tabulero.convertePontoCentral(tabulero.posicTabuleiroX[posX]));
        player.setTranslateY(tabulero.convertePontoCentral(tabulero.posicTabuleiroY[posY]));
        
    }

   

    public void andarCasas(){
        int numDado = sorteador.sortearDado();
        numTeste = numDado;
        // for (int i = 1; i <= numDado;i++){
        //     // animacaoAndarCasas(posX, posY);
        // }
        posX = posX + numDado >= tabulero.posicTabuleiroX.length ? tabulero.posicTabuleiroX.length - 1 : posX + numDado;
        posY = posY + numDado >= tabulero.posicTabuleiroY.length ? tabulero.posicTabuleiroY.length - 1 : posY + numDado; ;
        System.out.println("O player vai para a casa: " + posX);

        posX = tabulero.verificarCasa(posX);
        posY = posX;
        player.setTranslateX(tabulero.convertePontoCentral(tabulero.posicTabuleiroX[posX]));
        player.setTranslateY(tabulero.convertePontoCentral(tabulero.posicTabuleiroY[posY]));
    }
       
        
        
        
    public void animacaoAndarCasas(int posicFinalX,int posicFinalY){
        TranslateTransition animacao = new TranslateTransition(Duration.millis(1000), player);
        animacao.setToX(tabulero.convertePontoCentral(tabulero.posicTabuleiroX[posX]));
        animacao.setToY(tabulero.convertePontoCentral(tabulero.posicTabuleiroY[posicFinalY]));
        animacao.setAutoReverse(false);
        animacao.play();
    }

}
