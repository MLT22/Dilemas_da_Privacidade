package com.dilema.classes;

import com.dilema.telas.TelaTabuleiro;

import javafx.scene.image.ImageView;

public class Tabuleiro {
    private int tamanhoPixel = TelaTabuleiro.getTilesize();

    private int[] posicTabuleiroX = {2,3,4,5,5,5,4,3,3,3,3,3,4,5,6,7,8,9,9,9,8,7,7,7,8,9,10,11,11,11,11,11,12,13,13,13,13,13,13,13,12,11,10,10,10,11,12,13,14,15,16,17,17,17,16,16,16,16,16,16,17,18};
    private int[] posicTabuleiroY = {3,3,3,3,4,5,5,5,6,7,8,9,9,9,9,9,9,9,8,7,7,7,6,5,5,5,5,5,6,7,8,9,9,9,8,7,6,5,4,3,3,3,3,2,1,1,1,1,1,1,1,1,2,3,3,4,5,6,7,8,8,8};
    private int posicFinal;
    public int getIndexPosicTabuleiroX(int index) {
        return posicTabuleiroX[index];
    }

    public int getIndexPosicTabuleiroY(int index) {
        return posicTabuleiroY[index];
    }

    public int getLength() {
        return posicTabuleiroX.length;
    }

    public int colocarPlayerX(int posicao) {
        return converteQuadrado(getIndexPosicTabuleiroX(posicao));
    }

    public int colocarPlayerY(int posicao) {
        return converteQuadrado(getIndexPosicTabuleiroY(posicao));
    }

    public int convertePontoCentral(int posicaoX) {
        return (tamanhoPixel / 2) + (tamanhoPixel * posicaoX);
    }

    public int converteQuadrado(int posicaoX) {
        return (tamanhoPixel * posicaoX) + 5;
    }

    public int getPosicFinal() {
        return posicFinal;
    }

    public void verificarCasa(int posic, ImageView player, Runnable fimVerificacao) {
        posicFinal = posic;
        if (posic == getLength() - 1) {
            System.out.println("Venceu");
        } else {
            CasaEspecial casaEspecial = new CasaEspecial();
            if (casaEspecial.verificarCasaEspecial(posic)) {
                casaEspecial.cartaEspecial(posic, player, () -> {
                    posicFinal = casaEspecial.getPosicFinal();
                    fimVerificacao.run();
                });
            } else {
                posicFinal = posic;
                fimVerificacao.run();
            }
        }
        
    }

}