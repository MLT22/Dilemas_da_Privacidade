package com.dilema.animacoes;

import com.dilema.classes.Sorteador;
import com.dilema.classes.Tabuleiro;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Dado {
    private Image ladoDado;
    private ImageView dado;
    private Sorteador sorteador = new Sorteador();
    private int numDado;
    

    Tabuleiro tabuleiro = new Tabuleiro();

    
    public Dado(int x){
        ladoDado = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/dado/dado1.png"));
        dado = new ImageView(ladoDado);
        dado.setTranslateX(x);
    }

    public ImageView getDado() {
        return dado;
    }
    public int getNumDado() {
        return numDado;
    }


    public void animacaoDado(Runnable fimAnimacao) {
        numDado = sorteador.sortearDado();
        Timeline timeline = new Timeline();
        for (int i = 1; i <= 6; i++) {
            int lado = i;
            KeyFrame keyFrame1 = new KeyFrame(Duration.millis(100 * (i * 2 - 1)), e -> {
                Image ladoDado = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/dado/dado" + lado + ".png"));
                dado.setImage(ladoDado);
            });
           
            timeline.getKeyFrames().addAll(keyFrame1);
        }
        KeyFrame finalFrame = new KeyFrame(Duration.millis(1200), e -> {
            Image ladoDado = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/dado/dado" + numDado + ".png"));
            dado.setImage(ladoDado);
            fimAnimacao.run();
        });
        timeline.getKeyFrames().add(finalFrame);
        timeline.play();
    }
    
}
