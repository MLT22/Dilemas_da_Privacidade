package com.dilema.telas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaInicio extends Application {

    @Override public void start(Stage primaryStage)throws Exception {
        Label titulo = new Label("Dilemas da Privacidade");
        titulo.setMinHeight(150);
        titulo.setMinWidth(600);
        titulo.setFont(Font.font("Times New Roman", 60));
        titulo.setAlignment(Pos.CENTER);

        Button jogar = new Button("Jogar");
        jogar.setFont(Font.font("Times New Roman", 20));
        Button comojogar = new Button("Como Jogar");
        comojogar.setFont(Font.font("Times New Roman", 17));
        Button sair = new Button("Sair");
        sair.setFont(Font.font("Times New Roman", 20));

        Button[] buttons = {
            jogar,
            comojogar,
            sair
        };
        setButtonSize(buttons, 125, 75);
        addHoverEffect(jogar, comojogar, sair);

        comojogar.setOnAction(event -> {
            try {
                TelaComoJogar telaComoJogar = new TelaComoJogar();
                Stage newStage = new Stage();
                telaComoJogar.start(newStage);
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jogar.setOnAction(event -> {
            try {
                TelaConfigurarJogador telaConfigurarJogador = new TelaConfigurarJogador();
                Stage novaStage = new Stage();
                telaConfigurarJogador.start(novaStage);
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        sair.setOnAction(event -> {
            primaryStage.close();
        });

        VBox buttonBox = new VBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox
            .getChildren()
            .addAll(jogar, comojogar, sair);

        // VBox tudo = new VBox(100);   tudo.setAlignment(Pos.CENTER);
        // tudo.getChildren().addAll(titulo, buttonBox);

        BorderPane root = new BorderPane();

        Image img = new Image(
            getClass().getResourceAsStream("/com/dilema/Imagens/background/fundo.png")
        );
        ImageView bgImage = new ImageView(img);
        bgImage.setFitWidth(600);
        bgImage.setFitHeight(500);
        bgImage.setPreserveRatio(false);
        root
            .getChildren()
            .add(bgImage);
        root.setTop(titulo);
        root.setCenter(buttonBox);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Dilemas da Privacidade: Tela Inicial");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private void setButtonSize(Button[] buttons, double width, double height) {
        for (Button button : buttons) {
            button.setMinWidth(width);
            button.setMinHeight(height);
        }
    }
    private void addHoverEffect(Button ...buttons) {
        for (Button button : buttons) {
            button.setOnMouseEntered(event -> {
                button.setStyle("-fx-font-style: italic; -fx-underline: true;");
            });
            button.setOnMouseExited(event -> {
                button.setStyle("");
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
