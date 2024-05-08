import java.util.Random;
import java.util.Scanner;

public class Players {
    String [] tabuleiroJogo = Tabuleiro.criarTabuleiro();
    
    int posicao = 0;
    String casa = "Incio";
    String nome = "x";
    
    void criarPesonagem(){
        tabuleiroJogo[posicao] = nome; //colocando o player na primeira casa do tabuleiro (index 0 do tabuleiro)
        for(String i : tabuleiroJogo){
            System.out.print(i + "|");
        }
    }
    int jogarDado(){// sortear um número aleatório entre 1 e 6
       var dado = new Random();
       int numDado = dado.nextInt(6) + 1;
       return numDado;
    }

    void andarCasas(){
        var sc = new Scanner(System.in);
        int dado = jogarDado();// Pegar o valor do dado;   
        
        System.out.println("\nPrecione qual quer coisa para continuar");// pedir ao usuario para continuar
        sc.nextLine();
        System.out.println("O p1 vai andar: " + dado);

        if (posicao + dado <= tabuleiroJogo.length - 1){
            switch (tabuleiroJogo[posicao + dado]) {
                case "":
                    tabuleiroJogo[posicao] = casa;
                    casa = tabuleiroJogo[posicao + dado];
                    tabuleiroJogo[posicao + dado] = nome;
                    posicao += dado;
                    break;
                case "Fim":
                    tabuleiroJogo[posicao] = casa;
                    casa = tabuleiroJogo[posicao + dado];
                    tabuleiroJogo[posicao + dado] = nome;
                    posicao += dado;
                    break;
                case "*":
                    tabuleiroJogo[posicao] = casa;
                    casa = tabuleiroJogo[posicao + dado];
                    tabuleiroJogo[posicao + dado] = nome;
                    posicao += dado;
                    System.out.println("Casa especial");
                    break;
            
                default:
                    break;
            }
            
        }
        else if (posicao + dado > tabuleiroJogo.length - 1){
            tabuleiroJogo[posicao] = casa;
            tabuleiroJogo[tabuleiroJogo.length - 1] = nome;
            posicao = tabuleiroJogo.length - 1;
        }

        System.out.println("\n");// mostra o tabuleiro
        System.out.println("----------------------------------------------------------------------");
        for(int i = 0; i < tabuleiroJogo.length;i++){
            if (tabuleiroJogo[i] == "") {
                System.out.print(i+"|");
            }
          
            else if (tabuleiroJogo[tabuleiroJogo.length - 1] == nome && i == posicao) {
                System.out.print(tabuleiroJogo[i]+"|");
                System.out.println("\nVenceu");
                break;
            }
            else{
                System.out.print(tabuleiroJogo[i]+"|");
            }
            
        }
        
    }
    

}
