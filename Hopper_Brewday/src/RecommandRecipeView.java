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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

public class RecommandRecipeView extends JFrame{
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
	long timemillis = System.currentTimeMillis();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public RecommandRecipeView(BrewModel m, BrewController c, double volume) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Recipe");
		setBounds(100, 100, 1048, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Recipe");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_1.setBounds(279, 0, 484, 123);
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBounds(82, 150, 872, 354);
		contentPane.add(panel);
		panel.setLayout(null);
			
		JLabel lblMalts = new JLabel("Malts");
		lblMalts.setForeground(new Color(255, 255, 240));
		lblMalts.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblMalts.setBounds(40, 188, 63, 21);
		panel.add(lblMalts);
		
		//get recipe
		RecipeModel recipe = m.getRecipe();
		Double[] amounts =c.convert(recipe);
		
    	recipe.setWaterQuantity(amounts[0]);
    	recipe.setMaltQuantity(amounts[1]);
    	recipe.setHopQuantity(amounts[2]);
    	recipe.setYeastQuantity(amounts[3]);
    	recipe.setSugarQuantity(amounts[4]);
    	recipe.setAdditiveQuantity(amounts[5]);
		
		textWater = new JTextField();
		textWater.setBounds(113, 142, 76, 31);
		textWater.setEditable(false);
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
		textMalt.setBounds(113, 182, 76, 31);
		textMalt.setEditable(false);
		textMalt.setText(String.valueOf(recipe.getMaltQuantity()));
		panel.add(textMalt);
		
		JLabel lblYeasts = new JLabel("Yeasts");
		lblYeasts.setForeground(new Color(255, 255, 240));
		lblYeasts.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblYeasts.setBounds(299, 183, 78, 21);
		panel.add(lblYeasts);
		
		textHop = new JTextField();
		textHop.setColumns(10);
		textHop.setBounds(376, 142, 71, 31);
		textHop.setEditable(false);
		textHop.setText(String.valueOf(recipe.getHopQuantity()));
		panel.add(textHop);
		
		JLabel lblSugars = new JLabel("Sugars");
		lblSugars.setForeground(new Color(255, 255, 240));
		lblSugars.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblSugars.setBounds(581, 152, 78, 21);
		panel.add(lblSugars);
		
		textYeast = new JTextField();
		textYeast.setColumns(10);
		textYeast.setBounds(376, 179, 71, 31);
		textYeast.setEditable(false);
		textYeast.setText(String.valueOf(recipe.getYeastQuantity()));
		panel.add(textYeast);
		
		JLabel lblAdditives = new JLabel("Additives");
		lblAdditives.setForeground(new Color(255, 255, 240));
		lblAdditives.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblAdditives.setBounds(568, 188, 99, 21);
		panel.add(lblAdditives);
		
		textAdditive = new JTextField();
		textAdditive.setColumns(10);
		textAdditive.setBounds(669, 183, 62, 31);
		textAdditive.setEditable(false);
		textAdditive.setText(String.valueOf(recipe.getAdditiveQuantity()));
		panel.add(textAdditive);
		
		JLabel label = new JLabel("kg");
		label.setForeground(new Color(255, 255, 240));
		label.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label.setBounds(199, 143, 33, 21);
		panel.add(label);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(new Color(255, 255, 240));
		lblWater.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblWater.setBounds(38, 143, 65, 21);
		panel.add(lblWater);
		
		textSugar = new JTextField();
		textSugar.setColumns(10);
		textSugar.setBounds(669, 145, 62, 31);
		textSugar.setEditable(false);
		textSugar.setText(String.valueOf(recipe.getSugarQuantity()));
		panel.add(textSugar);
		
		JLabel label_1 = new JLabel("kg");
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_1.setBounds(199, 188, 33, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("kg");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_2.setBounds(463, 146, 33, 21);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("kg");
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_3.setBounds(463, 188, 33, 21);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("kg");
		label_4.setForeground(new Color(255, 255, 240));
		label_4.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_4.setBounds(741, 152, 33, 21);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("kg");
		label_5.setForeground(new Color(255, 255, 240));
		label_5.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_5.setBounds(741, 188, 33, 21);
		panel.add(label_5);
		
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
		textName.setEditable(false);
		textName.setText(recipe.getName());
		panel.add(textName);
		
		/*JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		btnCreate.setBounds(443, 515, 156, 51);
		btnCreate.setForeground(new Color(255, 255, 240));
		btnCreate.setBackground(new Color(160, 82, 45));
		contentPane.add(btnCreate);*/
		
		JButton btnCheckList = new JButton("Save");
		btnCheckList.setForeground(new Color(255, 255, 240));
		btnCheckList.setFont(new Font("Bahnschrift", Font.BOLD, 29));
		btnCheckList.setBackground(new Color(160, 82, 45));
		btnCheckList.setBounds(435, 520, 171, 68);
		contentPane.add(btnCheckList);
		
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
		//set visible
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		btnCheckList.addActionListener(new ActionListener() {
			private HomeModel hm;
			private HomeController hc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				BrewController.insertHistory(new HistoryModel(new Timestamp(timemillis), volume, recipe.getWaterQuantity(), recipe.getMaltQuantity(), recipe.getHopQuantity(), recipe.getYeastQuantity(), recipe.getSugarQuantity(), recipe.getAdditiveQuantity()));
				dispose();
				new HomeView(hm, hc);
				}
			});
		
	}

	
}

