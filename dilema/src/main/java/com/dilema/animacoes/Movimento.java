package com.dilema.animacoes;

import com.dilema.classes.Tabuleiro;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Movimento {
    private Tabuleiro tabuleiro = new Tabuleiro();

    public void andarCasas(int numDado, int posic, ImageView player, Runnable fimAnimacao) {
        SequentialTransition sequenciaDeAnimacao = new SequentialTransition();

        for (int i = 1; i <= numDado; i++) {
            TranslateTransition movimento = new TranslateTransition(Duration.millis(300), player);

            int proxPosic = (posic + i) < tabuleiro.getLength() ? posic + i : tabuleiro.getLength() - 1;
            
            movimento.setToX(tabuleiro.colocarPlayerX(proxPosic));
            movimento.setToY(tabuleiro.colocarPlayerY(proxPosic));

            sequenciaDeAnimacao.getChildren().add(movimento);
        }
        
        sequenciaDeAnimacao.setOnFinished(e -> {
            int novaPosic = (posic + numDado) < tabuleiro.getLength() ? posic + numDado : tabuleiro.getLength() - 1;
             
            player.setTranslateX(tabuleiro.colocarPlayerX(novaPosic));
            player.setTranslateY(tabuleiro.colocarPlayerY(novaPosic));
            fimAnimacao.run();
            
        });
        sequenciaDeAnimacao.play();
    }
    public void voltarCasas(int numDado, int posic, ImageView player, Runnable fimAnimacao){
        SequentialTransition sequenciaDeAnimacao = new SequentialTransition();

        for (int i = 1; i <= numDado; i++) {
            TranslateTransition movimento = new TranslateTransition(Duration.millis(300), player);

            int proxPosic = (posic - i);
            
            movimento.setToX(tabuleiro.colocarPlayerX(proxPosic));
            movimento.setToY(tabuleiro.colocarPlayerY(proxPosic));

            sequenciaDeAnimacao.getChildren().add(movimento);
        }
        
        sequenciaDeAnimacao.setOnFinished(e -> {
            int novaPosic = posic - numDado;
             
            player.setTranslateX(tabuleiro.colocarPlayerX(novaPosic));
            player.setTranslateY(tabuleiro.colocarPlayerY(novaPosic));
            fimAnimacao.run();
            
        });
        sequenciaDeAnimacao.play();
    }
}