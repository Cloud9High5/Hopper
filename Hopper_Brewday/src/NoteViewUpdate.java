import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class NoteViewUpdate extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	long timemillis = System.currentTimeMillis();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public NoteViewUpdate(NoteModel m, NoteController c, Integer Nid, Integer Rid) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 738, 433);
		setTitle("Update note");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(612, 357, 93, 23);
		btnFinish.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		contentPane.add(btnFinish);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(98, 77, 536, 246);
		contentPane.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Rename:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel.setBounds(182, 10, 127, 45);
		contentPane.add(lblNewLabel);
		
		JLabel time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(Color.ORANGE);
		time.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		time.setBounds(217, 344, 281, 34);
		contentPane.add(time);
		BrewController.setTimer(time);
		
		JTextField textName = new JTextField();
		textName.setBounds(319, 13, 175, 45);
		contentPane.add(textName);
		textName.setColumns(10);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		btnFinish.addActionListener(new ActionListener() {
			private NoteModel nm;
			private NoteController nc;
			public void actionPerformed(ActionEvent e) {
				try {
					if("".equals(textName.getText()) || "".equals(textArea.getText())) {
						new WarningViewBlank();
					}else {
						NoteController.updateNote(new NoteModel(textName.getText(),textArea.getText(), new Timestamp(timemillis)), Nid, Rid);
						new NoteView(nm, nc);
						dispose();
					}
				}catch (NumberFormatException ne) {
			    	new WarningViewBlank();
			    }
				
			}
		});
	}
}
