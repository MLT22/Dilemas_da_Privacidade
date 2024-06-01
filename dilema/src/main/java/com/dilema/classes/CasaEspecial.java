package com.dilema.classes;

import com.dilema.animacoes.Movimento;
import com.dilema.telas.TelaCartaNegativa;
import com.dilema.telas.TelaCartaPositiva;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaEspecial {
    private int[] posicCasaEspecial = {5, 11, 18, 22, 27, 32, 37, 41, 46, 51};
    private boolean casaEspecial;
    private int posicFinal;

    public boolean verificarCasaEspecial(int posic) {
        for (int i : posicCasaEspecial) {
            if (posic == i) {
                casaEspecial = true;
                break;
            } else {
                casaEspecial = false;
            }
        }
        return casaEspecial;
    }

    public void cartaEspecial(int posic, ImageView player, Runnable fimCartaEspecial) {
        Sorteador sorteador = new Sorteador();
        int tipoCarta = sorteador.sortearCasaEspecial();
    
        switch (tipoCarta) {
            case 1: {
                Sorteador dado = new Sorteador();
                int numCasas = dado.sortearNumCasas();
                Movimento avancar = new Movimento();
    
                TelaCartaPositiva cartaPositiva = new TelaCartaPositiva(numCasas, () -> {
                    avancar.andarCasas(numCasas, posic, player, () -> {
                        posicFinal = posic + numCasas;
                        System.out.println("PosiCasaEspecial: " + posicFinal);
                        fimCartaEspecial.run();
                    });
                });
                Stage cartaStage = new Stage();
                cartaPositiva.start(cartaStage);
    
                break;
            }
            case 2: {
                Sorteador dado = new Sorteador();
                int numCasas = dado.sortearNumCasas();
                Movimento retornar = new Movimento();
                TelaCartaNegativa cartaNegativa = new TelaCartaNegativa(numCasas, () -> {
                    retornar.voltarCasas(numCasas,posic,player,() -> {
                        posicFinal = posic - numCasas;
                        fimCartaEspecial.run();
                    });
                });
                Stage cartaStage = new Stage();
                cartaNegativa.start(cartaStage);               
                break;
            }
        }
    }

    public int getPosicFinal() {
        return posicFinal;
    }
}