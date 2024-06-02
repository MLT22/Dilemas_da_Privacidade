package com.dilema.classes;

import com.dilema.animacoes.Dado;
import com.dilema.animacoes.Movimento;
import com.dilema.telas.TelaTabuleiro;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private Tabuleiro tabuleiro = new Tabuleiro();
    
    private Movimento animacao = new Movimento();


    private int posic = 0;
    public boolean vezJogador = false;

    private ImageView player;
    private Image imagemPlayer;
    

    public ImageView getPlayer() {
        return player;
    }

    public Player(String cor) {
        imagemPlayer = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/" + cor));
        player = new ImageView(imagemPlayer);
        player.setFitHeight(TelaTabuleiro.getTilesize());
        player.setTranslateX(tabuleiro.colocarPlayerX(posic));
        player.setTranslateY(tabuleiro.colocarPlayerY(posic));
    }


    public void andarCasas(int numDado,Runnable finalAndarCasa) {
        animacao.andarCasas(numDado, posic, player, () -> {
            posic = (posic + numDado) < tabuleiro.getLength() ? posic + numDado : tabuleiro.getLength() - 1;
            tabuleiro.verificarCasa(posic, player,() -> {
                posic = tabuleiro.getPosicFinal();
                finalAndarCasa.run();
            });

        });
    }
}