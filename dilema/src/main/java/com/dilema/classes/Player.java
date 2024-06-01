package com.dilema.classes;

import com.dilema.animacoes.Movimento;
import com.dilema.telas.TelaTabuleiro;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Sorteador sorteador = new Sorteador();
    private Movimento animacao = new Movimento();
    private CasaEspecial casaEspecial = new CasaEspecial();

    private int posic = 0;
    public boolean vezJogador = false;

    private ImageView player;
    private Image imagemPlayer;
    public int numTeste;

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

    public ImageView getPlayerImageView() {
        return player;
    }

    public void andarCasas(Runnable finalAndarCasa) {
        int numDado = sorteador.sortearDado(); // sortear um número de 1 - 6
        numTeste = numDado; // variável para mostrar o valor tirado no dado, no tabulero

        animacao.andarCasas(numDado, posic, player, () -> {
            posic = (posic + numDado) < tabuleiro.getLength() ? posic + numDado : tabuleiro.getLength() - 1;
            tabuleiro.verificarCasa(posic, player,() -> {
                posic = tabuleiro.getPosicFinal();
                finalAndarCasa.run();
            });
 
        });

    }
}