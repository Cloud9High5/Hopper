
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public HomeView(HomeModel m, HomeController c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home");
		setBounds(100, 100, 1048, 646);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrewBeer = new JLabel("Brew Day!");
		lblBrewBeer.setForeground(Color.ORANGE);
		lblBrewBeer.setFont(new Font("Arial Black", Font.ITALIC, 50));
		lblBrewBeer.setBounds(361, 10, 317, 71);
		contentPane.add(lblBrewBeer);
		
		JButton button3 = new JButton("Brew");
		button3.setFont(new Font("Bahnschrift", Font.PLAIN, 32));
		button3.setForeground(new Color(210, 180, 140));
		button3.setBackground(new Color(160, 82, 45));
		button3.setBounds(276, 193, 463, 84);
		contentPane.add(button3);
		
		JButton button1 = new JButton("Recipe");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button1.setForeground(new Color(210, 180, 140));
		button1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		button1.setBackground(new Color(160, 82, 45));
		button1.setBounds(174, 385, 103, 47);
		contentPane.add(button1);
		
		JLabel time = new JLabel();
		time.setForeground(new Color(255, 255, 240));
		time.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		time.setBounds(830, 20, 179, 30);
		contentPane.add(time);
		BrewController.setTimer(time);
		
		JButton button2 = new JButton("Ingredient");
		button2.setForeground(new Color(210, 180, 140));
		button2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		button2.setBackground(new Color(160, 82, 45));
		button2.setBounds(314, 385, 150, 47);
		contentPane.add(button2);
		
		JButton button4 = new JButton("Equipment");
		button4.setForeground(new Color(210, 180, 140));
		button4.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		button4.setBackground(new Color(160, 82, 45));
		button4.setBounds(496, 385, 182, 47);
		contentPane.add(button4);
		
		JButton button5 = new JButton("Note");
		button5.setForeground(new Color(210, 180, 140));
		button5.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		button5.setBackground(new Color(160, 82, 45));
		button5.setBounds(706, 385, 103, 47);
		contentPane.add(button5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\beer.jpg"));
		lblNewLabel.setBounds(0, 3, 1040, 612);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		button1.addActionListener(new ActionListener() {
		private RecipeModel rm;
		private RecipeController rc;

		@Override
			public void actionPerformed(ActionEvent e) {
			 // Controller decides what the click means.
			dispose();
			new RecipeView(rm, rc);
			}
		});
		button2.addActionListener(new ActionListener() {
			private IngredientModel im;
			private IngredientController ic;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new IngredientView(im, ic);
				}
			});
		button3.addActionListener(new ActionListener() {
			private BrewModel bm;
			private BrewController bc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new BrewView(bm, bc);
				}
			});
		button4.addActionListener(new ActionListener() {
			private EquipmentModel em;
			private EquipmentController ec;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new EquipmentView(em, ec);
				}
			});
		button5.addActionListener(new ActionListener() {
			private NoteModel nm;
			private NoteController nc;

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				dispose();
				new NoteView(nm, nc);
				}
			});
    }
	
}