package com.dilema.telas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaConfigurarJogador extends Application{
  
  private int playerCount = 0;
  private static final int MAX_JOGADORES = 4;
  private static final int MIN_JOGADORES = 2;
  private final Map<String, Image> corPeoes = new HashMap<>();
  private final Set<String> coresSelecionadas = new HashSet<>();
  private Label cont;
  private Button jogarButton;

  @Override
  public void start(Stage configurarStage) throws Exception {
    corPeoes.put("Amarelo", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/amarelo.png")));
    corPeoes.put("Ciano", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/ciano.png")));
    corPeoes.put("Laranja", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/laranja.png")));
    corPeoes.put("Roxo", new Image(getClass().getResourceAsStream("/com/dilema/Imagens/peoes/roxo.png")));

    Label infor = new Label();
    infor.setText("Clique no botão '+' para adicionar mais jogadores, sendo no mínimo 2 e no máximo 4.");
    infor.setFont(Font.font("Times New Roman", 17));
    infor.setWrapText(true);
    
    Label cont = new Label("Quantidade de jogadores:" + playerCount);
    cont.setFont(Font.font("Times New Roman", 15));
    cont.setWrapText(true);

    HBox cabeca = new HBox(20);
    cabeca.setAlignment(Pos.CENTER);
    cabeca.getChildren().addAll(infor, cont);

    Button addButton = new Button("+");
    HBox addButtonContainer = new HBox(addButton);
    addButtonContainer.setAlignment(Pos.CENTER);
    addButtonContainer.setMaxSize(50, 50);
    addButtonContainer.setMinSize(50, 50);
    addButtonContainer.setStyle("-fx-border-color: black; -fx-alignment: center;");

    jogarButton = new Button("Jogar");
    jogarButton.setDisable(true);
    jogarButton.setFont(Font.font("Times New Roman"));
    HBox footer = new HBox(jogarButton);
    footer.setAlignment(Pos.CENTER_RIGHT);
    footer.setStyle("-fx-padding: 10;");

    VBox mainLayout = new VBox(10);
    mainLayout.setAlignment(Pos.CENTER);
    
    HBox jogadoresContainer = new HBox(10);
    jogadoresContainer.setAlignment(Pos.CENTER);

    mainLayout.getChildren().addAll(cabeca, jogadoresContainer, addButton, footer);
    // VBox conteudo = new VBox(10, cabeca, mainLayout);
    // conteudo.setAlignment(Pos.CENTER);
    // BorderPane corpo = new BorderPane();
    // corpo.setCenter(conteudo);
    // corpo.setBottom(footer);

    Scene preparar = new Scene(mainLayout, 800, 600);
    configurarStage.setTitle("Dilemas da Privacidade: Configurar jogador");
    configurarStage.setScene(preparar);
    configurarStage.show();

    addButton.setOnAction(event -> {
      if(playerCount >= MAX_JOGADORES){
        return;
      }
      criarNovoJogadorLayout(jogadoresContainer);
      addButtonContainer.setVisible(false);
    });
}
  private void criarNovoJogadorLayout(HBox jogadoresContainer){
    if(playerCount >= MAX_JOGADORES){
      return;
    }

    ImageView mostrar = new ImageView();

    ChoiceBox<String> escolha1 = new ChoiceBox<>();

    for (String cor : corPeoes.keySet()){
      if(!coresSelecionadas.contains(cor)){
        escolha1.getItems().add(cor);
      }
    }

    TextField nomeJogador = new TextField();
    nomeJogador.setPromptText("Digite o nome do jogador: ");

    escolha1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      mostrar.setImage(corPeoes.get(newValue));
    });

    Button okButton = new Button("Ok");

    VBox jogadorContainer = new VBox(10, mostrar, escolha1, nomeJogador, okButton);
    jogadorContainer.setStyle("-fx-border-color: black; -fx-padding: 10;");
    jogadorContainer.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    
    jogadoresContainer.getChildren().add(jogadorContainer); 

    okButton.setOnAction(event ->{
      if(escolha1.getValue() != null && !nomeJogador.getText().isEmpty()){
        coresSelecionadas.add(escolha1.getValue());

        String selecionadaCor = escolha1.getValue();
        for(int i =0; i < jogadoresContainer.getChildren().size(); i++){
          if(jogadoresContainer.getChildren().get(i) instanceof VBox){
            VBox existingContainer = (VBox) jogadoresContainer.getChildren().get(i);
            ChoiceBox<String> existingChoiceBox = (ChoiceBox<String>) existingContainer.getChildren().get(1);
            existingChoiceBox.getItems().remove(selecionadaCor);
          }
        }
        playerCount++;
        cont.setText("Quantidade de jogadores: " + playerCount);
        if (playerCount >= MIN_JOGADORES) {
          jogarButton.setDisable(false);
        }
        if (playerCount < MAX_JOGADORES){
          criarNovoJogadorLayout(jogadoresContainer);
        }
      }
    });

  }

  public static void main(String[] config) {
    launch(config);
  }
}