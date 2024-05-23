package com.dilema.telas;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaConfigurarJogador extends Application{

  @Override
  public void start(Stage configurarStage) throws Exception {
    Map<String, Image> corPeoes = new HashMap<>();
    corPeoes.put("Roxo", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/")))
    
    
    
    ChoiceBox<String> escolha1 = new ChoiceBox<>();
    escolha1.getItems().addAll("Roxo", "Azul", "Laranja", "Verde");

    BorderPane lula = new BorderPane();
    lula.setCenter(escolha1);

    Scene telta = new Scene(lula, 600, 500);
    configurarStage.setTitle("Dilemas da Privacidade: Configurar jogador");
    configurarStage.setScene(telta);
    configurarStage.show();

  }

  public static void main(String[] config) {
    launch(config);
  }
}