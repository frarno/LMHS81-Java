
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class MyButton implements ActionListener {

	private JTextField textField;

	public MyButton(JTextField textField) {
		super();
		this.textField = textField;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clic sur OK");
		System.out.println("Saisie utilisateur : " + textField.getText());
	}
}
