import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WarningViewNumber extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public WarningViewNumber() {
		setTitle("Warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\warning.png"));
		label.setBounds(40, 71, 85, 63);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Please input non-negative decimal or integer!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblNewLabel.setBounds(135, 71, 415, 88);
		contentPane.add(lblNewLabel);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(245, 169, 93, 23);
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
