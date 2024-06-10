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

public class TelaComoJogar extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage tutorialStage)throws Exception {
        Label explica = new Label();
        explica.setAlignment(Pos.TOP_LEFT);
        explica.setText(
            "Nesse jogo iremos ver como as Leis Gerais de Proteção de Dados, também conheci" +
            "das como LGPD, estão presentes em nossas vidas seja de maneira positiva ou até" +
            " punitiva,onde nesse jogo ganha quem chega no final do tabuleiro. \nApós clica" +
            "r em jogar clique no botão no canto superior direito para adicionar jogadores," +
            " de para eles um peão e um nome sem repetir nomes, após configurar todos os jo" +
            "gadores, clique no botão jogar dado para andar, ganha quem chegar no final pri" +
            "meiro, ao cair nas casas azuis pode ser que ocorra um evento ruim ou bom, que pode fazer voçe voltar ou avançar casas"
        );
        explica.setStyle("-fx-background-color:white;-fx-border-color:blue");
        explica.setFont(Font.font("Times New Roman", 20));
        explica.setWrapText(true);

        Button exit = new Button("Voltar");
        exit.setAlignment(Pos.CENTER);
        // exit.setMinHeight(50); exit.setMinWidth(100);
        exit.setMinSize(95, 45);
        exit.setFont(Font.font("Times New Roman", 25));

        exit.setOnAction(event -> {
            try {
                TelaInicio telaInicio = new TelaInicio();
                Stage atras = new Stage();
                telaInicio.start(atras);
                tutorialStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        VBox junta = new VBox(5);
        junta.setAlignment(Pos.CENTER);
        junta
            .getChildren()
            .addAll(explica, exit);

        BorderPane painel = new BorderPane();
        Image img = new Image(
            getClass().getResourceAsStream("/com/dilema/Imagens/background/fundao1.png")
        );
        ImageView bgImage = new ImageView(img);
        bgImage.setFitWidth(600);
        bgImage.setFitHeight(500);
        bgImage.setPreserveRatio(false);
        painel
            .getChildren()
            .add(bgImage);
        painel.setTop(explica);
        painel.setBottom(exit);

        Scene cena = new Scene(painel, 600, 500);
        tutorialStage.setTitle("Dilemas da Privacidade; Como jogar");
        tutorialStage.setScene(cena);
        tutorialStage.show();
        tutorialStage.setResizable(false);

    }
}
