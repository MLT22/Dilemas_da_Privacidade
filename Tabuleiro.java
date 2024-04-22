public class Tabuleiro {
    void criarTabuleiro(){
        String tabuleiro [] = new String[56];
        tabuleiro[0] = "Inicio";
        tabuleiro[tabuleiro.length - 1] = "Fim";
        for (int i = 0; i < tabuleiro.length; i++){
            System.out.print(tabuleiro[i]+"|");

        }
    }

}