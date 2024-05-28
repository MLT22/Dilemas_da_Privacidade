package com.dilema.classes;

import com.dilema.telas.TelaTabuleiro;

public class Tabuleiro {

    
    private int tamanhoPixel = TelaTabuleiro.getTilesize();
   
    private int [] posicTabuleiroX = {1,2,2,2,2,2,2,3,4,4,4,4,4,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,10,10,10,10,10,11,12,12,12,12,12,12,13,14,14,14,14,14,14,15,16,16,16,16,16,16,17,18};
    private int [] posicTabuleiroY = {2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2,3,4,5,6,7,7,7,6,5,4,3,2,2,2};
     

    public int getIndexPosicTabuleiroX(int index) {
        return posicTabuleiroX[index];
    }
    public int getIndexPosicTabuleiroY(int index) {
        return posicTabuleiroY[index];
    }
    public int getLength(){
        return posicTabuleiroX.length;
    }
  


    public int colocarPlayerX ( int posicao){
        return converteQuadrado(getIndexPosicTabuleiroX(posicao));
    }
    public int colocarPlayerY ( int posicao){
        return converteQuadrado(getIndexPosicTabuleiroY(posicao));
    }



    public int convertePontoCentral(int posicaoX){
        return (tamanhoPixel / 2) + (tamanhoPixel * posicaoX);
    }
    public int converteQuadrado(int posicaoX){
        return (tamanhoPixel * posicaoX) + 10;
    }
    
    public int verificarCasa(int posic){
        int posicFinal = 0;
        if (posic == getLength() - 1){
            System.out.println("Venceu");
        }
        else{
            CasaEspecial casaEspecial = new CasaEspecial();
            
            // verirfiacar se a posicX do player faz parte da lista das casas especiais
            if (casaEspecial.verificarCasaEspecial(posicFinal)){
                
            }
            if (posicFinal == 0) {
                posicFinal = posic;
            }
            System.out.println("Vai parar na casa:"+ posicFinal);
        }
        return posicFinal;
        
    }
    public int casaEspecial(int posicX){
        Sorteador sorteador = new Sorteador();
        int tipoCasa = sorteador.sortearCasaEspecial();
        switch (tipoCasa) {
            case 1:{
                int casaAndar = sorteador.sortearNumCasas();
                posicX += casaAndar;
                System.out.println("Casa do tipo: Positiva");
                System.out.println("Ande: " + casaAndar);
                break;
            }
            case 2:{
                int casaAndar = sorteador.sortearNumCasas(); 
                posicX -= sorteador.sortearNumCasas();
                System.out.println("Casa do tipo: Negativa");
                System.out.println("Volte: " + casaAndar);
                break;
            }


        }
        return posicX;

    }


}
