package com.dilema;



import javafx.animation.SequentialTransition;
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

   

    public void andarCasas() {
        int numDado = sorteador.sortearDado();
        numTeste = numDado;

        SequentialTransition seqT = new SequentialTransition();

        // Move the player step-by-step based on the dice roll
        for (int i = 1; i <= numDado; i++) {
            final int step = i; // Current step in the loop
            TranslateTransition tt = new TranslateTransition(Duration.millis(500), player);

            // Calculate the next position after this step
            int nextPosX = (posX + step) % tabulero.posicTabuleiroX.length;
            int nextPosY = (posY + step) % tabulero.posicTabuleiroY.length;

            tt.setToX(tabulero.convertePontoCentral(tabulero.posicTabuleiroX[nextPosX]));
            tt.setToY(tabulero.convertePontoCentral(tabulero.posicTabuleiroY[nextPosY]));

            tt.setOnFinished(e -> {
                posX = nextPosX;
                posY = nextPosY;
            });

            seqT.getChildren().add(tt);
        }

        seqT.setOnFinished(e -> {
            // Verify and update the final position according to game rules
            posX = tabulero.verificarCasa(posX);
            posY = posX; // Assuming posY should be updated to posX, as in the original code
            player.setTranslateX(tabulero.convertePontoCentral(tabulero.posicTabuleiroX[posX]));
            player.setTranslateY(tabulero.convertePontoCentral(tabulero.posicTabuleiroY[posY]));
        });

        seqT.play();
    }
       
        
        
        
    public void animacaoAndarCasas(int posicFinalX,int posicFinalY){
        TranslateTransition animacao = new TranslateTransition(Duration.millis(1000), player);
        animacao.setToX(tabulero.convertePontoCentral(tabulero.posicTabuleiroX[posX]));
        animacao.setToY(tabulero.convertePontoCentral(tabulero.posicTabuleiroY[posicFinalY]));
        animacao.setAutoReverse(false);
        animacao.play();
    }

}
