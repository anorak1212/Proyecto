import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Examen extends JPanel implements ActionListener, KeyListener, DocumentListener {
	private JButton Boton_Limpiar, Boton_Salir, Boton_Aceptar;
	private JTextField cadenaTxt;
	private JLabel labelTxt;
	private JLabel labelVocales;
	private JTextField vocalesTxt;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Jimenez Perez Mateo");
		frame.setSize(355, 380);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new Examen();
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(true);
	}
	public Examen() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);

		// Nombre
		labelTxt = new JLabel("Texto");
		labelTxt.setBounds(90, 100, 80, 25);
		this.add(labelTxt);

		cadenaTxt = new JTextField(20);
		cadenaTxt.setName("Texto");
		cadenaTxt.addActionListener(this);
		cadenaTxt.addKeyListener(this);
		cadenaTxt.setBounds(130, 100, 160, 25);
		cadenaTxt.getDocument().addDocumentListener(this);
		this.add(cadenaTxt);

		labelVocales = new JLabel("Vocales");
		labelVocales.setBounds(80, 150, 80, 25);
		this.add(labelVocales);

		vocalesTxt = new JTextField(20);
		vocalesTxt.setName("Texto");
		vocalesTxt.setBounds(130, 150, 160, 25);
		vocalesTxt.setEditable(false);
		this.add(vocalesTxt);

		// Botones

		// Boton Limpiar
		JButton BtnLimpiar = new JButton("Limpiar");
		BtnLimpiar.addActionListener(this);
		BtnLimpiar.setBounds(10, 300, 100, 30);
		this.add(BtnLimpiar);

		// Boton Salir
		JButton BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setBounds(120, 300, 100, 30);
		this.add(BtnSalir);

		// Boton Aceptar
		JButton BtnCadena = new JButton("Cadena");
		BtnCadena.addActionListener(this);
		BtnCadena.setBounds(230, 300, 100, 30);
		this.add(BtnCadena);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			cadenaTxt.setText("");
		} else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
			System.out.println(e.getActionCommand());
			// Custom button text
			Object[] options = { "Si, por favor", "No, gracias", "Di clic por error!" };
			int respuesta = JOptionPane.showOptionDialog(this, "¿Está seguro que desea salir?", "Salir del sistema",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			if (respuesta == 0) {
				System.exit(0);
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Cadena")) {
			boolean faltanCampos = false;
			labelTxt.setForeground(Color.BLACK);
			if (cadenaTxt.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Texto vacio");
				faltanCampos = true;
				labelTxt.setForeground(Color.RED);
				cadenaTxt.requestFocus();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {

		// leer el caracter presionado
		char tecla = e.getKeyChar();
		System.out.println(tecla);
		// si el caracter es backspace no hacer nada, permitir borrar
		if (e.getKeyCode() == 8) {
			return;
		}
		//
		
		if (Character.isLetter(tecla) || tecla == ' ') {
			if (cadenaTxt.getText().length() >= 10) {
				e.setKeyChar('\0');
				JOptionPane.showMessageDialog(this, "Solo se le permite 10 caracteres");
			}
		} else {
			e.setKeyChar('\0');
			JOptionPane.showMessageDialog(this, "Solo se le permite letras y espacio");
		}
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// System.out.println(textTxt.getText());
		// detecta letra por letra agregada
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		// lee toda la palabra
		String cadena = cadenaTxt.getText();
		int longitud = cadena.length();

		String vocales = "";

		for (int i = 0; i < longitud; i++) {
			char letra = cadena.charAt(i);

			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A'
					|| letra == 'E' || letra == 'I' || letra == 'I' || letra == 'U') {

				vocales = vocales + letra + " ";
			}
		}

		vocalesTxt.setText(vocales);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println(textTxt.getText());
		// detecta letra por letra Borrada
	}
}
