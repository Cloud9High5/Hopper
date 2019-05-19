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
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class RecipeView extends JFrame{
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
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	DefaultListModel<String> listmodel = new DefaultListModel<String>() ;
	
	public RecipeView(RecipeModel m, RecipeController c) {
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
		
		textWater = new JTextField();
		textWater.setBounds(113, 142, 33, 31);
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
		panel.add(textMalt);
		
		JLabel lblYeasts = new JLabel("Yeasts");
		lblYeasts.setForeground(new Color(255, 255, 240));
		lblYeasts.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblYeasts.setBounds(299, 183, 78, 21);
		panel.add(lblYeasts);
		
		textHop = new JTextField();
		textHop.setColumns(10);
		textHop.setBounds(387, 143, 33, 31);
		panel.add(textHop);
		
		JLabel lblSugars = new JLabel("Sugars");
		lblSugars.setForeground(new Color(255, 255, 240));
		lblSugars.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblSugars.setBounds(581, 152, 78, 21);
		panel.add(lblSugars);
		
		textYeast = new JTextField();
		textYeast.setColumns(10);
		textYeast.setBounds(387, 180, 33, 31);
		panel.add(textYeast);
		
		JLabel lblAdditives = new JLabel("Additives");
		lblAdditives.setForeground(new Color(255, 255, 240));
		lblAdditives.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblAdditives.setBounds(568, 188, 99, 21);
		panel.add(lblAdditives);
		
		textAdditive = new JTextField();
		textAdditive.setColumns(10);
		textAdditive.setBounds(669, 183, 33, 31);
		panel.add(textAdditive);
		
		JLabel label = new JLabel("kg");
		label.setForeground(new Color(255, 255, 240));
		label.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label.setBounds(158, 142, 33, 21);
		panel.add(label);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(new Color(255, 255, 240));
		lblWater.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblWater.setBounds(38, 143, 65, 21);
		panel.add(lblWater);
		
		textSugar = new JTextField();
		textSugar.setColumns(10);
		textSugar.setBounds(669, 145, 33, 31);
		panel.add(textSugar);
		
		JLabel label_1 = new JLabel("kg");
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_1.setBounds(156, 183, 33, 26);
		panel.add(label_1);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setForeground(new Color(255, 255, 240));
		lblKg.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg.setBounds(430, 148, 33, 21);
		panel.add(lblKg);
		
		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setForeground(new Color(255, 255, 240));
		lblKg_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_1.setBounds(430, 189, 33, 21);
		panel.add(lblKg_1);
		
		JLabel lblKg_2 = new JLabel("kg");
		lblKg_2.setForeground(new Color(255, 255, 240));
		lblKg_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_2.setBounds(712, 152, 33, 21);
		panel.add(lblKg_2);
		
		JLabel lblKg_3 = new JLabel("kg");
		lblKg_3.setForeground(new Color(255, 255, 240));
		lblKg_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblKg_3.setBounds(712, 188, 33, 21);
		panel.add(lblKg_3);
		
		JLabel lblRecipeName = new JLabel("Recipe name:");
		lblRecipeName.setForeground(new Color(255, 255, 240));
		lblRecipeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblRecipeName.setBounds(72, 20, 153, 50);
		panel.add(lblRecipeName);
		
		textName = new JTextField();
		textName.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		textName.setColumns(10);
		textName.setBounds(235, 20, 164, 50);
		panel.add(textName);
		
		JLabel lblAmountsMustEqual = new JLabel("Each percentage should be greater than or equal to 0");
		lblAmountsMustEqual.setForeground(Color.ORANGE);
		lblAmountsMustEqual.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountsMustEqual.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblAmountsMustEqual.setBounds(48, 276, 775, 49);
		panel.add(lblAmountsMustEqual);
		
		JLabel lblSampleVolume = new JLabel("Sample volume:");
		lblSampleVolume.setHorizontalAlignment(SwingConstants.CENTER);
		lblSampleVolume.setForeground(new Color(255, 255, 240));
		lblSampleVolume.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblSampleVolume.setBounds(430, 20, 199, 50);
		panel.add(lblSampleVolume);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		textField.setColumns(10);
		textField.setBounds(626, 20, 63, 50);
		panel.add(textField);
		
		JLabel lblL = new JLabel("L");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setForeground(new Color(255, 255, 240));
		lblL.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblL.setBounds(699, 20, 50, 50);
		panel.add(lblL);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		btnCreate.setBounds(443, 515, 156, 51);
		btnCreate.setForeground(new Color(255, 255, 240));
		btnCreate.setBackground(new Color(160, 82, 45));
		contentPane.add(btnCreate);
		
		JButton btnCheckList = new JButton("Check List");
		btnCheckList.setForeground(new Color(255, 255, 240));
		btnCheckList.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		btnCheckList.setBackground(new Color(160, 82, 45));
		btnCheckList.setBounds(813, 510, 141, 30);
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
		btnCheckList.addActionListener(new ActionListener() {
			private RecipeModel rm;
			private RecipeController rc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new RecipeViewCreate(rm, rc);
				}
			});
		btnCreate.addActionListener(new ActionListener() {
			private NoteModel nm;
			private NoteController nc;
			private RecipeModel rm;
			private RecipeController rc;

			@Override
			public void actionPerformed(ActionEvent e) {
			// Controller decides what the click means.
					try {
						boolean a0, a1, a2, a3, a4, a5, a6;
						a0 = textWater.getText().matches("^\\d+(\\.\\d+)?$");
						a1 = textMalt.getText().matches("^\\d+(\\.\\d+)?$");
						a2 = textHop.getText().matches("^\\d+(\\.\\d+)?$");
						a3 = textYeast.getText().matches("^\\d+(\\.\\d+)?$");
						a4 = textSugar.getText().matches("^\\d+(\\.\\d+)?$");
						a5 = textAdditive.getText().matches("^\\d+(\\.\\d+)?$");
						a6 = textField.getText().matches("^\\d+(\\.\\d+)?$");
						if("".equals(textName.getText()) || "".equals(textWater.getText()) || "".equals(textMalt.getText())
							|| "".equals(textHop.getText()) || "".equals(textYeast.getText()) || "".equals(textSugar.getText())
							|| "".equals(textAdditive.getText()) || "".equals(textField.getText())) {
							new WarningViewBlank();
						}else {
							if(!(a0 && a1 && a2 && a3 && a4 && a5 && a6)) {
								new WarningViewNumber();
							}else{
								RecipeController.insertRecipe(new RecipeModel(textName.getText(),
										Double.parseDouble(textWater.getText())/Double.parseDouble(textField.getText()),Double.parseDouble(textMalt.getText())/Double.parseDouble(textField.getText()),
										Double.parseDouble(textHop.getText())/Double.parseDouble(textField.getText()),Double.parseDouble(textYeast.getText())/Double.parseDouble(textField.getText()),
										Double.parseDouble(textSugar.getText())/Double.parseDouble(textField.getText()),Double.parseDouble(textAdditive.getText())/Double.parseDouble(textField.getText())));
								dispose();
								new RecipeViewCreate(rm, rc);
								new RecipeViewNote(nm, nc, null);
							}
						}
				    } catch (NumberFormatException ne) {
				    	new WarningViewBlank();
				    }
			}
		});
	}
	
}

