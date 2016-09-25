package uni.contactfour.gui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uni.contactfour.business.Handler;

public class WinnerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 280;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 3;

	
	public JLabel winnerName = new JLabel();
	public JLabel looserName = new JLabel();
	
	
	public WinnerPanel() {
				
		JButton btnStart = new JButton("RETRY");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStart.setBounds(WIDTH+80, HEIGHT*2-50, 160, 45);

		setBackground(Color.GRAY.darker().darker());
		setLayout(null);
		add(btnStart, BorderLayout.PAGE_END);

		JLabel lblNewLabel = new JLabel("Winner is");
		lblNewLabel.setBounds(WIDTH, 30, 299, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);
		
		
	
		winnerName.setBounds(WIDTH, 170, 299, 100);
		winnerName.setFont(new Font("Tahoma", Font.BOLD, 70));
		winnerName.setHorizontalAlignment(SwingConstants.CENTER);
		winnerName.setForeground(Color.WHITE);
		add(winnerName);
		
	

		btnStart.setToolTipText("Test f\u00FCr visibility");
		add(btnStart, BorderLayout.CENTER);

		JButton changePlayers = new JButton("CHANGE PLAYERS");
		changePlayers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		changePlayers.setBounds(WIDTH+80, HEIGHT*2+20, 160, 45);
		add(changePlayers);
		
		
		
		
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Handler.pressNs(winnerName.getText(), looserName.getText());

			}
		});

		changePlayers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Handler.pressAbbrechen();
			}
		});
		

	}


}
