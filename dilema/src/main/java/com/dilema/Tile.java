package com.dilema;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
    public Tile(int x, int y){
        setWidth(DiceRoleTabuleiro.tileSize);
        setHeight(DiceRoleTabuleiro.tileSize);

        setFill(Color.PINK);
        setStroke(Color.BLACK);
    }
    public Tile(){
        setWidth(DiceRoleTabuleiro.tileSize);
        setHeight(DiceRoleTabuleiro.tileSize);

        setFill(Color.ORANGE);
        setStroke(Color.BLACK);
    }
    
}
