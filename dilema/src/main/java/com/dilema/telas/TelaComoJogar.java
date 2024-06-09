package com.dilema.telas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaComoJogar extends Application{
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage tutorialStage) throws Exception {
    Label explica = new Label();
    explica.setAlignment(Pos.TOP_LEFT);
    explica.setText("Nesse jogo iremos ver como as Leis Gerais de Proteção de Dados, também conhecidas como LGPD, estão presentes em nossas vidas seja de maneira positiva ou até punitiva,onde nesse jogo ganha quem chega no final do tabuleiro. \nApós clicar em jogar clique no botão no canto superior direito para adicionar jogadores, de para eles um peão e um nome sem repetir nomes, após configurar todos os jogadores, clique no botão jogar dado para andar, ganha quem chegar no final primeiro");
    explica.setMinWidth(600);
    explica.setMinHeight(450);
    explica.setFont(Font.font("Times New Roman", 20));
    explica.setWrapText(true);


    Button exit = new Button("Voltar");
      exit.setAlignment(Pos.CENTER);
      // exit.setMinHeight(50);
      // exit.setMinWidth(100);
      exit.setMinSize(95, 45);
      exit.setFont(Font.font("Times New Roman", 25));

      exit.setOnAction(event -> {
        try {
          TelaInicio telaInicio = new TelaInicio();
          Stage atras = new Stage();
          telaInicio.start(atras);
          tutorialStage.close();
        }catch (Exception e) {
          e.printStackTrace();
        }
      });

      VBox junta = new VBox(5);
      junta.setAlignment(Pos.CENTER);
      junta.getChildren().addAll(explica, exit);

    BorderPane painel = new BorderPane();
      painel.setTop(explica);
      painel.setBottom(exit);

    Scene cena = new Scene(painel, 600, 500);
      tutorialStage.setTitle("Dilemas da Privacidade; Como jogar");
      tutorialStage.setScene(cena);
      tutorialStage.show();
      tutorialStage.setResizable(false);


  }
}
