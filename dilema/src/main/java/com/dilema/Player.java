package com.dilema;

import java.util.Random;

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
        player.setTranslateX(tabulero.converteTela(posX));
        player.setTranslateY(tabulero.converteTela(posY));
        
    }

    public int jogarDado(){// sortear um número aleatório entre 1 e 6
       var dado = new Random();
       int numDado = dado.nextInt(6) + 1;
       return numDado;
    }

    public void andarCasas() {
        int numDado = jogarDado();
        numTeste = numDado;
        if (posX % 2 == 0 || posX == 0) {
            if (posY + numDado >= tabulero.casasY - 1) {
                numDado = tabulero.casasY - 1 - posY; // Quantidade de casas que excedeu
                posY = tabulero.casasY - 1;
                posX++;
                posY -= numDado;
            } else {
                posY += numDado;
            }
        } else {
            if (posY - numDado < 0) {
                numDado = posY; // Quantidade de casas que excedeu
                posY = 0;
                posX++;
                posY += numDado;
            } else {
                posY -= numDado;
            }
        }
        
    player.setTranslateX(tabulero.converteTela(posX));
    player.setTranslateY(tabulero.converteTela(posY));
    }

}
