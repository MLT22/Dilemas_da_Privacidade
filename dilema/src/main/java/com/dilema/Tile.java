package com.dilema;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
    public Tile(String tipoQuadrado){

        if (tipoQuadrado.equals("tela")){
            setWidth(DiceRoleTabuleiro.tileSize);
            setHeight(DiceRoleTabuleiro.tileSize);
    
            setFill(Color.PINK);
            setStroke(Color.BLACK);
        }
        else if (tipoQuadrado.equals("rota")) {
            setWidth(DiceRoleTabuleiro.tileSize);
            setHeight(DiceRoleTabuleiro.tileSize);

            setFill(Color.ORANGE);
            setStroke(Color.BLACK);
        }
        else if (tipoQuadrado.equals("casaEspecial")) {
            setWidth(DiceRoleTabuleiro.tileSize);
            setHeight(DiceRoleTabuleiro.tileSize);

            setFill(Color.BLUE);
            setStroke(Color.BLACK);
        }
    }


    
    
}
