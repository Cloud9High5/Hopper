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

public class EquipmentViewUpdate extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EquipmentViewUpdate(EquipmentModel m, EquipmentController c, Integer Eid) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 301);
		setTitle("Update Equipment");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(248, 79, 153, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(417, 225, 93, 23);
		btnFinish.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		contentPane.add(btnFinish);
		
		JLabel lblNewLabel = new JLabel("Rename:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewLabel.setBounds(178, 77, 66, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewCapcity = new JLabel("New Capacity:");
		lblNewCapcity.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCapcity.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewCapcity.setBounds(136, 127, 141, 23);
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
		this.setVisible(true);
		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update
				EquipmentController.updateEquipment(new EquipmentModel(textField.getText(),Double.parseDouble(textField_1.getText())), Eid);
				dispose();
			}
		});
	}
}
