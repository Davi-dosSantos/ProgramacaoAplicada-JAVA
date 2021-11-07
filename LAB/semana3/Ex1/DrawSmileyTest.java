import javax.swing.JFrame;

public class DrawSmileyTest {
    public static void main(String[] args) {
        DrawSmiley panel = new DrawSmiley();
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(panel);
        janela.setSize(230, 250);
        janela.setVisible(true);
    }
} // fim da classe DrawSmileyTest