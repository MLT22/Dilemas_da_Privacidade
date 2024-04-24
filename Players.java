import java.util.Random;
import java.util.Scanner;

public class Players {
    String [] tabuleiroJogo = Tabuleiro.criarTabuleiro();
    int posicao = 0;
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
        int posicInicial = posicao;// guardar a posição do player
        String guardarCasa = "" + posicao; // variavel que vai quardar o valor da casa que o player vai passar
        
        System.out.println("\nPrecione qual quer coisa para continuar");// pedir ao usuario para continuar
        sc.nextLine();
        System.out.println("O p1 vai andar: " + dado);

        while(posicao < posicInicial + dado){
            if(posicao == 0){// caso o playes esteja na primeira casa vai rescrever o valor no index(0) para "Inicio"
                tabuleiroJogo[posicao] = "Inicio";
                posicao += 1; // Fazer o player andar 1 casa
                tabuleiroJogo[posicao] = nome;
                
            }
            else{
                if(posicao < tabuleiroJogo.length - 1){
                    guardarCasa = "" + posicao;
                    tabuleiroJogo[posicao] = guardarCasa; // reescreve o valor da casa onde o player estava para o valor antigo da casa
                    posicao++; // faz o player andar 1 casa
                    // guardarCasa = tabuleiroJogo[posicao];// guarda o valor da casa que o player vai passar
                    tabuleiroJogo[posicao] = nome;
                    
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

        
    }
    
}
