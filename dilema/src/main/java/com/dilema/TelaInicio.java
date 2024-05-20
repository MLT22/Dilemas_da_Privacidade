package com.dilema;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaInicio  extends Application{

  @Override
  public void start(Stage primaryStage) throws Exception {
    Label titulo = new Label("Dilemas da Privacidade");
    BorderPane.setAlignment(titulo, Pos.CENTER);

    Button jogar = new Button("Jogar");
    Button comojogar = new Button("Como Jogar");
    Button sair = new Button("Sair");
    Button cartas = new Button("Configurar Cartas");

    HBox meio = new HBox(50);
      meio.setAlignment(Pos.CENTER_LEFT);
      meio.getChildren().addAll(cartas, comojogar);

    VBox buttonBox = new VBox(20);
      buttonBox.setAlignment(Pos.CENTER);
      buttonBox.getChildren().addAll(jogar, meio, sair);

    VBox tudo = new VBox(20);
      tudo.setAlignment(Pos.CENTER);
      tudo.getChildren().addAll(titulo, buttonBox);

    BorderPane root = new BorderPane();
    root.setCenter(tudo);
    
    Scene scene = new Scene(root, 400, 300);
      primaryStage.setTitle("Dilemas da Privacidade: Tela Inicial");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
