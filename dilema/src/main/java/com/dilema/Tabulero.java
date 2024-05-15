package com.dilema;

public class Tabulero {
    public static final int [][] TABULERO = new int[10][10];
    public int casasX = 10;
    public int casasY = 10;
    public int tamanhoPixel = 80;

    public int converteTela(int posicaoX){
        return (tamanhoPixel / 2) + (tamanhoPixel * posicaoX);
    }

}
