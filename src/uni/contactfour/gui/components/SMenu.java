package uni.contactfour.gui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
// Start Panel

import uni.contactfour.business.Handler;

public class SMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 280;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 3;

	public SMenu() {

		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStart.setBounds(WIDTH+80, HEIGHT*2-50, 144, 45);

		setBackground(Color.GRAY.darker().darker());
		setLayout(null);
		add(btnStart, BorderLayout.PAGE_END);

		JLabel lblNewLabel = new JLabel("Welcome to Connect Four");
		lblNewLabel.setBounds(WIDTH, 30, 299, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);
		
		
		JLabel player1Label1 = new JLabel("Player 1: Color");
		player1Label1.setBounds(WIDTH, 65, 299, 28);
		player1Label1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		player1Label1.setHorizontalAlignment(SwingConstants.CENTER);
		player1Label1.setForeground(Color.WHITE);
		add(player1Label1);
		
		JTextField player1 = new JTextField();
		player1.setBounds(WIDTH, 120, 299, 28);
		player1.setFont(new Font("Tahoma", Font.BOLD, 23));
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		player1.setForeground(Color.BLACK);
		add(player1);
		
		
		JLabel player1Label2 = new JLabel("Player 2: Color");
		player1Label2.setBounds(WIDTH, 180, 299, 28);
		player1Label2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		player1Label2.setHorizontalAlignment(SwingConstants.CENTER);
		player1Label2.setForeground(Color.WHITE);
		add(player1Label2);
		
		JTextField player2 = new JTextField();
		player2.setBounds(WIDTH, 245, 299, 28);
		player2.setFont(new Font("Tahoma", Font.BOLD, 23));
		player2.setHorizontalAlignment(SwingConstants.CENTER);
		player2.setForeground(Color.BLACK);
		add(player2);


		btnStart.setToolTipText("Test f\u00FCr visibility");
		add(btnStart, BorderLayout.CENTER);

		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(WIDTH+80, HEIGHT*2+20, 144, 45);
		add(btnExit);

		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Handler.pressExit();

			}
		});

		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(!player1.getText().equals("") && !player2.getText().equals(""))
				Handler.pressStart(player1.getText(), player2.getText());
			}

		});
		
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillOval(WIDTH+240, 60, 40, 40);
		g.setColor(Color.YELLOW);
		g.fillOval(WIDTH+240, 170, 40, 40);
	

	}
	
}
