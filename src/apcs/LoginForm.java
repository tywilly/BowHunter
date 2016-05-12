package apcs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.client.update.UpdateFetcher;

public class LoginForm extends JFrame implements ActionListener{

	public static String username = "";
	
	JPanel main = new JPanel();
	
	JTextField usernameField = new JTextField();
	JTextField password = new JTextField();
	
	JButton loginBtn = new JButton("Login!");
	
	JLabel updateLabel = new JLabel("Updating...");
	
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
			//this.setVisible(false);
			

			this.removeAll();
			this.add(updateLabel);
			
			UpdateFetcher uf = new UpdateFetcher();
			
			try {
				uf.fetchUpdates();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.setVisible(false);
			
			ClientDriver driver = new ClientDriver();
			
		}
		
	}
	
}
