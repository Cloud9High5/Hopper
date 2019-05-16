import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IngredientViewUpdate extends JFrame {
	
	private JTextField textAmount;
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	public IngredientViewUpdate(IngredientModel m, IngredientController c, Integer Sid) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 301);
		setTitle("Update Ingredient");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Finish");
		
		btnNewButton.setBounds(417, 225, 93, 23);
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JLabel lblNewCapcity = new JLabel("Amount:");
		lblNewCapcity.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCapcity.setFont(new Font("Bahnschrift", Font.BOLD, 34));
		lblNewCapcity.setBounds(154, 87, 151, 69);
		contentPane.add(lblNewCapcity);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(315, 87, 84, 69);
		contentPane.add(textAmount);
		this.setVisible(true);
		
		
	}
}