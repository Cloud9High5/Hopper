import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MissingIngredientView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textWater;
	private JTextField textMalt;
	private JTextField textHop;
	private JTextField textYeast;
	private JTextField textAdditive;
	private JTextField textSugar;
	private JTextField textName;
	/**
	 * Create the frame.
	 */
	DefaultListModel<String> listmodel = new DefaultListModel<String>() ;
	
	public MissingIngredientView(BrewModel m, BrewController c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Recipe");
		setBounds(100, 100, 1048, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Missing Ingredient");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_1.setBounds(279, 0, 484, 123);
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBounds(82, 150, 872, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton buttonBack = new JButton("Home");
		buttonBack.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		buttonBack.setBackground(new Color(160, 82, 45));
		buttonBack.setBounds(902, 559, 93, 23);
		buttonBack.setForeground(new Color(255, 255, 240));
		contentPane.add(buttonBack);
			
		JLabel lblMalts = new JLabel("Malts");
		lblMalts.setForeground(new Color(255, 255, 240));
		lblMalts.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblMalts.setBounds(40, 188, 63, 21);
		panel.add(lblMalts);
		
		
		//get recipe
		RecipeModel recipe = m.getRecipe();
		Double[] amounts =c.sub(recipe);
		for(int count=0;count<amounts.length;count++) {
			if(amounts[count]>=0) {
				amounts[count]=0.0;
			}else {
				amounts[count] = -amounts[count];
			}
		}
		recipe.setWaterQuantity(amounts[0]);
    	recipe.setMaltQuantity(amounts[1]);
    	recipe.setHopQuantity(amounts[2]);
    	recipe.setYeastQuantity(amounts[3]);
    	recipe.setSugarQuantity(amounts[4]);
    	recipe.setAdditiveQuantity(amounts[5]);
		
		
		
		textWater = new JTextField();
		textWater.setBounds(113, 142, 33, 31);
		textWater.setText(String.valueOf(recipe.getWaterQuantity()));
		panel.add(textWater);
		textWater.setColumns(10);
		
		JLabel lblHops = new JLabel("Hops");
		lblHops.setForeground(new Color(255, 255, 240));
		lblHops.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblHops.setBounds(314, 146, 63, 21);
		panel.add(lblHops);
		
		textMalt = new JTextField();
		textMalt.setColumns(10);
		textMalt.setBounds(113, 182, 33, 31);
		textMalt.setText(String.valueOf(recipe.getMaltQuantity()));
		panel.add(textMalt);
		
		JLabel lblYeasts = new JLabel("Yeasts");
		lblYeasts.setForeground(new Color(255, 255, 240));
		lblYeasts.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblYeasts.setBounds(299, 183, 78, 21);
		panel.add(lblYeasts);
		
		textHop = new JTextField();
		textHop.setColumns(10);
		textHop.setBounds(387, 143, 33, 31);
		textHop.setText(String.valueOf(recipe.getHopQuantity()));
		panel.add(textHop);
		
		JLabel lblSugars = new JLabel("Sugars");
		lblSugars.setForeground(new Color(255, 255, 240));
		lblSugars.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblSugars.setBounds(581, 152, 78, 21);
		panel.add(lblSugars);
		
		textYeast = new JTextField();
		textYeast.setColumns(10);
		textYeast.setBounds(387, 180, 33, 31);
		textYeast.setText(String.valueOf(recipe.getYeastQuantity()));
		panel.add(textYeast);
		
		JLabel lblAdditives = new JLabel("Additives");
		lblAdditives.setForeground(new Color(255, 255, 240));
		lblAdditives.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblAdditives.setBounds(568, 188, 99, 21);
		panel.add(lblAdditives);
		
		textAdditive = new JTextField();
		textAdditive.setColumns(10);
		textAdditive.setBounds(669, 183, 33, 31);
		textAdditive.setText(String.valueOf(recipe.getAdditiveQuantity()));
		panel.add(textAdditive);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setForeground(new Color(255, 255, 240));
		lblKg.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg.setBounds(158, 142, 33, 21);
		panel.add(lblKg);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(new Color(255, 255, 240));
		lblWater.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblWater.setBounds(38, 143, 65, 21);
		panel.add(lblWater);
		
		textSugar = new JTextField();
		textSugar.setColumns(10);
		textSugar.setBounds(669, 145, 33, 31);
		textSugar.setText(String.valueOf(recipe.getSugarQuantity()));
		panel.add(textSugar);
		
		JLabel lblKg_3 = new JLabel("kg");
		lblKg_3.setForeground(new Color(255, 255, 240));
		lblKg_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_3.setBounds(156, 183, 33, 21);
		panel.add(lblKg_3);
		
		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setForeground(new Color(255, 255, 240));
		lblKg_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_1.setBounds(430, 148, 33, 21);
		panel.add(lblKg_1);
		
		JLabel lblKg_4 = new JLabel("kg");
		lblKg_4.setForeground(new Color(255, 255, 240));
		lblKg_4.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_4.setBounds(430, 189, 33, 21);
		panel.add(lblKg_4);
		
		JLabel lblKg_2 = new JLabel("kg");
		lblKg_2.setForeground(new Color(255, 255, 240));
		lblKg_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_2.setBounds(712, 155, 33, 21);
		panel.add(lblKg_2);
		
		JLabel lblKg_5 = new JLabel("kg");
		lblKg_5.setForeground(new Color(255, 255, 240));
		lblKg_5.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_5.setBounds(712, 188, 33, 21);
		panel.add(lblKg_5);
		
		JLabel lblRecipeName = new JLabel("Recipe name:");
		lblRecipeName.setForeground(new Color(255, 255, 240));
		lblRecipeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblRecipeName.setBounds(258, 20, 153, 50);
		panel.add(lblRecipeName);
		
		textName = new JTextField();
		textName.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		textName.setColumns(10);
		textName.setBounds(421, 20, 164, 50);
		textName.setText(recipe.getName());
		panel.add(textName);
		
		JLabel time = new JLabel();
		time.setForeground(new Color(255, 255, 240));
		time.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		time.setBounds(830, 20, 179, 30);
		contentPane.add(time);
		BrewController.setTimer(time);
		
		JLabel bgp = new JLabel("");
		bgp.setIcon(new ImageIcon("images\\beer.jpg"));
		bgp.setBounds(0, 0, 1042, 617);
		contentPane.add(bgp);
		this.setLocationRelativeTo(null);
		//set visible
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
	}
	
}

