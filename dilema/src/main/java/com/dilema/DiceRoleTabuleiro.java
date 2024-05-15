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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class DiceRoleTabuleiro extends Application {

    public int rand;
    public Label randResult;

    // Escolhendo o tamanho do tabulero
    public static final int tileSize = 80; // Tamanhao de cada casa
    public static final int width = 10; //Largura do tabulero
    public static final int height = 10; //Altura do tabuelro
    public Tabulero tabulero = new Tabulero();

    // Criação dos players
    public int posicaoCirculo[][] = new int[10][10];
    public int posicaoCasaEspecial[] = new int[5];

    public Circle player1;
    public Circle player2;

    public int posicaoPlayer1 = 1;
    public int posicaoPlayer2 = 1;

    public boolean vezPlayer1 = true;
    public boolean vezPlayer2 = true;

    // posiçao em relação ao plano carteziano do tabuleiro
    public static int xPosicPlayer1 = 0;//posição x do player
    public static int yPosicPlayer1 = 9;//posiçao y do player // 740 para ficar no centro da ultica linha do tabuleiro  
    
    public static int xPosicPlayer2 = 0;
    public static int yPosicPlayer2 = 9;

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

        // criando o circulo dos players
        player1 = new Circle(40);
        player1.setId("player1");
        player1.getStyleClass().add("style.css");
        player1.setTranslateX(tabulero.converteTela(xPosicPlayer1 + 1));
        player1.setTranslateY(tabulero.converteTela(yPosicPlayer1 - 1));
        
        player2 = new Circle(40);
        player2.setId("player2");
        player2.getStyleClass().add("style.css");
        player2.setTranslateX(tabulero.converteTela(xPosicPlayer2));
        player2.setTranslateY(tabulero.converteTela(yPosicPlayer2));
        
        

        // criando o botão para jogar o dado
        var botao1 = new Button("Player1");
        botao1.setTranslateX(80);
        botao1.setTranslateY(820);
        botao1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(comecouJogo){
                    if(vezPlayer1){
                        getRand();
                        randResult.setText(String.valueOf(rand));
                        

                        player1.setTranslateX(tabulero.converteTela(xPosicPlayer1));
                        player1.setTranslateY(tabulero.converteTela(yPosicPlayer1));
                    }
                }
            }
        });

        var botao2 = new Button("player2");
        botao2.setTranslateX(700);
        botao2.setTranslateY(820);
        botao2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(comecouJogo){
                    if(vezPlayer1){
                        

                        player1.setTranslateX(tabulero.converteTela(xPosicPlayer1));
                        player1.setTranslateY(tabulero.converteTela(yPosicPlayer1));
                    }
                }
            }
        });
        botaoJogo = new Button("Começar jogo");
        botaoJogo.setTranslateX(380);
        botaoJogo.setTranslateY(820);
        botaoJogo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                botaoJogo.setText("Começou o jogo");
                

                player1.setTranslateX(tabulero.converteTela(xPosicPlayer1));
                player1.setTranslateY(tabulero.converteTela(yPosicPlayer1));
                
                player2.setTranslateX(tabulero.converteTela(xPosicPlayer2));
                player2.setTranslateY(tabulero.converteTela(yPosicPlayer2));
                
            }
        });

        randResult = new Label("0");
        randResult.setTranslateX(300);
        randResult.setTranslateY(800);

        // imagem do tabuleiro
        // Image img = new Image("xxxx");
        // ImageView bgImage = ImagemView();
        // bgImage.setImage(img);
        // bgImage.setFitHeight(800);
        // bgImage.setFitwidth(800);

        
        
        tileGroup.getChildren().addAll(player1,player2,botao1,botao2,botaoJogo,randResult);//adicionar bgImage no inicio

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