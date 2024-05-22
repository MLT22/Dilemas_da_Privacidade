package com.dilema;


import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.util.Duration;

public class Player {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Sorteador sorteador = new Sorteador();
 

    private int posic = 0;

    public boolean vezJogador = false;

    private ImageView player;
    private Image imagemPlayer;
    public int numTeste;


    public Player(String cor){
        imagemPlayer = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/" + cor));
        player = new ImageView(imagemPlayer);
        player.setFitHeight(40);
        player.getStyleClass().add("style.css");
        player.setTranslateX(tabuleiro.colocarPlayerX(posic));
        player.setTranslateY(tabuleiro.colocarPlayerY(posic));
        
    }

    

    @SuppressWarnings("exports")
    public ImageView getPlayer() {
        return player;
    }

   

    public void andarCasas() {
        int numDado = sorteador.sortearDado();//sortear um número de 1 - 6
        numTeste = numDado;//variavel para mostrar o valor tirado no dado, no tabulero
        SequentialTransition sequenciaDeAnimacao = new SequentialTransition();//salvar cada animação de mudança de casa

        // Andar de casa em casa da posX ate posX + numdado
        for (int i = 1; i <= numDado; i++) {
            TranslateTransition animacaoDeCadaCasa = new TranslateTransition(Duration.millis(500), player);

            // Verificar qual é a proxima casa
            int proxPosic = (posic + i) % tabuleiro.getLength();
            
            // Animação do player indo para a proxima casa
            animacaoDeCadaCasa.setToX(tabuleiro.colocarPlayerX(proxPosic));
            animacaoDeCadaCasa.setToY(tabuleiro.colocarPlayerY(proxPosic));
            // Mudando o valor do player para a nova casa que ele foi
            animacaoDeCadaCasa.setOnFinished(e -> {
                posic = proxPosic;
                
            });
            // adicionando todas as animaçoes do player andando apara uma sequencia de animação
            sequenciaDeAnimacao.getChildren().add(animacaoDeCadaCasa);
        }
        //Apos o player andar todas as casas que ele precisa, verificar a casa na qual caiu
        sequenciaDeAnimacao.setOnFinished(e -> {
            posic = tabuleiro.verificarCasa(posic);

            player.setTranslateX(tabuleiro.colocarPlayerX(posic));
            player.setTranslateY(tabuleiro.colocarPlayerY(posic));
        });

        sequenciaDeAnimacao.play();
        
    }
    
    
       
        
        
        
  
}
