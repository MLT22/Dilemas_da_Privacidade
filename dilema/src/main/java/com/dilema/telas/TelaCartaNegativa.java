package com.dilema.telas;

import com.dilema.dbcartas.InfoCarta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaCartaNegativa extends Application {
    private int numCasas; 
    private Runnable fimCarta;

    private String hist;
    private String just;

    public TelaCartaNegativa(int numCasas ,Runnable fimCarta) {
        this.numCasas = numCasas; 
        this.fimCarta = fimCarta;

        InfoCarta informacaoCarta = new InfoCarta();
        informacaoCarta.obterConteudo(2);
        hist = informacaoCarta.getHist();
        just = informacaoCarta.getJust();

    }


    @Override
    public void start(Stage primaryStage) {
        

        // Define o estilo da janela para não ter decoração (sem barra de título)
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Cria o VBox
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.getStyleClass().add("carta-negativa-vbox-style");

        // Cria o label "Carta Positiva"
        Label cartaPositivaLabel = new Label("Carta Negativa");
        cartaPositivaLabel.getStyleClass().add("carta-negativa-label");
        cartaPositivaLabel.setTranslateX(105);

        // Conteúdo da carta
        VBox cartaContent = new VBox();
        cartaContent.setSpacing(5);
        cartaContent.getStyleClass().add("carta-negativa-content");

        Text histCarta = new Text(hist);
        Text justCarta = new Text("\n" + just);
        Text avancarCasas = new Text("\nRetorne: " + numCasas + " casas");

        TextFlow corretorTexto = new TextFlow();
        corretorTexto.getChildren().addAll(histCarta, justCarta, avancarCasas);

        cartaContent.getChildren().addAll(corretorTexto);

        // Cria o botão "Fechar"
        Button fecharButton = new Button("Fechar");
        fecharButton.getStyleClass().add("carta-negativa-botao-style");
        fecharButton.setTranslateX(140);
        
        
        fecharButton.setOnAction(e ->{
            primaryStage.close();
            fimCarta.run();
        });

        // Adiciona os elementos ao VBox
        vbox.getChildren().addAll(cartaPositivaLabel, cartaContent, fecharButton);

        // Cria a cena
        Scene scene = new Scene(vbox, 400, 410);

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