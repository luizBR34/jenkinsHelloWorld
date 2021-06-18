import javax.swing.*;
import java.awt.*;

public class CurvaBezier extends JPanel {

	CurvaBezier() {

	Bezier componente = new Bezier();

	add(componente);
	}


	private static void criarGUI() {

	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame janela = new JFrame("Programa que desenha uma Curva Cúbica");
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setContentPane(new CurvaBezier());
	janela.setVisible(true);
	janela.pack();
	}


	public static void main(String[] args) {
		
	System.out.println("Minha primeira mudança by Jenkins!");

	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		criarGUI();
		}
	});
    }
}
