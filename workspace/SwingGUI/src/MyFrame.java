/**
 *
 */

/**
 * @author user
 *
 */

import javax.swing.JLabel;


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

		JLabel label = new JLabel("Ceci est un label");
		this.getContentPane().add(label);
	}



}
