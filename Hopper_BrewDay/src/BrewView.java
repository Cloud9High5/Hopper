import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BrewView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public BrewView(BrewModel m, BrewController c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Brew");
		setBounds(100, 100, 1048, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setForeground(new Color(160, 82, 45));
		panel.setBackground(SystemColor.info);
		panel.setBounds(157, 85, 728, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton buttonBack = new JButton("Home");
		buttonBack.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		buttonBack.setBackground(new Color(160, 82, 45));
		buttonBack.setBounds(902, 559, 93, 23);
		buttonBack.setForeground(new Color(255, 255, 240));
		contentPane.add(buttonBack);
		
		JLabel time = new JLabel();
		time.setForeground(new Color(255, 255, 240));
		time.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		time.setBounds(830, 20, 175, 30);
		contentPane.add(time);
		BrewController.setTimer(time);
		
		JButton brewButton = new JButton("BREW");
		brewButton.setBounds(267, 291, 194, 73);
		panel.add(brewButton);
		brewButton.setForeground(new Color(255, 255, 240));
		brewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		brewButton.setFont(new Font("Bahnschrift", Font.BOLD, 36));
		brewButton.setBackground(new Color(160, 82, 45));
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolume.setForeground(SystemColor.textInactiveText);
		lblVolume.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lblVolume.setBounds(162, 142, 161, 67);
		panel.add(lblVolume);
		
		JTextField  editorPane_3 = new JTextField();
		editorPane_3.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
		editorPane_3.setToolTipText("0.000");
		editorPane_3.setBounds(333, 142, 62, 67);
		panel.add(editorPane_3);
		
		JLabel lblL = new JLabel("L");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setForeground(SystemColor.textInactiveText);
		lblL.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lblL.setBounds(405, 147, 46, 56);
		panel.add(lblL);
		
		JLabel bgp = new JLabel("New label");
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
		brewButton.addActionListener(new ActionListener() {
		
			private BrewModel bm =new BrewModel(null,null);
			private BrewController bc = new BrewController(bm);
			@Override
				public void actionPerformed(ActionEvent e) {
					
					
					//check
					String input = editorPane_3.getText().toString();
					char[] inputchar = input.toCharArray();
					int length = 0;
					for(int count = 0;count<inputchar.length;count++) {
						int check = 0;
						if((inputchar[count] >='0')&&(inputchar[count]<='9')) {
							length++;
						}
						else if((inputchar[count]=='.')&&(count>0)&&(count<inputchar.length-1)&&(check==0)) {
							length++;
							check =1;
						}
						
					}
					 if(length<inputchar.length) {
				        	new BrewInputWarning();
				    }else{
				
						bm.setBatchSize(Double.valueOf(editorPane_3.getText()));
					
						// Controller decides what the click means.
						dispose();
					
						//m.setBatchSize(Double.valueOf(editorPane_3.getText()));
						
						new BrewSelectView(bm,bc);}
				}
			});
	}
}
