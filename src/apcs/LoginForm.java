package apcs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{

	public static String username = "";
	
	JPanel main = new JPanel();
	
	JTextField usernameField = new JTextField();
	JTextField password = new JTextField();
	
	JButton loginBtn = new JButton("Login!");
	
	public LoginForm(){
		this.setBounds(0, 0, 300, 200);
		
		usernameField.setColumns(25);
		
		password.setColumns(25);
		
		this.add(main);
		main.add(usernameField);
		main.add(password);
		main.add(loginBtn);
		
		loginBtn.addActionListener(this);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource() == loginBtn){
			
			username = usernameField.getText();
			this.setVisible(false);
			
			ClientDriver driver = new ClientDriver();
			
		}
		
	}
	
}
