package uni.contactfour.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

import uni.contactfour.business.Handler;
import uni.contactfour.gui.components.MenuBar;


public class GameFrame extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;

	public static GameFrame core;
	Handler handler;

	public static final int WIDTH = 280;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 3;
	public static final String NAME = "ConnectFour";

	int ticks, yMotion;
	boolean motionStart = false;
	int step = 80;
	int playerStep = 0;
	int activePosition = 0;

	public static void main(String [] args){
		core = new GameFrame();
	} 
	public GameFrame(){
		 handler = new Handler();

		Timer timer = new Timer(20, this);

			setTitle("Connect Four");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			add(handler.getStartMenu());
			add(handler.getRenderer());
			add(handler.getWinnerPanel());
		 
		setJMenuBar(new MenuBar());
         setSize(WIDTH * SCALE, HEIGHT * SCALE);
         setLocationRelativeTo(null);
         setResizable(false);
         setVisible(true);

                    
          timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handler.getRenderer().repaint();

	}


	}
	
