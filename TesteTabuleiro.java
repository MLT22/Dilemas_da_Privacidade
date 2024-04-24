public class TesteTabuleiro {
    public static void main(String[] args) {
        var p1 = new Players();
        // p1.criarPesonagem();
        
        do {
            p1.andarCasas();
        } while (p1.posicao < p1.tabuleiroJogo.length - 1);
        

        }
        
    }

