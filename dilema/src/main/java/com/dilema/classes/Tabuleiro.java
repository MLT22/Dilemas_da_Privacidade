package com.dilema.classes;

import com.dilema.telas.TelaTabuleiro;

import javafx.scene.image.ImageView;

public class Tabuleiro {
    private int tamanhoPixel = TelaTabuleiro.getTilesize();

    private int[] posicTabuleiroX = {1, 2, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 10, 10, 10, 10, 10, 11, 12, 12, 12, 12, 12, 12, 13, 14, 14, 14, 14, 14, 14, 15, 16, 16, 16, 16, 16, 16, 17, 18};
    private int[] posicTabuleiroY = {2, 2, 3, 4, 5, 6, 7, 7, 7, 6, 5, 4, 3, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 6, 5, 4, 3, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 6, 5, 4, 3, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 6, 5, 4, 3, 2, 2, 2};
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
                    System.out.println("Verificador: " + posicFinal);
                    fimVerificacao.run();
                });
            } else {
                posicFinal = posic;
                fimVerificacao.run();
            }
        }
        
    }
}