import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class DesignerTest {

	private JFrame frame;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignerTest window = new DesignerTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesignerTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Onglet 1", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{37, 249, 114, 0};
		gbl_panel.rowHeights = new int[]{0, 19, 25, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblConsole = new JLabel(" ");
		GridBagConstraints gbc_lblConsole = new GridBagConstraints();
		gbc_lblConsole.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsole.gridx = 1;
		gbc_lblConsole.gridy = 0;
		panel.add(lblConsole, gbc_lblConsole);
		
		JLabel lbl1 = new JLabel("Saisissez un entier (0 < entier <10)");
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.anchor = GridBagConstraints.WEST;
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 1;
		gbc_lbl1.gridy = 1;
		panel.add(lbl1, gbc_lbl1);
		
		data = new JTextField();
		GridBagConstraints gbc_data = new GridBagConstraints();
		gbc_data.anchor = GridBagConstraints.NORTHWEST;
		gbc_data.insets = new Insets(0, 0, 5, 0);
		gbc_data.gridx = 2;
		gbc_data.gridy = 1;
		panel.add(data, gbc_data);
		data.setColumns(10);
		
		JButton btnButton = new JButton("OK");
//		btnButton.addActionListener(new MyButton(data, console));
/*		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		*/
		GridBagConstraints gbc_btnButton = new GridBagConstraints();
		gbc_btnButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnButton.gridx = 2;
		gbc_btnButton.gridy = 2;
		panel.add(btnButton, gbc_btnButton);
	}

}
