import java.util.Random;
import java.util.Scanner;

public class Players {
    String [] tabuleiroJogo = Tabuleiro.criarTabuleiro();
    int posicPlayer = 0;
    String player1 = "x";
    
    void criarPesonagem(){
        tabuleiroJogo[posicPlayer] = player1; //colocando o player na primeira casa do tabuleiro (index 0 do tabuleiro)
        for(String i : tabuleiroJogo){
            System.out.print(i + "|");
        }
    }
    int jogarDado(){// sortear um número aleatório entre 1 e 6
       var dado = new Random();
       int numDado = dado.nextInt(5) + 1;
       return numDado;
    }

    void andarCasas(){
        var sc = new Scanner(System.in);
        System.out.println("\nPrecione qual quer coisa para continuar");// pedir ao usuario para continuar
        sc.nextLine();

        int dado = jogarDado();// Pegar o valor do dado;
        int posicInicial = posicPlayer;// guardar a posição do player
        String guardarCasa = tabuleiroJogo[posicPlayer + 1]; // variavel que vai quardar o valor da casa que o player vai passar
        System.out.println("O p1 vai andar: " + dado);
        while(posicPlayer < posicInicial + dado){
            if(posicPlayer == 0){// caso o playes esteja na primeira casa vai rescrever o valor no index(0) para "Inicio"
                tabuleiroJogo[posicPlayer] = "Inicio";
                posicPlayer += 1; // Fazer o player andar 1 casa
                tabuleiroJogo[posicPlayer] = player1;
                
            }
            else{
                if(posicPlayer < tabuleiroJogo.length - 1){
                    
                    tabuleiroJogo[posicPlayer] = guardarCasa; // reescreve o valor da casa onde o player estava para o valor antigo da casa
                    posicPlayer++; // faz o player andar 1 casa
                    guardarCasa = tabuleiroJogo[posicPlayer];// guarda o valor da casa que o player vai passar
                    tabuleiroJogo[posicPlayer] = player1;
                    
                }
                else{// verifica se o player chegou na ultima casa do tabuleiro
                    System.out.println("\n O player venceu");
                    break;
                }
            }
            System.out.println("\n");// mostra o tabuleiro acada vez que o personagem anda
            System.out.println("----------------------------------------------------------------------");
            for(String i : tabuleiroJogo){
                System.out.print(i+"|");
            }
        }

        sc.close();
    }
    
}
