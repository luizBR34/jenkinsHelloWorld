import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Bezier extends JComponent implements MouseMotionListener, MouseListener {

	BasicStroke espessura;
	CubicCurve2D.Double curva;
	Double inicialX, inicialY, finalX, finalY, controle01X, controle01Y,
	controle02X, controle02Y;
	Rectangle areaInicial, areaFinal, areaControle01, areaControle02;
	boolean condicao01, condicao02, condicao03, condicao04;
	int sobra = 5;


	Bezier() {

	espessura = new BasicStroke(5.0f);

	curva = new CubicCurve2D.Double(50.0, 70.0, 100.0, 40.0, 150.0, 70.0, 200.0, 170.0);

	inicialX = new Double(curva.getX1());
	inicialY = new Double(curva.getY1());
	finalX = new Double(curva.getX2());
	finalY = new Double(curva.getY2());
	controle01X = new Double(curva.getCtrlX1());
	controle01Y = new Double(curva.getCtrlY1());
	controle02X = new Double(curva.getCtrlX2());
	controle02Y = new Double(curva.getCtrlY2());

	areaInicial = new Rectangle(inicialX.intValue() - sobra, inicialY.intValue() - sobra, 15, 15);
	areaFinal = new Rectangle(finalX.intValue() - sobra, finalY.intValue() - sobra, 15, 15);
	areaControle01 = new Rectangle(controle01X.intValue() - sobra, controle01Y.intValue() - sobra, 15, 15);
	areaControle02 = new Rectangle(controle02X.intValue() - sobra, controle02Y.intValue() - sobra, 15, 15);

	addMouseMotionListener(this);
	addMouseListener(this);
	}


	public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(espessura);
	g2.setPaint(Color.black);
	g2.draw(curva);
// Ponto Inicial
	g2.setPaint(Color.blue);
	g2.fillRect(areaInicial.x, areaInicial.y, areaInicial.width - 5, areaInicial.height - 5);
// Ponto Final
	g2.setPaint(Color.red);
	g2.fillRect(areaFinal.x, areaFinal.y, areaFinal.width - 5, areaFinal.height - 5);
// Ponto Controle 01
	g2.setPaint(Color.magenta);
	g2.fillRect(areaControle01.x, areaControle01.y, areaControle01.width - 5, areaControle01.height - 5);
// Ponto Controle 02
	g2.setPaint(Color.pink);
	g2.fillRect(areaControle02.x, areaControle02.y, areaControle02.width - 5, areaControle02.height - 5);
	}


	public void mouseDragged(MouseEvent e) {

	if (condicao01) {
	curva.setCurve(e.getX(), e.getY(), curva.getCtrlX1(), curva.getCtrlY1(), curva.getCtrlX2(), curva.getCtrlY2(), curva.getX2(), curva.getY2());
	areaInicial.setLocation(e.getX() - sobra, e.getY() - sobra);
	repaint();
	}

	if (condicao02) {
	curva.setCurve(curva.getX1(), curva.getY1(), curva.getCtrlX1(), curva.getCtrlY1(), curva.getCtrlX2(), curva.getCtrlY2(), e.getX(), e.getY());
	areaFinal.setLocation(e.getX() - sobra, e.getY() - sobra);
	repaint();
	}

	if (condicao03) {
	curva.setCurve(curva.getX1(), curva.getY1(), e.getX(), e.getY(), curva.getCtrlX2(), curva.getCtrlY2(), curva.getX2(), curva.getY2());
	areaControle01.setLocation(e.getX() - sobra, e.getY() - sobra);
	repaint();
	}

	if (condicao04) {
	curva.setCurve(curva.getX1(), curva.getY1(), curva.getCtrlX1(), curva.getCtrlY1(), e.getX(), e.getY(), curva.getX2(), curva.getY2());
	areaControle02.setLocation(e.getX() - sobra, e.getY() - sobra);
	repaint();
	}
    }


	public void mouseMoved(MouseEvent e) {
	}


	public void mousePressed(MouseEvent e) {

	if (areaInicial.contains(e.getPoint())) {

	condicao01 = true;
	condicao02 = false;
	condicao03 = false;
	condicao04 = false;
	}

	if (areaFinal.contains(e.getPoint())) {

	condicao01 = false;
	condicao02 = true;
	condicao03 = false;
	condicao04 = false;
	}

	if (areaControle01.contains(e.getPoint())) {

	condicao01 = false;
	condicao02 = false;
	condicao03 = true;
	condicao04 = false;
	}

	if (areaControle02.contains(e.getPoint())) {

	condicao01 = false;
	condicao02 = false;
	condicao03 = false;
	condicao04 = true;
	}
    }


	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}


	public Dimension getMinimumSize() {
	return getPreferredSize();
	}


	public Dimension getPreferredSize() {
	Dimension tamanho = new Dimension(300, 300);
	return tamanho;
	}
}
