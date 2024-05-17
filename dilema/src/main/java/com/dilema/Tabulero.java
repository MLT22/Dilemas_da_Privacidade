package com.dilema;

public class Tabulero {

    
    public int casasX = DiceRoleTabuleiro.width;
    public int casasY = DiceRoleTabuleiro.height;
    public int tamanhoPixel = DiceRoleTabuleiro.tileSize;
   
    public int [] posicTabuleiroX = {1,2,2,2,2,2,2,3,4,4,4,4,4,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,10,10,10,10,10,11,12,12,12,12,12,12,13,14,14,14,14,14,14,15,16,16,16,16,16,16,17,18};
    public int [] posicTabuleiroY = {2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2};
    public int [] posicCasaEspecial = {5,11,18,22,27,32,37,41,46,51};
     

    public int convertePontoCentral(int posicaoX){
        return (tamanhoPixel / 2) + (tamanhoPixel * posicaoX);
    }
    public int converteQuadrado(int posicaoX){
        return (tamanhoPixel * posicaoX);
    }
    
    public int verificarCasa(int posicX){
        int posicFinal = 0;
        for (int i : posicCasaEspecial) {
            if (posicX == i){
                posicFinal = casaEspecial(posicX);

                break;
            }
        }
        if (posicFinal == 0) {
            posicFinal = posicX;
        }
        System.out.println("Vai parar na casa:"+ posicFinal);
        return posicFinal;
        
    }
    public int casaEspecial(int posicX){
        Sorteador sorteador = new Sorteador();
        int tipoCasa = sorteador.sortearCasaEspecial();
        switch (tipoCasa) {
            case 1:
                posicX += sorteador.sortearNumCasas();
                System.out.println("Casa do tipo: Positiva");
                break;
            case 2:
                posicX -= sorteador.sortearNumCasas();
                System.out.println("Casa do tipo: Negativa");
                break;

        }
        return posicX;

    }


}
