package com.dilema;



import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.util.Duration;

public class Player {
    Tabulero tabulero = new Tabulero();
    Sorteador sorteador = new Sorteador();
    TelaTabulero tela = new TelaTabulero();

    public int posX = 0;
    public int posY = 0;
    public boolean vezJogador = false;

    public ImageView player;
    public Image imagemPlayer;
    public int numTeste;


    public Player(String cor){
        imagemPlayer = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/" + cor));
        player = new ImageView(imagemPlayer);
        player.setFitHeight(40);
        player.getStyleClass().add("style.css");
        player.setTranslateX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[posX]));
        player.setTranslateY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[posY]));
        
    }

   

    public void andarCasas() {
        int numDado = sorteador.sortearDado();//sortear um número de 1 - 6
        numTeste = numDado;//variavel para mostrar o valor tirado no dado, no tabulero

        SequentialTransition sequenciaDeAnimacao = new SequentialTransition();//salvar cada animação de mudança de casa

        // Andar de casa em casa da posX ate posX + numdado
        for (int i = 1; i <= numDado; i++) {
            TranslateTransition animacaoDeCadaCasa = new TranslateTransition(Duration.millis(500), player);

            // Verificar qual é a proxima casa
            int proxPosicX = (posX + i) % tabulero.posicTabuleiroX.length;
            int proxPosicY = (posY + i) % tabulero.posicTabuleiroY.length;
            // Animação do player indo para a proxima casa
            animacaoDeCadaCasa.setToX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[proxPosicX]));
            animacaoDeCadaCasa.setToY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[proxPosicY]));
            // Mudando o valor do player para a nova casa que ele foi
            animacaoDeCadaCasa.setOnFinished(e -> {
                posX = proxPosicX;
                posY = proxPosicY;
            });
            // adicionando todas as animaçoes do player andando apara uma sequencia de animação
            sequenciaDeAnimacao.getChildren().add(animacaoDeCadaCasa);
        }
        //Apos o player andar todas as casas que ele precisa, verificar a casa na qual caiu
        sequenciaDeAnimacao.setOnFinished(e -> {
            posX = tabulero.verificarCasa(posX);
            posY = posX;
            player.setTranslateX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[posX]));
            player.setTranslateY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[posY]));
        });

        sequenciaDeAnimacao.play();
    }
    
    
       
        
        
        
  
}
