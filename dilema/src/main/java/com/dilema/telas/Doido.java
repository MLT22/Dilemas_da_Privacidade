package com.dilema.telas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Doido extends Application {

    private int jogadorCount = 0;
    private static final int MAX_JOGADORES = 4;
    private final Map<String, Image> corPeoes = new HashMap<>();
    private final Set<String> coresSelecionadas = new HashSet<>();

    @Override
    public void start(Stage lulaStage) throws Exception {
        // Map para armazenar as imagens
        corPeoes.put("Rosa", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/amarelo.png")));
        corPeoes.put("Ciano", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/ciano.png")));
        corPeoes.put("Laranja", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/laranja.png")));
        corPeoes.put("Verde", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/roxo.png")));

        // Inicialmente, um botão "+" dentro de um retângulo
        Button addButton = new Button("+");
        HBox addButtonContainer = new HBox(addButton);
        addButtonContainer.setMaxSize(50, 50);
        addButtonContainer.setMinSize(50, 50);
        addButtonContainer.setStyle("-fx-border-color: black; -fx-alignment: center;");

        // Layout principal
        HBox mainLayout = new HBox(10);
        mainLayout.getChildren().add(addButtonContainer);

        // Scene and Stage setup
        Scene scene = new Scene(mainLayout, 800, 600);
        lulaStage.setTitle("Dilemas da Privacidade: Configurar jogador");
        lulaStage.setScene(scene);
        lulaStage.show();

        // Listener para o botão "+"
        addButton.setOnAction(event -> {
            criarNovoJogadorLayout(mainLayout, corPeoes, coresSelecionadas);
            mainLayout.getChildren().remove(addButtonContainer);
        });
    }

    private void criarNovoJogadorLayout(HBox mainLayout, Map<String, Image> corPeoes, Set<String> coresSelecionadas) {
        if (jogadorCount >= MAX_JOGADORES) {
            return; // Limitar a 4 jogadores
        }

        // ImageView para mostrar a imagem selecionada
        ImageView imageView = new ImageView();
        
        // ChoiceBox para escolher a cor
        ChoiceBox<String> escolha1 = new ChoiceBox<>();
        for (String cor : corPeoes.keySet()) {
            if (!coresSelecionadas.contains(cor)) {
                escolha1.getItems().add(cor);
            }
        }

        // TextField para o nome do jogador
        TextField nomeField = new TextField();
        nomeField.setPromptText("Digite o nome do jogador");

        // Listener para atualizar a imagem conforme a seleção
        escolha1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            imageView.setImage(corPeoes.get(newValue));
        });

        // Botão "blob" para confirmar a seleção e adicionar um novo layout
        Button blobButton = new Button("blob");
        
        // Container para os campos do jogador com borda fina preta
        VBox jogadorContainer = new VBox(10, imageView, escolha1, nomeField, blobButton);
        jogadorContainer.setStyle("-fx-border-color: black; -fx-padding: 10;");
        
        // Adiciona o container do jogador ao layout principal
        mainLayout.getChildren().add(jogadorContainer);

        blobButton.setOnAction(event -> {
            if (escolha1.getValue() != null && !nomeField.getText().isEmpty()) {
                // Adicionar a cor selecionada ao conjunto de cores selecionadas
                coresSelecionadas.add(escolha1.getValue());

                // Remover a opção escolhida do ChoiceBox de futuros containers
                String selectedColor = escolha1.getValue();
                for (int i = 0; i < mainLayout.getChildren().size(); i++) {
                    if (mainLayout.getChildren().get(i) instanceof VBox) {
                        VBox existingContainer = (VBox) mainLayout.getChildren().get(i);
                        ChoiceBox<String> existingChoiceBox = (ChoiceBox<String>) existingContainer.getChildren().get(1);
                        existingChoiceBox.getItems().remove(selectedColor);
                    }
                }
                criarNovoJogadorLayout(mainLayout, corPeoes, coresSelecionadas);
                jogadorCount++;
            }
        });
    }

    public static void main(String[] bolso) {
        launch(bolso);
    }
}

