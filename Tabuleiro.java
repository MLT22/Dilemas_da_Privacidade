public class Tabuleiro {
    public static String [] criarTabuleiro(){
        String tabuleiroInicial [] = new String[20];
        tabuleiroInicial[0] = "Inicio";
        tabuleiroInicial[tabuleiroInicial.length - 1] = "Fim";
        for (int i = 1; i < tabuleiroInicial.length - 1;i++){
            tabuleiroInicial[i] = "";
        }
        tabuleiroInicial[9] = "*";
        return tabuleiroInicial;
    }

}