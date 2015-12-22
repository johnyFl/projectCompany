package companyAdministration;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeesMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeesMenu frame = new EmployeesMenu();
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
	public EmployeesMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPanel employeesP = new JPanel();
		employeesP.setBounds(216, 102, 501, 317);
		contentPane.add(employeesP);
		employeesP.setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "john", "flo", "pir" }, { "kostas", "tax", "x" }, { "kostas", "mpo", "y" }, },
				new String[] { "name", "surname", "city" }));
		table.setBounds(0, 0, 483, 278);

		employeesP.add(table);
		JButton newEmpBtn = new JButton("New employee");
		newEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkNullRow() != true)
					JOptionPane.showMessageDialog(null, "you must fill the fields");
				else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.insertRow(0, new Object[] { "", "", "" });
				}
			}
		});
		newEmpBtn.setBounds(0, 278, 165, 39);
		employeesP.add(newEmpBtn);

		JButton deleteEmBtn = new JButton("Delete employee");
		deleteEmBtn.setBounds(163, 278, 165, 39);
		employeesP.add(deleteEmBtn);

		JButton changeEmBtn = new JButton("Change employee");
		changeEmBtn.setBounds(326, 278, 157, 39);
		employeesP.add(changeEmBtn);

		JLabel lbParts = new JLabel("Parts");
		lbParts.setBounds(94, 77, 46, 14);
		contentPane.add(lbParts);

		final JPanel partsP = new JPanel();
		partsP.setBounds(216, 102, 483, 338);
		contentPane.add(partsP);
		partsP.setLayout(null);
		partsP.setVisible(false);

		final JTextPane reviewsTxt = new JTextPane();
		reviewsTxt.setBounds(0, 0, 483, 276);
		partsP.add(reviewsTxt);
		reviewsTxt.setText("review");

		JButton changeBtn = new JButton("Change part");
		changeBtn.setBounds(325, 275, 158, 42);
		partsP.add(changeBtn);

		JButton editBtn = new JButton("New part");
		editBtn.setBounds(0, 275, 158, 42);
		partsP.add(editBtn);

		JButton deleteBtn = new JButton("Delete part");
		deleteBtn.setBounds(155, 275, 174, 42);
		partsP.add(deleteBtn);

		final JList PartsList = new JList();
		PartsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(PartsList.getSelectedValue());
			}
		});
		PartsList.setModel(new AbstractListModel() {
			String[] values = new String[] { "part1", "part2", "part3" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		PartsList.setBounds(57, 102, 113, 317);
		contentPane.add(PartsList);

		JButton reviewBtn = new JButton("Review");
		reviewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				employeesP.setVisible(false);
				partsP.setVisible(true);

			}
		});
		reviewBtn.setBounds(216, 73, 106, 23);
		contentPane.add(reviewBtn);

		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				partsP.setVisible(false);
				employeesP.setVisible(true);

			}
		});
		btnEmployees.setBounds(323, 73, 106, 23);
		contentPane.add(btnEmployees);

		JButton btnSave = new JButton("save");
		btnSave.setBounds(610, 73, 89, 23);
		contentPane.add(btnSave);

	}

	boolean checkNullRow() {

		String x = (String) table.getModel().getValueAt(0, 0);
		String y = (String) table.getModel().getValueAt(0, 1);
		String c = (String) table.getModel().getValueAt(0, 2);

		if (x.equals("") || y.equals("") || c.equals(""))
			return false;
		else
			return true;
	}

}
