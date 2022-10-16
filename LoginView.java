import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class LoginView extends JPanel implements ActionListener,KeyListener {
	private JButton Boton_Limpiar, Boton_Salir, Boton_Aceptar;
	private JTextField textNombre, textApellidos, textCURP, textNumControl;
	private JComboBox lista_de_despliegue;
	private JRadioButton RadioHombre;
	private JRadioButton RadioMujer;
	private JLabel labelNombre;
	private JLabel labelApellidos;
	private JLabel labelCURP;
	private JLabel labelNumControl;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Datos escolares_Jimenez_Perez_Mateo");
		frame.setSize(350, 380);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new LoginView();
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(true);

	}

	public LoginView() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);

		// Nombre
		labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(10, 10, 80, 25);
		this.add(labelNombre);

		textNombre = new JTextField(20);
		textNombre.setName("nombre");
		textNombre.addActionListener(this);
		textNombre.addKeyListener(this);
		textNombre.setBounds(100, 10, 160, 25);
		this.add(textNombre);

		// Apellidos
		labelApellidos = new JLabel("Apellidos");
		labelApellidos.setBounds(10, 40, 80, 25);
		this.add(labelApellidos);

		textApellidos = new JTextField(20);
		textApellidos.setName("apellidos");
		textApellidos.addActionListener(this);
		textApellidos.addKeyListener(this);
		textApellidos.setBounds(100, 40, 160, 25);
		this.add(textApellidos);

		// CURP
		labelCURP = new JLabel("CURP");
		labelCURP.setBounds(10, 70, 80, 25);
		this.add(labelCURP);

		textCURP = new JTextField();
		textCURP.setName("CURP");
		textCURP.addActionListener(this);
		textCURP.addKeyListener(this);
		textCURP.setBounds(100, 70, 160, 25);
		this.add(textCURP);

		// NUMERO DE CONTROL
		labelNumControl = new JLabel("No. de control");
		labelNumControl.setBounds(10, 100, 80, 25);
		this.add(labelNumControl);

		textNumControl = new JTextField(20);
		textNumControl.setName("numero");
		textNumControl.addActionListener(this);
		textNumControl.addKeyListener(this);
		textNumControl.setBounds(100, 100, 160, 25);
		this.add(textNumControl);

		// RadioButton

		JLabel Genero = new JLabel("Genero");
		Genero.setBounds(10, 130, 150, 25);
		this.add(Genero);

		RadioHombre = new JRadioButton();
		RadioHombre.addActionListener(this);
		RadioHombre.setText("Hombre");
		RadioHombre.setBounds(20, 150, 80, 25);

		RadioMujer = new JRadioButton();
		RadioMujer.addActionListener(this);
		RadioMujer.setText("Mujer");
		RadioMujer.setBounds(20, 180, 80, 25);
		RadioMujer.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(RadioHombre);
		group.add(RadioMujer);
		this.add(RadioHombre);
		this.add(RadioMujer);
		// Jcombobox

		JLabel Escuela = new JLabel("Escoge tu Carrera");
		Escuela.setBounds(10, 210, 150, 25);
		this.add(Escuela);

		String[] Escuelas = { "Mecánica Industrial", "Programación", "Electricidad", "Construcción", "Trabajo Social" };
		lista_de_despliegue = new JComboBox(Escuelas);
		lista_de_despliegue.setSelectedIndex(1);
		lista_de_despliegue.addActionListener(this);
		lista_de_despliegue.setBounds(10, 240, 140, 25);
		this.add(lista_de_despliegue);

		// Botones

		// Boton Limpiar
		JButton Boton_Limpiar = new JButton("Limpiar");
		Boton_Limpiar.addActionListener(this);
		Boton_Limpiar.setBounds(10, 300, 100, 30);
		this.add(Boton_Limpiar);

		// Boton Salir
		JButton Boton_Salir = new JButton("Salir");
		Boton_Salir.addActionListener(this);
		Boton_Salir.setBounds(120, 300, 100, 30);
		this.add(Boton_Salir);

		// Boton Aceptar
		JButton Boton_Aceptar = new JButton("Aceptar");
		Boton_Aceptar.addActionListener(this);
		Boton_Aceptar.setBounds(230, 300, 100, 30);
		this.add(Boton_Aceptar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			textNombre.setText("");
			textApellidos.setText("");
			textCURP.setText("");
			textNumControl.setText("");
			lista_de_despliegue.setSelectedIndex(1);// Programacion por default
			RadioMujer.setSelected(true);// Por default
		} else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
			System.out.println(e.getActionCommand());
			// Custom button text
			Object[] options = { "Si, por favor", "No, gracias", "Di clic por error!" };
			int respuesta = JOptionPane.showOptionDialog(this, "¿Está seguro que desea salir?", "Salir del sistema",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

			if (respuesta == 0) {
				System.exit(0);
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
			boolean faltanCampos = false;
			labelNombre.setForeground(Color.BLACK);			
			labelApellidos.setForeground(Color.BLACK);			
			labelCURP.setForeground(Color.BLACK);			
			labelNumControl.setForeground(Color.BLACK);	
			if (textNombre.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nombre vacio");
				faltanCampos = true;
				labelNombre.setForeground(Color.RED);
				textNombre.requestFocus();
			}
			else if (textApellidos.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Apellidos vacios");
				faltanCampos = true;
				labelApellidos.setForeground(Color.RED);
				textApellidos.requestFocus();
			}
			else if (textCURP.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "CURP vacio");
				faltanCampos = true;
				labelCURP.setForeground(Color.RED);
				textCURP.requestFocus();
			}
			else if (textNumControl.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Numero de control vacio");
				faltanCampos = true;
				labelNumControl.setForeground(Color.RED);
				textNumControl.requestFocus();
			}
			if (faltanCampos == false) {
				JOptionPane.showMessageDialog(this, "Su información es correcta y será procesada.");
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
		//obtener el texto que estan escribiendo
		String seleccionado = (((JTextField) e.getSource()).getName());
		//leer el caracter presionado
		char caracter = e.getKeyChar();
		
		System.out.println(caracter);
		//si el caracter es backspace no hacer nada, permitir borrar
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		} else if (seleccionado.equalsIgnoreCase("numero")) { // validar solo numero

			if (!(Character.isDigit(caracter))) { // sino es numero anular el caracter
				e.setKeyChar('\0');
				JOptionPane.showMessageDialog(this, "Solo se permiten numeros");
			}
		} else if (seleccionado.equalsIgnoreCase("CURP")) { //CURP permitir numeros y letras
			if (!(Character.isLetter(caracter) || Character.isDigit(caracter))) {
				e.setKeyChar('\0');
				JOptionPane.showMessageDialog(this, "Solo se aceptan numeros y letras");
			}else if(textCURP.getText().length()>=18) {				
				e.setKeyChar('\0');
				JOptionPane.showMessageDialog(this, "Solo se le permite 18 caracteres");
			}  else {
			e.setKeyChar(Character.toUpperCase(caracter));
			}
			// para todos los demas (nombre y apellidos) permitir letras y espacio
		} else if (!(Character.isLetter(caracter) || caracter==' ')) {
			e.setKeyChar('\0');
			JOptionPane.showMessageDialog(this, "Solo se permiten Letras");
		}
	}
}
