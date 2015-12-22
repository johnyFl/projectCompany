import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;

public class MainJ extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField age;
	private JList list = new JList();
	private JTable table;
	boolean v=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					MainJ frame = new MainJ();
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
	public MainJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(66, 37, 86, 20);
		contentPane.add(name);
		name.setColumns(10);

		surname = new JTextField();
		surname.setBounds(66, 91, 86, 20);
		contentPane.add(surname);
		surname.setColumns(10);

		age = new JTextField();
		age.setBounds(66, 138, 86, 20);
		contentPane.add(age);
		age.setColumns(10);

		JButton btnImport = new JButton("import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Person person = new Person();
//				person.name = name.getText();
//				person.surname = surname.getText();
//				person.age = 23;
//				person.ins(person);
//				name.setText("");
//				surname.setText("");
//				age.setText("");
			}
		});
		btnImport.setBounds(63, 191, 89, 23);
		contentPane.add(btnImport);

		JButton show = new JButton("show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arr a=new Arr();
				try {
					System.out.println(a.List());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

		show.setBounds(675, 11, 89, 23);
		contentPane.add(show);
		
		final JList list_1 = new JList();
		list_1.setBounds(571, 91, 152, 296);
		contentPane.add(list_1);	
		
		
		list_1.setVisible(v);
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(10, 40, 46, 14);
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("surname:");
		lblSurname.setBounds(10, 94, 46, 14);
		contentPane.add(lblSurname);

		JLabel lblAge = new JLabel("age:");
		lblAge.setBounds(10, 141, 46, 14);
		contentPane.add(lblAge);
		
		table = new JTable();
		table.setBounds(256, 91, 303, 296);
		contentPane.add(table);
		
		
		
		JButton btnTable = new JButton("table");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (v==false){ 
				v=true;
		list_1.setVisible(v);
		}
		
			else{
			v=false;
			list_1.setVisible(v);
			
		}		
			}
		});
		btnTable.setBounds(256, 67, 89, 23);
		contentPane.add(btnTable);
		
		
		JButton btnList = new JButton("list");
		btnList.setBounds(347, 67, 89, 23);
		contentPane.add(btnList);
	}
}
