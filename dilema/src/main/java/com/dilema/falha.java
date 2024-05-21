package com.dilema;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class falha extends Application {

  @Override
  public void start(Stage rola) throws Exception {
    Label titulo = new Label("Dilemas da Privacidade");
    titulo.setFont(Font.font("Times New Roman", 42));
    BorderPane.setAlignment(titulo, Pos.CENTER);

    BorderPane root = new BorderPane();
    root.setCenter(titulo);

    Scene scene = new Scene(root, 600, 500);
      rola.setTitle("Dilemas da Privacidade: Tela Inicial");
      rola.setScene(scene);
      rola.show();
  }
  public static void main(String[] pinto) {
    launch(pinto);
  }
  
}
