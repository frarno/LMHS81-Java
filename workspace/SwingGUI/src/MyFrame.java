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

		JLabel label = new JLabel("Gauche");
		JLabel label2 = new JLabel("Centre");
		JLabel label3 = new JLabel("Droite");
		JLabel label4 = new JLabel("2eme ligne");
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(label, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add(label2, gc);
		gc.gridx = 2;
		gc.gridy = 0;
		panel.add(label3, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		panel.add(label4, gc);
		this.getContentPane().add(panel);
	}



}
