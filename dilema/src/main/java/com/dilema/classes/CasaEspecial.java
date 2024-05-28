package com.dilema.classes;

public class CasaEspecial {
    private int [] posicCasaEspecial = {5,11,18,22,27,32,37,41,46,51};
    boolean casaEspecial;

    public boolean verificarCasaEspecial(int posic){
        for (int i : posicCasaEspecial){
            if (posic == i){
                casaEspecial = true;
                break;
            }
            else{
                casaEspecial = false;
            }
        }
        return casaEspecial;
    }
    public void cartaEspecial(){
        Sorteador sorteador = new Sorteador();
        int tipoCarta;
        tipoCarta = sorteador.sortearCasaEspecial();

        switch (tipoCarta) {
            case 1:
                
                break;
            case 2:

                break;
        }


    }

}
