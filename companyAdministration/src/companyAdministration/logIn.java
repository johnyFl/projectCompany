package companyAdministration;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
public class logIn extends JFrame {

	private JPanel contentPane;
	private JTextField userTxt;
	private JTextField pdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn frame = new logIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public logIn() {
		setTitle("company project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("welcome");
		lblWelcome.setFont(new Font("",Font.BOLD,20));
		lblWelcome.setBounds(104, 11, 88, 36);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(71, 73, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(71, 99, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		userTxt = new JTextField();
		userTxt.setBounds(137, 70, 112, 20);
		contentPane.add(userTxt);
		userTxt.setColumns(10);
		
		pdTxt = new JTextField();
		pdTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pdTxt.setText("*");
			}
		});
		pdTxt.setBounds(137, 96, 112, 20);
		contentPane.add(pdTxt);
		pdTxt.setColumns(10);
		
		JButton logIn = new JButton("log in");
		logIn.setFont(new Font("",Font.BOLD,15));
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user=userTxt.getText();
				String pd=pdTxt.getText();
				if (user.equals("hr") && pd.equals("hr")){
	               JOptionPane.showMessageDialog(null, "you sign as an hr");
				   
				     setVisible(false);
				     dispose();
				     centralMenu m=new centralMenu();
				      m.setVisible(true);}
				else if (user.equals("sv") && pd.equals("sv")){
					JOptionPane.showMessageDialog(null, "you sign as an sv");
					
					setVisible(false);
					dispose();
					centralMenu m=new centralMenu();
					m.setVisible(true);}
				
				else{
					JOptionPane.showMessageDialog(null, "invalid name or password");
					userTxt.setText(null);
					pdTxt.setText(null);
				}	
			
				
	
			}
		});
		logIn.setBounds(104, 142, 89, 23);
		contentPane.add(logIn);
	}
}
