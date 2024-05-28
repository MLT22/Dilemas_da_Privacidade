package com.dilema.telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CartaPositivaScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        

        // Define o estilo da janela para não ter decoração (sem barra de título)
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Cria o VBox
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.getStyleClass().add("vbox-style");

        // Cria o label "Carta Positiva"
        Label cartaPositivaLabel = new Label("Carta Positiva");
        cartaPositivaLabel.getStyleClass().add("carta-positiva-label");
        cartaPositivaLabel.setTranslateX(80);

        // Cria uma TextArea para o conteúdo da carta
        TextArea cartaContent = new TextArea();
        cartaContent.setPrefSize(300, 200);
        cartaContent.getStyleClass().add("carta-content");

        // Cria o botão "Fechar"
        Button fecharButton = new Button("Fechar");
        fecharButton.getStyleClass().add("button-style");
        fecharButton.setTranslateX(120);
        
        
        fecharButton.setOnAction(e -> primaryStage.close());

        // Adiciona os elementos ao VBox
        vbox.getChildren().addAll(cartaPositivaLabel, cartaContent, fecharButton);

        // Cria a cena
        Scene scene = new Scene(vbox, 350, 400);

        // Adiciona o arquivo CSS à cena
        scene.getStylesheets().add(getClass().getResource("/com/dilema/css/cartaPositiva.css").toExternalForm());

        // Define a cena no palco
        primaryStage.setScene(scene);

        // Mostra o palco
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}