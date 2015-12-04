/**
 *
 */

/**
 * @author user
 *
 */

import javax.swing.JFrame;

public class Frame extends JFrame {

	static final long serialVersionUID = 2;

	public Frame()
	{
		super();
		build();
	}

	private void build() {
		setTitle("Une fenêtre vide");
		setSize(320,240);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();

		frame.setVisible(true);
	}

}
