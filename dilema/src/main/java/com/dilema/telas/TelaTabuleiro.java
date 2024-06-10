package com.dilema.telas;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import com.dilema.animacoes.Dado;
import com.dilema.classes.Player;
import com.dilema.classes.Tabuleiro;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class TelaTabuleiro extends Application {



    // Escolhendo o tamanho do tabuleiro
    private Tabuleiro tabuleiro = new Tabuleiro();
    private static final int tileSize = 50; // Tamanhao de cada casa
    private static final int width = 21; //Largura do tabulero
    private static final int height = 11; //Altura do tabuelro
    
    private ArrayList<String> nomes;
    private ArrayList<String> cores;

    private Dado dado = new Dado(700);

    public TelaTabuleiro(ArrayList<String> nomes,ArrayList<String> cores){
        this.nomes = nomes;
        this.cores = cores;
    }


    
    public static int getTilesize() {
        return tileSize;
    }
    

    // Criação dos players

    private List<Player> jogadores = new ArrayList<>();//lista para ver quantos player foram instanciado
    private int jogadorAtual = 0;//contador para ver de quem é a vez

    private void numeroDeJogadores (ArrayList<String> cores,ArrayList<String> nomes){//de acordo com o numero de cores que for colocado um Player vai ser instanciado
        for (int i = 0; i < cores.size();i++){
            jogadores.add(new Player(cores.get(i),nomes.get(i)));//adicionando os player a lista
        }
        if (!jogadores.isEmpty()){
            jogadores.get(0).setVezJogador(true);//faz o primeiro player poder começar a jogar
        }
    }

    private void jogarVez(Stage telaTabuleiro,Runnable esperaVez) {
        Player jogador = jogadores.get(jogadorAtual);
        System.out.println("Vez do: " + jogador.getNome());
        dado.animacaoDado(() -> {
            jogador.andarCasas(dado.getNumDado(),telaTabuleiro,() -> {
                jogador.setVezJogador(false);
                
                // Passa a vez para o próximo jogador
                jogadorAtual = (jogadorAtual + 1) % jogadores.size();
                jogadores.get(jogadorAtual).setVezJogador(true);
                
                // Reativar o botão apos a jogada do player
                esperaVez.run();
            });
        });

        

    }



  

    
    private Group tileGroup = new Group();
    private HBox rodaPe = new HBox();

    
    private Parent criarTela(Stage telaTabuleiro){//Criando a tela com o número de casa (width * height) com cada casa com 80 pixels de largura e comprimento
        VBox root = new VBox();
        root.setPrefSize(width * tileSize, (height * tileSize) + 90);
        root.getChildren().addAll(tileGroup, rodaPe);


        // criando um num de jogadores
        // // ArrayList<String> testec = new ArrayList<>();
        // // ArrayList<String> testen = new ArrayList<>();

        // testec.add("ciano");

        // testen.add("1");

        numeroDeJogadores(cores,nomes);

        




        // criando o botão para jogar o dado
        var botaoJogar = new Button("Jogar dado");
        botaoJogar.setTranslateX(600);
       
        
        botaoJogar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                botaoJogar.setDisable(true);
                jogarVez(telaTabuleiro,() -> {
                    botaoJogar.setDisable(false);
                });
            }
        });
        root.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() ==  KeyCode.Z){
                botaoJogar.fire();
            }
        });

        // "Roda pé"
        Text vez = new Text("É a vez do " );
        rodaPe.getChildren().addAll(botaoJogar,dado.getDado());
        rodaPe.setStyle("-fx-background-color: #E94266 ;-fx-padding: 10;-fx-font-size: 30px;");


        // imagem do tabuleiro
        Image img = new Image(getClass().getResourceAsStream("/com/dilema/Imagens/tabuleiro/tabuleiro.png"));
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(height * tileSize);
        bgImage.setFitWidth(width * tileSize);

        // Adiciona elementos à tela
        tileGroup.getChildren().add(bgImage); // Adiciona a imagem do tabuleiro
        for (Player jogador : jogadores) { // Adiciona os jogadores ao grupo
            tileGroup.getChildren().add(jogador.getPlayer());
        }
        

        return root;
    }

  

    @Override
    public void start (Stage telaTabuleiro) throws Exception{
        //Configuração da tela
        Scene cena = new Scene(criarTela(telaTabuleiro),width * tileSize, (height * tileSize) + 95);
        telaTabuleiro.setTitle("Dilemas da Privacicade");
        telaTabuleiro.setScene(cena);
        telaTabuleiro.show();


    }
    
   
    


    public static void main(String[] args) {
        launch(args);
    }
    

  
}