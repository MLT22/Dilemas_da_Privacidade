package com.dilema.telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaCartaPositiva extends Application {
    private int numCasas; 
    private Runnable fimCarta;

    public TelaCartaPositiva(int numCasas, Runnable fimCarta) {
        this.numCasas = numCasas; 
        this.fimCarta = fimCarta;
    }

    @Override
    public void start(Stage primaryStage) {
        // Configuração da janela
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Cria o VBox da Carta
        VBox carta = new VBox();
        carta.setSpacing(20);
        carta.getStyleClass().add("carta-positiva-vbox-style");

        // Título "Carta Positiva"
        Label cartaPositivaLabel = new Label("Carta Positiva");
        cartaPositivaLabel.getStyleClass().add("carta-positiva-label");
        cartaPositivaLabel.setTranslateX(80);

        // Conteúdo da carta
        VBox cartaContent = new VBox();
        cartaContent.setSpacing(5);
        cartaContent.getStyleClass().add("carta-positiva-content");

        Text histCarta = new Text("Históriaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Text justCarta = new Text("\nPoisfkaslfjaslsfjaldflajlfasdfalsfasjfaksjflsajlfkjçkl");
        Text avancarCasas = new Text("\nAvance: " + numCasas + " casas"); // Usando a variável de instância

        TextFlow corretorTexto = new TextFlow();
        corretorTexto.getChildren().addAll(histCarta, justCarta, avancarCasas);

        cartaContent.getChildren().addAll(corretorTexto);

        // Botão "Fechar"
        Button fecharButton = new Button("Fechar");
        fecharButton.getStyleClass().add("carta-positiva-botao-style");
        fecharButton.setTranslateX(120);
        fecharButton.setOnAction(e ->{
            primaryStage.close();
            fimCarta.run();
        });

        // Adiciona os elementos à Carta
        carta.getChildren().addAll(cartaPositivaLabel, cartaContent, fecharButton);

        // Cria a cena
        Scene scene = new Scene(carta, 350, 400);

        // Adiciona o arquivo CSS à cena
        scene.getStylesheets().add(getClass().getResource("/com/dilema/css/cartas.css").toExternalForm());

        // Define a cena no palco
        primaryStage.setScene(scene);

        // Mostra o palco
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}