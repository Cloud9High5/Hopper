import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class BrewViewMissing extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;


	public BrewViewMissing(BrewModel m,BrewController c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 646);
		setTitle("Recommend Recipe");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblRecipesList = new JLabel("Recipes List:");
		lblRecipesList.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipesList.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblRecipesList.setBounds(47, 46, 120, 40);
		contentPane.add(lblRecipesList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(47, 96, 939, 390);
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
		
		JButton btnMissing = new JButton("Check Missing Ingredient");
		btnMissing.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnMissing.setBounds(315, 526, 361, 49);
		contentPane.add(btnMissing);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		buttonBack.addActionListener(new ActionListener() {
			private HomeModel hm;
			private HomeController hc;

			@Override
			public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new HomeView(hm, hc);
			}
			});
		btnMissing.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				m.setRecipe(c.StringtoRecipe(String.valueOf(list.getSelectedValue())));
				
				dispose();
				new MissingIngredientView(m,c);
			}
			});
	}
	
}
