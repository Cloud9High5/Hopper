import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RecipeViewCreate extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		public RecipeViewCreate(RecipeModel m, RecipeController c) {
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1048, 646);
			setTitle("Recipe List");
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton buttonBack = new JButton("Home");
			buttonBack.setFont(new Font("Bahnschrift", Font.BOLD, 14));
			buttonBack.setBackground(new Color(160, 82, 45));
			buttonBack.setForeground(new Color(255, 255, 240));
			buttonBack.setBounds(902, 559, 93, 23);
			contentPane.add(buttonBack);
			
			JLabel lblNewLabel_1 = new JLabel("Recipe");
			lblNewLabel_1.setBounds(279, 0, 484, 123);
			contentPane.add(lblNewLabel_1);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(Color.ORANGE);
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 50));
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setFont(new Font("Bahnschrift", Font.BOLD, 19));
			btnUpdate.setBackground(new Color(160, 82, 45));
			btnUpdate.setForeground(new Color(255, 255, 240));
			btnUpdate.setBounds(175, 435, 156, 51);
			contentPane.add(btnUpdate);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Bahnschrift", Font.BOLD, 19));
			btnDelete.setBackground(new Color(160, 82, 45));
			btnDelete.setForeground(new Color(255, 255, 240));
			btnDelete.setBounds(712, 435, 156, 51);
			contentPane.add(btnDelete);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(104, 214, 834, 168);
			contentPane.add(scrollPane);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
			JList list_1 = new JList(c.getAllRecipe());
			list_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			list_1.setModel(new AbstractListModel() {
				String[] values = c.getAllRecipe();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list_1.setSelectedIndex(-1);
			scrollPane.setViewportView(list_1);
			
			JLabel lblIngredient = new JLabel("Recipes list:");
			lblIngredient.setForeground(Color.ORANGE);
			lblIngredient.setBounds(104, 178, 124, 26);
			contentPane.add(lblIngredient);
			lblIngredient.setFont(new Font("Bahnschrift", Font.BOLD, 17));
			
			JButton btnAddNote = new JButton("Add Note");
			btnAddNote.setFont(new Font("Bahnschrift", Font.BOLD, 19));
			btnAddNote.setBackground(new Color(160, 82, 45));
			btnAddNote.setForeground(new Color(255, 255, 240));
			btnAddNote.setBounds(443, 435, 156, 51);
			contentPane.add(btnAddNote);
			
			JLabel bgp = new JLabel("");
			bgp.setIcon(new ImageIcon("images\\beer.jpg"));
			bgp.setBounds(0, 0, 1042, 617);
			contentPane.add(bgp);
			
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
			btnAddNote.addActionListener(new ActionListener() {

				private NoteModel nm;
				private NoteController nc;

				@Override
					public void actionPerformed(ActionEvent e) {
					int id = 0;
					int i = 0;
					int counter = 0;
					String str=list_1.getSelectedValue().toString();
					char[] c = str.toCharArray();
					
					for(i = 0; i < c.length; i++) {
						if(c[i] == ' ') {
							counter = i;
							break;
						}
					}
					String s = "";
					for(i = 0; i < counter; i++) {
						s = s + c[i];
					}
					System.out.print(s);
					id = Integer.parseInt(s);
					new RecipeViewMoreNote(nm, nc, id);
					}
				});
			btnUpdate.addActionListener(new ActionListener() {
				private RecipeModel rm;
				private RecipeController rc;

				@Override
					public void actionPerformed(ActionEvent e) {
					int id = 0;
					int i = 0;
					int counter = 0;
					String str=list_1.getSelectedValue().toString();
					char[] c = str.toCharArray();
					
					for(i = 0; i < c.length; i++) {
						if(c[i] == ' ') {
							counter = i;
							break;
						}
					}
					String s = "";
					for(i = 0; i < counter; i++) {
						s = s + c[i];
					}
					System.out.print(s);
					id = Integer.parseInt(s);
					dispose();
					new RecipeViewUpdate(rm, rc, id);
					}
				});
			btnDelete.addActionListener(new ActionListener() {
				@Override
					public void actionPerformed(ActionEvent e) {
					int id = 0;
					int i = 0;
					int counter = 0;
					String str=list_1.getSelectedValue().toString();
					char[] c = str.toCharArray();
					
					for(i = 0; i < c.length; i++) {
						if(c[i] == ' ') {
							counter = i;
							break;
						}
					}
					String s = "";
					for(i = 0; i < counter; i++) {
						s = s + c[i];
					}
					System.out.print(s);
					id = Integer.parseInt(s);
					RecipeController.deleteRecipe(id);
					list_1.setListData(RecipeController.getAllRecipe());
					}
				});
		}
}
