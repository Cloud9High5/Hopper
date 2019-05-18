
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BrewSelectView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public BrewSelectView(BrewModel m, BrewController c, Double volume) {
		setTitle("Brew Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton RecommandButton = new JButton("Recommand Recipes");
		RecommandButton.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		RecommandButton.setForeground(new Color(255, 255, 240));
		RecommandButton.setBackground(new Color(160, 82, 45));
		RecommandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		RecommandButton.setBounds(291, 64, 432, 122);
		contentPane.add(RecommandButton);
		
		JButton Missingbutton = new JButton("Recipes With Missing Ingredient");
		Missingbutton.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		Missingbutton.setForeground(new Color(255, 255, 240));
		Missingbutton.setBackground(new Color(160, 82, 45));
		Missingbutton.setBounds(291, 240, 432, 122);
		contentPane.add(Missingbutton);
		
		JButton btnBack = new JButton("Back to Home page");
		btnBack.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnBack.setForeground(new Color(255, 255, 240));
		btnBack.setBackground(new Color(160, 82, 45));
		btnBack.setBounds(291, 412, 432, 122);
		contentPane.add(btnBack);
		
		JLabel bgp = new JLabel("New label");
		bgp.setIcon(new ImageIcon("images\\beer.jpg"));
		bgp.setBounds(0, 0, 1042, 617);
		contentPane.add(bgp);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		RecommandButton.addActionListener(new ActionListener() {

			//private BrewModel bm;
			

			@Override
			public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
			
				
				ArrayList<RecipeModel> recommandRecipe = c.recommand();
				
				
				if(recommandRecipe == null) {
					
					
				}else {
					
					m.setRecommandRecipe(recommandRecipe);
					
					
				}
				//System.out.println(m.getBatchSize());
				
				dispose();
				new BrewViewRecommend(m, c, volume);
			}
		
		});
		Missingbutton.addActionListener(new ActionListener() {
			//private BrewModel bm;
			//private BrewController bc;

			@Override
			public void actionPerformed(ActionEvent e) {
				 
				ArrayList<RecipeModel> MissingRecipe = c.missing();
				
				if(MissingRecipe == null) {
					
					
				}else {
					
					m.setRecommandRecipe(MissingRecipe);
					
					
				}
				
				dispose();
					
				new BrewViewMissing(m, c);
				}
		
		});
		btnBack.addActionListener(new ActionListener() {
			private HomeModel hm;
			private HomeController hc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new HomeView(hm, hc);
				}
			});
	}
	
	
}
