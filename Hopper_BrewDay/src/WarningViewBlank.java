import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WarningViewBlank extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public WarningViewBlank() {
		setTitle("Warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\BrewDay_Hopper_1.1\\Hopper_BrewDay\\images\\warning.png"));
		label.setBounds(60, 82, 85, 63);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Please fill all the blank!");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblNewLabel.setBounds(143, 82, 205, 63);
		contentPane.add(lblNewLabel);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(159, 169, 93, 23);
		contentPane.add(btnClose);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		btnClose.addActionListener(new ActionListener() {
			private RecipeModel rm;
			private RecipeController rc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				}
			});
	}
}
