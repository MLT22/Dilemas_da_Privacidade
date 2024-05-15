package com.dilema;



import java.util.Random;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class DiceRoleTabuleiro extends Application {


    public Label resultadoDado;

    // Escolhendo o tamanho do tabulero
    public static final int tileSize = 40; // Tamanhao de cada casa
    public static final int width = 10; //Largura do tabulero
    public static final int height = 10; //Altura do tabuelro
    public Tabulero tabulero = new Tabulero();

    // Criação dos players
    public int posicaoCirculo[][] = new int[10][10];
    public int posicaoCasaEspecial[] = new int[5];

    Player p1 = new Player(20,"pedro");
    Player p2 = new Player(20,"Eu");




    public boolean vezPlayer1 = true;
    public boolean vezPlayer2 = true;

  


    public int posC1 = 1;
    public int posC2 = 1;



    //começar o jogo
    public boolean comecouJogo = true;
    public Button botaoJogo;
    
    private Group tileGroup = new Group();
    
    private Parent criarTela(){//Criando a tela com o número de casa (width * height) com cada casa com 80 pixels de largura e comprimento
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, (height * tileSize) + 80);
        root.getChildren().addAll(tileGroup);

        for(int i = 0 ; i < height; i++){
            for (int j = 0; j < width; j++) {
                // Mostrando o tabuleiro na tela
                Tile tile = new Tile(tileSize,tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                tileGroup.getChildren().add(tile);
            }
        }


        // criando o botão para jogar o dado
        var botao1 = new Button("Player1");
        botao1.setTranslateX(80);
        botao1.setTranslateY(420);
        botao1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(comecouJogo){
                    if(vezPlayer1){
                        p1.andarCasas();
                        resultadoDado.setText("" + p1.numTeste);
                    }
                }
            }
        });

        var botao2 = new Button("player2");
        botao2.setTranslateX(400);
        botao2.setTranslateY(420);
        botao2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(comecouJogo){
                    if(vezPlayer1){

                    }
                }
            }
        });
        botaoJogo = new Button("Começar jogo");
        botaoJogo.setTranslateX(280);
        botaoJogo.setTranslateY(420);
        botaoJogo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                botaoJogo.setText("Começou o jogo");
           
            }
        });

        resultadoDado = new Label("0");
        resultadoDado.setTranslateX(150);
        resultadoDado.setTranslateY(440);

        // imagem do tabuleiro
        // Image img = new Image("xxxx");
        // ImageView bgImage = ImagemView();
        // bgImage.setImage(img);
        // bgImage.setFitHeight(800);
        // bgImage.setFitwidth(800);

        
        
        tileGroup.getChildren().addAll(p1.player,p2.player,botao1,botao2,botaoJogo,resultadoDado);//adicionar bgImage no inicio

        return root;
    }




   



    private int getRand(){//pegar o numero do dado
        var dado = new Random();
        rand = dado.nextInt(6) + 1;
        return rand;
    }

  

    @Override
    public void start (Stage primaryStage) throws Exception{
        //Configuração da tela
        Scene cena = new Scene(criarTela());
        primaryStage.setTitle("Dilemas da Privacicade");
        primaryStage.setScene(cena);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    

  
}