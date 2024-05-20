package com.dilema;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
    public Tile(String tipoQuadrado){

        if (tipoQuadrado.equals("tela")){
            setWidth(TelaTabulero.tileSize);
            setHeight(TelaTabulero.tileSize);
    
            setFill(Color.PINK);
            setStroke(Color.BLACK);
        }
        else if (tipoQuadrado.equals("rota")) {
            setWidth(TelaTabulero.tileSize);
            setHeight(TelaTabulero.tileSize);

            setFill(Color.ORANGE);
            setStroke(Color.BLACK);
        }
        else if (tipoQuadrado.equals("casaEspecial")) {
            setWidth(TelaTabulero.tileSize);
            setHeight(TelaTabulero.tileSize);

            setFill(Color.BLUE);
            setStroke(Color.BLACK);
        }
    }


    
    
}
