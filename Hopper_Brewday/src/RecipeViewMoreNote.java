import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.text.SimpleDateFormat;
public class RecipeViewMoreNote extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	
	long timemillis = System.currentTimeMillis();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public RecipeViewMoreNote(NoteModel nm, NoteController nc, Integer Rid) {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(122, 85, 639, 355);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		scrollPane.setViewportView(textArea);
		textArea.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Write down your note's name:");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 33));
		lblNewLabel.setBounds(49, 10, 485, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnFinish.setBounds(752, 461, 93, 23);
		contentPane.add(btnFinish);
		
		JLabel time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(Color.ORANGE);
		time.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		time.setBounds(300, 450, 281, 34);
		contentPane.add(time);
		BrewController.setTimer(time);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bahnschrift", Font.BOLD, 21));
		textField_1.setBounds(526, 19, 196, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		btnFinish.addActionListener(new ActionListener() {

			@Override
				public void actionPerformed(ActionEvent e) {
				 // Controller decides what the click means.
				NoteController.insertNote(new NoteModel(textField_1.getText(),textArea.getText(),new Timestamp(timemillis)), Rid);
				dispose();
				}
			});
	}
}
