
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BrewSelectView extends JFrame {
	
	private JPanel contentPane;


	public BrewSelectView(BrewModel m, BrewController c) {
		setTitle("Brew");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton RecommandButton = new JButton("Recommand Recipes");
		RecommandButton.setFont(new Font("ËÎÌו", Font.PLAIN, 28));
		RecommandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		RecommandButton.setBounds(291, 64, 432, 122);
		contentPane.add(RecommandButton);
		
		JButton Missingbutton = new JButton("Recipes With Missing Ingredient");
		Missingbutton.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		Missingbutton.setBounds(291, 240, 432, 122);
		contentPane.add(Missingbutton);
		
		JButton btnBack = new JButton("Back to Home page");
		btnBack.setFont(new Font("ËÎÌו", Font.PLAIN, 28));
		btnBack.setBounds(291, 412, 432, 122);
		contentPane.add(btnBack);
		
		this.setVisible(true);

	}
	
}
