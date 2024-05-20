package com.dilema;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

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
public class TelaTabulero extends Application {


    public Label resultadoDado;

    // Escolhendo o tamanho do tabulero
    public Tabulero tabulero = new Tabulero();
    public static final int tileSize = 40; // Tamanhao de cada casa
    public static final int width = 20; //Largura do tabulero
    public static final int height = 10; //Altura do tabuelro
    



    // Criação dos players

    private List<Player> jogadores = new ArrayList<>();//lista para ver quantos player foram instanciado
    private int jogadorAtual = 0;//contador para ver de quem é a vez

    private void numeroDeJogadores (String... cores){//de acordo com o numero de cores que for colocado um Player vai ser instanciado
        for (int i = 0; i < cores.length;i++){
            jogadores.add(new Player(cores[i]));//adicionando os player a lista
        }
        if (!jogadores.isEmpty()){
            jogadores.get(0).vezJogador = true;//faz o primeiro player poder começar a jogar
        }
    }

    private void jogarVez() {

        Player jogador = jogadores.get(jogadorAtual);
        jogador.andarCasas();
        resultadoDado.setText("" + jogador.numTeste);
        jogador.vezJogador = false;

        // Passa a vez para o próximo jogador
        jogadorAtual = (jogadorAtual + 1) % jogadores.size();
        jogadores.get(jogadorAtual).vezJogador = true;
    }



  

    
    private Group tileGroup = new Group();

    
    private Parent criarTela(){//Criando a tela com o número de casa (width * height) com cada casa com 80 pixels de largura e comprimento
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, (height * tileSize) + 80);
        root.getChildren().addAll(tileGroup);

        // Mostrar grade na tela
        // for(int i = 0 ; i < height; i++){
        //     for (int j = 0; j < width; j++) {
        //         // Mostrando o tabuleiro na tela
        //         Tile tile = new Tile("tela");
        //         tile.setTranslateX(j * tileSize);
        //         tile.setTranslateY(i * tileSize);
        //         tileGroup.getChildren().add(tile);
        //     }
        // }
        // Mostrar a rota do tabulero 
        // for(int i = 0; i < tabulero.posicTabuleiroX.length;i++){
        //     Tile tile = new Tile("rota");
        //     tile.setTranslateX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[i]));
        //     tile.setTranslateY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[i]));
        //     tileGroup.getChildren().add(tile);
        // }
        //  Mostrar as casas especiais
        // for(int i = 0; i < tabulero.posicCasaEspecial.length;i++){
        //     Tile tile = new Tile("casaEspecial");
        //     tile.setTranslateX(tabulero.converteQuadrado(tabulero.posicTabuleiroX[tabulero.posicCasaEspecial[i]]));
        //     tile.setTranslateY(tabulero.converteQuadrado(tabulero.posicTabuleiroY[tabulero.posicCasaEspecial[i]]));
        //     tileGroup.getChildren().add(tile);
        // }
        

        // criando um num de jogadores
        numeroDeJogadores("amarelo.png", "ciano.png","laranja.png");
        


        // criando o botão para jogar o dado
        var botaoJogar = new Button("Jogar dado");
        botaoJogar.setTranslateX(tabulero.convertePontoCentral(0));
        botaoJogar.setTranslateY(tabulero.convertePontoCentral(10));
        botaoJogar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
            jogarVez();
            }
        });
        root.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() ==  KeyCode.Z){
                botaoJogar.fire();
            }
        });



        // Número tirado no dado
        resultadoDado = new Label("0");
        resultadoDado.setTranslateX(tabulero.convertePontoCentral(11));
        resultadoDado.setTranslateY(tabulero.convertePontoCentral(10));

        // imagem do tabuleiro
        Image img = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/prototipo.png"));
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(height * tileSize);
        bgImage.setFitWidth(width * tileSize);

        // Adiciona elementos à tela
        tileGroup.getChildren().add(bgImage); // Adiciona a imagem do tabuleiro
        for (Player jogador : jogadores) { // Adiciona os jogadores ao grupo
            tileGroup.getChildren().add(jogador.player);
        }
        tileGroup.getChildren().addAll(botaoJogar, resultadoDado); // Adiciona o botão e o label de resultado

        return root;
    }

  

    @Override
    public void start (Stage primaryStage) throws Exception{
        //Configuração da tela
        Scene cena = new Scene(criarTela(),width * tileSize, (height * tileSize) + 80);
        primaryStage.setTitle("Dilemas da Privacicade");
        primaryStage.setScene(cena);
        primaryStage.show();
        // primaryStage.setFullScreen(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
    

  
}