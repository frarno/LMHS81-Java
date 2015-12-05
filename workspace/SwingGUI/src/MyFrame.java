/**
 *
 */

/**
 * @author user
 *
 */

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;


/*
 * ActionListener listener capturant les événemens relatif à un widget
 * WindowListener capture les événements relatifs auxfenêtres (ouverture, fermeture, redimensionnement etc...)
 * MouseListener capture les événements de la souris
 * ActionEvent contient le type d'événement déclencheur, et l'objet sur lequel l'événement s'est produit getSource
 */


public class MyFrame extends Frame {

	static final long serialVersionUID = 3;

	/**
	 * @param title
	 */
	public MyFrame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param width
	 * @param height
	 * @param isCentered
	 * @param isResizable
	 */
	public MyFrame(String title, int width, int height, boolean isCentered, boolean isResizable) {
		super(title, width, height, isCentered, isResizable);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Frame#addContent()
	 */
	@Override
	public void addContent() {

		JLabel label = new JLabel("Saisissez un entier entre (0 < entier < 10) ");
		JLabel console = new JLabel(" ");
		JTextField data = new JTextField();
		JButton button = new JButton("OK");

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		data.setColumns(10);
		console.setForeground(Color.red);
		button.addActionListener(new MyButton(data,console));

		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(console, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(label, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		panel.add(data, gc);
		gc.gridx=1;
		gc.gridy=2;
		panel.add(button, gc);
		this.getContentPane().add(panel);
	}



}
