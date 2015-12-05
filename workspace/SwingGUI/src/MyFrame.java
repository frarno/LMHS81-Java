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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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

		JLabel label = new JLabel("Champ de saisie");
		JTextField data = new JTextField();
		JPanel panel = new JPanel(new GridBagLayout());
		JButton button = new JButton("OK");
		GridBagConstraints gc = new GridBagConstraints();

		data.setColumns(10);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saisie utilisateur = " + data.getText());

			}
		});

		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(label, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add(data, gc);
		gc.gridx=0;
		gc.gridy=2;
		panel.add(button, gc);
		this.getContentPane().add(panel);
	}



}
