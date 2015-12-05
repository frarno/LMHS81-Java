
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.TextField;

public class MyButton implements ActionListener {

	private JTextField textField;
	private JLabel console;

	public MyButton(JTextField textField, JLabel console) {
		super();
		this.textField = textField;
		this.console = console;
	}
	public void actionPerformed(ActionEvent e) {
		console.setForeground(Color.red);
		try {
			int value = Integer.parseInt(textField.getText());
			if (value < 0) {
				console.setText("Valeur trop petite");
			} else if (value > 10) {
				console.setText("Valeur trop grande");
			} else {
				console.setText("Parfait");
				console.setForeground(Color.green);
			}
		} catch (NumberFormatException ex) {
			console.setText("Vous devez saisir un entier");
		} catch (Exception ex) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
