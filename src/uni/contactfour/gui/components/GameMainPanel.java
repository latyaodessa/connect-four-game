package uni.contactfour.gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uni.contactfour.business.CheckWinner;
import uni.contactfour.business.Player;
import uni.contactfour.business.PlayerMatchedColumn;


public class GameMainPanel extends JPanel implements KeyListener{


	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 280;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 3;
	String player1, player2;
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<PlayerMatchedColumn> playerMatchedColumn = new ArrayList<PlayerMatchedColumn>();
	Graphics g;
	int step = 80;
	int playerStep = 0;
	int activePosition = 0;
	public JLabel activePlayerLabel = new JLabel("");

	int player1Score = 0;
	int player2Score = 0;
	
	public GameMainPanel(){
	
		activePlayerLabel.setBounds(WIDTH, 30, 299, 28);
		activePlayerLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		activePlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activePlayerLabel.setForeground(Color.WHITE);
		add(activePlayerLabel);
		

		for(int i = 0; i < 42; i++)
			players.add(new Player(WIDTH,HEIGHT,SCALE));
		   setActiveNode();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GRAY.darker().darker());
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		g.setFont(new Font("Arial", Font.PLAIN, 20)); 
		g.setColor(Color.WHITE.darker());
		g.drawString(player1, 35,160);
		g.drawString("Total Score", 25,190);
		g.drawString(String.valueOf(player1Score), 65,220);
		
		g.drawString(player2, 730,160);
		g.drawString("Total Score", 720,190);
		g.drawString(String.valueOf(player2Score), 760,220);
	
		paintBoard(g);
		for(int i = 0; i < 42; i++){
			players.get(i).setG(g);
			players.get(i).paint(i, players.get(i).getPlayer().x, players.get(i).getPlayer().y, players.get(i).getPlayer().width, players.get(i).getPlayer().height);
		}


	}
	
	void setActiveNode(){
		players.get(playerStep).getPlayer().x = (WIDTH*SCALE)/6+19;
		players.get(playerStep).getPlayer().y = (HEIGHT*SCALE)/15;
		players.get(playerStep).getPlayer().width = 40;
		players.get(playerStep).getPlayer().height = 40;
	}
	
	public void paintBoard(Graphics g){

		Sprite boardSprite;
		boardSprite = getSprite("boardSprite.png");
		
		int x = (WIDTH*SCALE)/6;
		int y = (HEIGHT*SCALE)/7;
	    for(int i=0; i<6;i++){
	    		for(int j=0; j<7;j++){
	    				boardSprite.draw(g, x, y);
	    				x+=80;
	    		}
	    		x = (WIDTH*SCALE)/6;
	    		y+=80;
	    }
	   
	}
	public Sprite getSprite(String path) {
		BufferedImage sourceImage = null;
			
		try {
			URL url = this.getClass().getClassLoader().getResource(path);
			sourceImage = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));
			
		return sprite;
	}
	@Override
	public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped: "+e);
		
	}
	public int checkPosition(){
		int emptyPosition =  HEIGHT * SCALE-109;
		boolean istThereUnderPosition = true;
		for(int i = 0; i < 42; i++)			
			if(players.get(i).getPlayer().x == players.get(playerStep).getPlayer().x)
				if(players.get(i).getPlayer().y == emptyPosition) 
					istThereUnderPosition=false;
					//players.get(playerStep).getPlayer().y = underPosition;
				if(istThereUnderPosition)	return emptyPosition;
				
				for(int i = 0; i < 42; i++)
					if(players.get(i).getPlayer().x == players.get(playerStep).getPlayer().x && players.get(i).getPlayer().y != HEIGHT * SCALE-109 )
						if(players.get(i).getPlayer().y <= emptyPosition)
							emptyPosition-= 80;
		
				if(emptyPosition == 32)
					return players.get(playerStep).getPlayer().y;
				else	return emptyPosition;
	}
	@Override
	public void keyPressed(KeyEvent e) {
        
		// right
        if(e.getKeyCode() ==39){
        	System.out.println(players.get(0).getPlayer().x + " -> ");

        	if(players.get(playerStep).getPlayer().x < 638.0)
        		players.get(playerStep).getPlayer().x +=step;
         	System.out.println(players.get(0).getPlayer().x);
        }
         //left
        if(e.getKeyCode() ==37){
        	if(players.get(playerStep).getPlayer().x > 159.0)
        		players.get(playerStep).getPlayer().x -=step;
        }
        //down
        if(e.getKeyCode() ==40){
        		
        	if(playerStep>=41){
        		CheckWinner winner = new CheckWinner();
        		winner.noWinner();

        	}
        	
        	int emptyPosition = checkPosition();

        	if(emptyPosition != players.get(playerStep).getPlayer().y){
        		players.get(playerStep).getPlayer().y = emptyPosition;
            	if(playerStep >= 6) {
            		CheckWinner winner = new CheckWinner(players,playerMatchedColumn, player1, player2);
            		winner.checkConnectFour(players.get(playerStep).getPlayer().x, players.get(playerStep).getPlayer().y, players.get(playerStep).getColorPlayer());
            		playerMatchedColumn = new ArrayList<PlayerMatchedColumn>();
            	}
            	playerStep++;
        	setActiveNode();
        	
        	if(players.get(playerStep).getColorPlayer().equals("RED"))
        		activePlayerLabel.setText(player1 + " Move");
        	else
        		activePlayerLabel.setText(player2 + " Move");
        	}

        }
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased: "+e);
		
	}
	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}
	public int getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}
	public ArrayList<PlayerMatchedColumn> getPlayerMatchedColumn(){
		return this.playerMatchedColumn;
	}
	
	public void setPlayerMatchedColumn(ArrayList<PlayerMatchedColumn> playerMatchedColumn){
		this.playerMatchedColumn = playerMatchedColumn;
	}

}
