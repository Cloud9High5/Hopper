import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EquipmentViewAdd extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EquipmentViewAdd(EquipmentModel m, EquipmentController c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 301);
		setTitle("Add Equipment");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(248, 79, 153, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(417, 225, 93, 23);
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewLabel.setBounds(178, 77, 66, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewCapcity = new JLabel("Capacity:");
		lblNewCapcity.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCapcity.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewCapcity.setBounds(178, 127, 99, 23);
		contentPane.add(lblNewCapcity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(285, 125, 39, 31);
		contentPane.add(textField_1);
		
		JLabel lblL = new JLabel("L");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblL.setBounds(334, 127, 27, 23);
		contentPane.add(lblL);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add
				EquipmentController.insertEquipment(new EquipmentModel(textField.getText(),Double.parseDouble(textField_1.getText())));
				dispose();
				new EquipmentView(m, c);
			}
		});
	}
}
