package uni.contactfour.business;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uni.contactfour.dao.PlayerMatchDeserializer;
import uni.contactfour.dao.PlayerMatchSerializer;
import uni.contactfour.gui.GameFrame;

import uni.contactfour.dao.SaveDao;
import uni.contactfour.dao.SaveDaoImpl;
import uni.contactfour.business.PlayerMatchedColumn;


import uni.contactfour.dao.SaveDao;
import uni.contactfour.dao.SaveDaoImpl;
import uni.contactfour.business.PlayerMatchedColumn;

public class Handler extends GUICreator {
	
	static PayerMatch playerMatch;

	public boolean btnStart = false;
	public boolean btnNs = false;
	public boolean btnAbbrechen = false;
	static SaveDao gameState = new SaveDaoImpl();
	static PlayerMatchDeserializer desirialized = new PlayerMatchDeserializer();
	static PlayerMatchSerializer serializer = new PlayerMatchSerializer();
	
	public static ArrayList<PlayerMatchedColumn> playerMatchedColumn = new ArrayList<PlayerMatchedColumn>();
	public static boolean load = false;

	static int scorePlayer1 = 0;
	static int scorePlayer2 = 0;
	static String player1Name, player2Name;

	
	public Handler() {
		new GUICreator();
	}
	public static boolean getCurrentScore(String player1, String player2){
		for(PayerMatch match : desirialized.desirilizeMatches()){
			if(match.getPlayer1().equals(player1) && match.getPlayer2().equals(player2)){
				scorePlayer1 = match.getPlayer1TotalScore();
				scorePlayer2 = match.getPlayer2TotalScore();
				return true;
			}
		}
		scorePlayer1 = 0;
		scorePlayer2 = 0;
		return false;
	}
	public static void noWinner(){
		winnerPanel.looserName.setText("No Winner");
		startMenu.setVisible(false);
		renderer.setVisible(false);
		winnerPanel.setVisible(true);

	}
	public static void winnderFound(String winnerPlyaer, String color, String looserPlayer){
		
		if(color.equals("RED")){
			playerMatch.setPlayer1TotalScore(playerMatch.getPlayer1TotalScore()+1);
			serializer.savePlayersObject(playerMatch);
			
		}
		else{
			playerMatch.setPlayer2TotalScore(playerMatch.getPlayer2TotalScore()+1);
			serializer.savePlayersObject(playerMatch);

		}
		getCurrentScore(playerMatch.getPlayer1(), playerMatch.getPlayer2());

		winnerPanel.looserName.setText(looserPlayer);
		winnerPanel.winnerName.setText(winnerPlyaer);
		startMenu.setVisible(false);
		renderer.setVisible(false);
		winnerPanel.setVisible(true);
		
	}

	public static void pressStart(String player1, String player2) {
		setPlayer1Name(player1);
		setPlayer2Name(player2);
		getCurrentScore(player1,player2);
		playerMatch = new PayerMatch(player1, player2, scorePlayer1, scorePlayer2);
		renderer.setPlayer1(player1);
		renderer.setPlayer2(player2);
		renderer.setPlayer1Score(scorePlayer1);
		renderer.setPlayer2Score(scorePlayer2);
		renderer.activePlayerLabel.setText(player1 + " Move");
		renderer.setPlayer1(player1);
		renderer.setPlayer2(player2);
		startMenu.setVisible(false);
		renderer.setVisible(true);
		renderer.setFocusable(true);
		renderer.requestFocusInWindow();
		if (load == true){
			renderer.setPlayerMatchedColumn(playerMatchedColumn);
			load = false;
		}
	}

	public static void pressNs(String player1, String player2) {
		GameFrame.core.dispose();
		GameFrame.main(null);
	
		startMenu.setVisible(false);
		winnerPanel.setVisible(false);

		if(player1Name.equals(player1)){
			getCurrentScore(player1,player2);
			playerMatch = new PayerMatch(player1, player2, scorePlayer1, scorePlayer2);

			renderer.setPlayer1(player1);
			renderer.setPlayer2(player2);
		renderer.setPlayer1Score(scorePlayer1);
		renderer.setPlayer2Score(scorePlayer2);
		}
		else{
			getCurrentScore(player2,player1);
			playerMatch = new PayerMatch(player2, player1, scorePlayer1, scorePlayer2);


			renderer.setPlayer1(player2);
			renderer.setPlayer2(player1);
			renderer.setPlayer1Score(scorePlayer1);
			renderer.setPlayer2Score(scorePlayer2);
		}

		renderer.activePlayerLabel.setText(playerMatch.getPlayer1() + " Move");
		renderer.setVisible(true);
		renderer.setFocusable(true);
		renderer.requestFocusInWindow();
	}

	public static void pressAbbrechen() {

		GameFrame.core.dispose();
		GameFrame.main(null);
		
		
		startMenu.setVisible(true);
		winnerPanel.setVisible(false);
		renderer.setVisible(false);
		renderer.setFocusable(true);
		renderer.requestFocusInWindow();
	}
	
	public static void pressExit() {

		System.exit(0);
	}

	public static void addPanel(JFrame f, JPanel p) {
		f.add(p);
		p.setVisible(true);
	}
	public static String getPlayer1Name() {
		return player1Name;
	}
	public static void setPlayer1Name(String player1Name) {
		Handler.player1Name = player1Name;
	}
	public static String getPlayer2Name() {
		return player2Name;
	}
	public static void setPlayer2Name(String player2Name) {
		Handler.player2Name = player2Name;
	}

	public static void saveGame(){
		gameState.save(renderer.getPlayerMatchedColumn());
	}	
	public static void loadGame(){		
		playerMatchedColumn = gameState.load();
		load = true;
		pressStart(player1Name, player2Name);
	}
}