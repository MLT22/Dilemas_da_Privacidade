package com.dilema.classes;


import com.dilema.animacoes.Movimento;
import com.dilema.telas.TelaTabuleiro;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Player {
    private Tabuleiro tabuleiro = new Tabuleiro();
    
    private Movimento animacao = new Movimento();


    private int posic = 0;
    private boolean vezJogador = false;

    private ImageView player;
    private Image imagemPlayer;
    private String nome;
    private String cor;
    

    public ImageView getPlayer() {
        return player;
    }
    public String getNome() {
        return nome;
    }
    public boolean getVezJogador(){
        return vezJogador;
    }
    public void setVezJogador(boolean vezJogador){
        this.vezJogador = vezJogador;
    }

    public Player(String cor, String nome) {
        
        imagemPlayer = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/" + cor));
        player = new ImageView(imagemPlayer);
        player.setFitHeight(TelaTabuleiro.getTilesize());
        player.setTranslateX(tabuleiro.colocarPlayerX(posic));
        player.setTranslateY(tabuleiro.colocarPlayerY(posic));
        this.nome = nome;
        this.cor = cor;
    }


    public void andarCasas(int numDado,Stage telaTabuleiro,Runnable finalAndarCasa) {
        animacao.andarCasas(numDado, posic, player, () -> {
            posic = (posic + numDado) < tabuleiro.getLength() ? posic + numDado : tabuleiro.getLength() - 1;
            tabuleiro.verificarCasa(posic,nome,cor, player, telaTabuleiro,() -> {
                posic = tabuleiro.getPosicFinal();
                finalAndarCasa.run();
            });

        });
    }
}