package com.dilema;

public class Tabulero {

    
    public int casasX = DiceRoleTabuleiro.width;
    public int casasY = DiceRoleTabuleiro.height;
    public int tamanhoPixel = DiceRoleTabuleiro.tileSize;
   
    public int [] posicTabuleiroX = {1,2,2,2,2,2,2,3,4,4,4,4,4,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,10,10,10,10,10,11,12,12,12,12,12,12,13,14,14,14,14,14,14,15,16,16,16,16,16,16,17,18};
    public int [] posicTabuleiroY = {2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2};
    

    public int converteTela(int posicaoX){
        return (tamanhoPixel / 2) + (tamanhoPixel * posicaoX);
    }
    public int converteTela1(int posicaoX){
        return (tamanhoPixel * posicaoX);
    }


}
