import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BrewInputWarning extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrewInputWarning frame = new BrewInputWarning();
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
	public BrewInputWarning() {
		setTitle("Warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInvalidInput = new JLabel("Invalid Input. Please try again.");
		lblInvalidInput.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 27));
		lblInvalidInput.setBounds(79, 10, 376, 81);
		panel.add(lblInvalidInput);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		btnNewButton.setBounds(198, 101, 139, 42);
		panel.add(btnNewButton);
		this.setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			private BrewModel bm;
			private BrewController bc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new BrewView(bm, bc);
				}
			});
		
	}
	
}
