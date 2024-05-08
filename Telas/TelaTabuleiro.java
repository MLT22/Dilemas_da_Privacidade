package Telas;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class TelaTabuleiro extends JFrame {
    ImageIcon imagem = new ImageIcon(getClass().getResource("PrototipoTelaTabuleiro.png"));
    JLabel label = new JLabel(imagem);
    JList lista = new JList<String>();

    public TelaTabuleiro(){
        add(label);
        setTitle("Dilemas da Privacidade");
        setVisible(true);
        setSize(1200,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


        

}
