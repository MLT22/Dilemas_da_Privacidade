package com.dilema.telas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaConfigurarJogador extends Application {

    private int playerCount = 0;
    private static final int MAX_JOGADORES = 4;
    private static final int MIN_JOGADORES = 2;
    private final Map<String, Image> corPeoes = new HashMap<>();
    private final Set<String> coresSelecionadas = new HashSet<>();
    private Button jogarButton;
    private Button addButton;
    private final ArrayList<String> nomePlayer = new ArrayList<>();
    private final ArrayList<String> imagePlayer = new ArrayList<>();

    @Override public void start(Stage configurarStage)throws Exception {
        corPeoes.put(
            "amarelo",
            new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/amarelo.png"))
        );
        corPeoes.put(
            "ciano",
            new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/ciano.png"))
        );
        corPeoes.put(
            "laranja",
            new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/laranja.png"))
        );
        corPeoes.put(
            "roxo",
            new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/roxo.png"))
        );

        Label infor = new Label();
        infor.setText(
            "Clique no botão ao lado para adicionar mais jogadores, sendo no mínimo 2 e no " +
            "máximo 4."
        );
        infor.setFont(Font.font("Times New Roman", 20));
        infor.setWrapText(true);

        addButton = new Button("Quantidade de jogadores: " + playerCount);
        addButton.setFont(Font.font("Times New Roman", 17));
        addButton.setWrapText(true);

        HBox header = new HBox(10);
        header.setAlignment(Pos.TOP_LEFT);
        header
            .getChildren()
            .addAll(infor, addButton);

        jogarButton = new Button("Jogar");
        jogarButton.setDisable(true);
        jogarButton.setFont(Font.font("Times New Roman", 20));
        jogarButton.setOnAction(event -> {
            for(String i : nomePlayer) {
                System
                    .out
                    .println(i);
            }
            for (String i : imagePlayer) {
                System
                    .out
                    .println(i);
            }
        });

        HBox footer = new HBox(jogarButton);
        footer.setAlignment(Pos.BOTTOM_RIGHT);
        footer.setStyle("-fx-padding: 10;");

        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        HBox jogadoresContainer = new HBox(10);
        jogadoresContainer.setAlignment(Pos.CENTER);

        mainLayout
            .getChildren()
            .addAll(header, jogadoresContainer);

        addButton.setOnAction(event -> { //adiciona função do botão para adicionar mais players
            if(playerCount < MAX_JOGADORES) {
                playerCount++;
                addButton.setText("Quantidade de jogadores: " + playerCount);
                if (playerCount >= MAX_JOGADORES) {
                    addButton.setDisable(true);
                }
                criarNovoJogadorLayout(jogadoresContainer);
            }
        });

        jogarButton.setOnAction(event -> { // adiciona a funcionabilidade do botão jogar
            try {
                TelaTabuleiro telinha = new TelaTabuleiro(nomePlayer, imagePlayer);
                Stage telaTabuleiro = new Stage();
                telinha.start(telaTabuleiro);
                configurarStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        BorderPane root = new BorderPane();//adiciona a imagem de fundo
        Image img = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/background/fundo.png"));
        ImageView bgImage = new ImageView(img);
        bgImage.setFitWidth(800);
        bgImage.setFitHeight(600);
        bgImage.setPreserveRatio(false);
        root.getChildren().add(bgImage);
        root.setTop(header);
        root.setCenter(jogadoresContainer);
        root.setBottom(footer);

        Scene preparar = new Scene(root, 800, 600);
        configurarStage.setTitle("Dilemas da Privacidade: Configurar jogador");
        configurarStage.setScene(preparar);
        configurarStage.show();
        configurarStage.setResizable(false);
    }

    private void criarNovoJogadorLayout(HBox jogadoresContainer) {// método para criar a telinha que configura o player
        if (playerCount > MAX_JOGADORES) {
            return;
        }

        ImageView mostrar = new ImageView();
        mostrar.setFitWidth(70); // Ajuste o tamanho da imagem
        mostrar.setFitHeight(70); // Ajuste o tamanho da imagem
        mostrar.setStyle("-fx-border-color: black; -fx-border-width: 1;");

        ChoiceBox<String> escolha1 = new ChoiceBox<>();

        for (String cor : corPeoes.keySet()) {
            if (!coresSelecionadas.contains(cor)) {
                escolha1
                    .getItems()
                    .add(cor);
            }
        }
        Label corLabel = new Label("Escolha a cor:");
        corLabel.setFont(Font.font("Times New Roman", 17));
        corLabel.setWrapText(true);
        HBox textoMaisCor = new HBox(1);
        textoMaisCor.getChildren().addAll(corLabel, escolha1);
        TextField nomeJogador = new TextField();
        nomeJogador.setPromptText("Digite o nome do jogador: ");

        escolha1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                mostrar.setImage(corPeoes.get(newValue));
            });

        Button okButton = new Button("Ok");
        okButton.setFont(Font.font("Times New Roman"));

        VBox jogadorContainer = new VBox(
            35,
            mostrar,
            textoMaisCor,
            nomeJogador,
            okButton
        );
        jogadorContainer.setStyle("-fx-border-color: black; -fx-padding: 10;");

        jogadoresContainer.getChildren().add(jogadorContainer);

        okButton.setOnAction(event -> {
            if(escolha1.getValue() != null && !nomeJogador.getText().isEmpty()) {//adiciona função ao botão OK 
                coresSelecionadas.add(escolha1.getValue());
                nomePlayer.add(nomeJogador.getText());
                imagePlayer.add(escolha1.getValue());

                String selecionadaCor = escolha1.getValue();
                for (int i = 0; i < jogadoresContainer.getChildren().size(); i++) {
                    if (jogadoresContainer.getChildren().get(i)instanceof VBox) {
                        VBox existingContainer = (VBox)jogadoresContainer.getChildren().get(i);
                        HBox hBox = (HBox)existingContainer.getChildren().get(1);
                        ChoiceBox<String> existingChoiceBox = (ChoiceBox<String>)hBox.getChildren().get(1);
                        existingChoiceBox.getItems().remove(selecionadaCor);
                    }
                }

                if (playerCount >= MIN_JOGADORES) {
                    jogarButton.setDisable(false);
                }

                okButton.setDisable(true);
                escolha1.setDisable(true);
                nomeJogador.setDisable(true);
            }
        });
    }

    public static void main(String[] config) {
        launch(config);

    }
}
