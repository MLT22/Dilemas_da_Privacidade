package com.dilema.telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class TelaVitoria extends Application {
    private String nome;
    private String cor;
    private Stage telaTabuleiro;
 

    // Construtor que aceita o Stage de TelaTabuleiro
    public TelaVitoria(String nome,String cor,Stage telaTabuleiro) {
        this.nome = nome;
        this.cor = cor;
        this.telaTabuleiro = telaTabuleiro;
        
    }


     @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);

        VBox telaVitoria = new VBox();
        telaVitoria.setSpacing(20);
        telaVitoria.getStyleClass().add("tela-vitoria-vbox-style");

        //Titulo
        Label titulo = new Label("Vitória");
        titulo.setTranslateX(110);
        titulo.getStyleClass().add("titulo-label");

        VBox conteudo = new VBox();
        conteudo.prefWidth(100);
        conteudo.getStyleClass().add("conteudo-vbox");
        
        // Imagem do player vencedor
        Image imagemPlayer = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/" + cor + ".png"));
        ImageView playerVencedor = new ImageView(imagemPlayer);
        playerVencedor.setFitHeight(100);
        playerVencedor.setPreserveRatio(true);
        playerVencedor.setTranslateX(120);

        // Texto de parabens
        Text parabens = new Text("Parabens pela vitória " + nome +"!");
        parabens.getStyleClass().add("conteudo-text");

        conteudo.getChildren().addAll(playerVencedor,parabens);

        // botoes
        HBox botoes = new HBox();
        botoes.setSpacing(180);
        
        Button menu = new Button("Menu");
        menu.getStyleClass().add("botoes-button");
        menu.setOnAction(event ->{
            try {
                TelaInicio telaInicio = new TelaInicio();
                Stage newStage = new Stage();
                telaInicio.start(newStage);
                
                telaTabuleiro.close();
                
                primaryStage.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }); 
        
        Button sair = new Button("Sair");
        sair.getStyleClass().add("botoes-button");
        sair.setOnAction(event -> {
            primaryStage.close();
            telaTabuleiro.close();
        });

        botoes.getChildren().addAll(menu,sair);

        telaVitoria.getChildren().addAll(titulo,conteudo,botoes);
     
        Scene scene = new Scene(telaVitoria, 400, 410);

       
        scene.getStylesheets().add(getClass().getResource("/com/dilema/css/telaVitoria.css").toExternalForm());

      
        primaryStage.setScene(scene);

      
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}