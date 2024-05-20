package com.dilema;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class DiceRoleTabuleiro extends Application {


    public Label resultadoDado;

    // Escolhendo o tamanho do tabulero
    public Tabulero tabulero = new Tabulero();
    public static final int tileSize = 40; // Tamanhao de cada casa
    public static final int width = 20; //Largura do tabulero
    public static final int height = 10; //Altura do tabuelro
    



    // Criação dos players
    public int posicaoCirculo[][] = new int[10][10];
    public int posicaoCasaEspecial[] = new int[5];

    Player p1 = new Player(20,"pedro");
    Player p2 = new Player(20,"Eu");




    public boolean vezPlayer1 = true;
    public boolean vezPlayer2 = true;

  



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
                Tile tile = new Tile("tela");
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                tileGroup.getChildren().add(tile);
            }
        }
        for(int i = 0; i < tabulero.posicTabuleiroX.length;i++){
            Tile tile = new Tile("rota");
            tile.setTranslateX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[i]));
            tile.setTranslateY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[i]));
            tileGroup.getChildren().add(tile);
        }
        for(int i = 0; i < tabulero.posicCasaEspecial.length;i++){
            Tile tile = new Tile("casaEspecial");
            tile.setTranslateX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[tabulero.posicCasaEspecial[i]]));
            tile.setTranslateY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[tabulero.posicCasaEspecial[i]]));
            tileGroup.getChildren().add(tile);
        }


        


        // criando o botão para jogar o dado
        var botao1 = new Button("Player1");
        botao1.setTranslateX(tabulero.convertePontoCentral(0));
        botao1.setTranslateY(tabulero.convertePontoCentral(10));
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
        root.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() ==  KeyCode.Z){
                botao1.fire();
            }
        });

        var botao2 = new Button("player2");
        botao2.setTranslateX(tabulero.convertePontoCentral(2));
        botao2.setTranslateY(tabulero.convertePontoCentral(10));
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
        botaoJogo.setTranslateX(tabulero.convertePontoCentral(6));
        botaoJogo.setTranslateY(tabulero.convertePontoCentral(10));
        botaoJogo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                botaoJogo.setText("Começou o jogo");
           
            }
        });

        resultadoDado = new Label("0");
        resultadoDado.setTranslateX(tabulero.convertePontoCentral(11));
        resultadoDado.setTranslateY(tabulero.convertePontoCentral(10));

        // imagem do tabuleiro
        Image img = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/prototipo.png"));
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(height * tileSize);
        bgImage.setFitWidth(width * tileSize);

        
        
        tileGroup.getChildren().addAll(bgImage,p1.player,p2.player,botao1,botao2,botaoJogo,resultadoDado);//adicionar bgImage no inicio

        return root;
    }

  

    @Override
    public void start (Stage primaryStage) throws Exception{
        //Configuração da tela
        Scene cena = new Scene(criarTela());
        primaryStage.setTitle("Dilemas da Privacicade");
        primaryStage.setScene(cena);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
    

  
}