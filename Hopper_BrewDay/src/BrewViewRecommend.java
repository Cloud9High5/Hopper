import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BrewViewRecommend extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;


	public BrewViewRecommend(BrewModel m,BrewController c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 646);
		setTitle("Recommend Recipe");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recommend a recipe:");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 60, 286, 62);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.info);
		textArea.setEditable(false);
		textArea.setBounds(343, 60, 629, 62);
		contentPane.add(textArea);
		
		JLabel lblRecipesList = new JLabel("Recipes List:");
		lblRecipesList.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipesList.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblRecipesList.setBounds(47, 162, 120, 40);
		contentPane.add(lblRecipesList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(47, 211, 939, 275);
		contentPane.add(scrollPane);
		
		JButton buttonBack = new JButton("Home");
		buttonBack.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		buttonBack.setBounds(902, 559, 93, 23);
		contentPane.add(buttonBack);
	
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			
			
			
			String[] values =c.getRecipeString();
			
			public int getSize() {
				if(values == null) {
					return 0;
					
				}
				return values.length;
			}
			public Object getElementAt(int index) {
				if(values == null) {
					return 0;
					
				}
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JButton btnNewButton1 = new JButton("Brew");
		btnNewButton1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton1.setBounds(830, 150, 130, 49);
		contentPane.add(btnNewButton1);
		
		JButton btnBrewButton = new JButton("Brew  This  One");
		btnBrewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnBrewButton.setBounds(428, 529, 184, 49);
		contentPane.add(btnBrewButton);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
}
