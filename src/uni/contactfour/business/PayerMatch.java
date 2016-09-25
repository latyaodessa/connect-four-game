package uni.contactfour.business;

import java.io.Serializable;

public class PayerMatch implements Serializable {
	

	private static final long serialVersionUID = 1L;
	String player1, player2;
	int player1TotalScore = 0;
	int player2TotalScore = 0;
	
	
	public PayerMatch(String player1, String player2, int player1TotalScore, int player2TotalScore) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.player1TotalScore = player1TotalScore;
		this.player2TotalScore = player2TotalScore;

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

	public int getPlayer1TotalScore() {
		return player1TotalScore;
	}

	public void setPlayer1TotalScore(int player1TotalScore) {
		this.player1TotalScore = player1TotalScore;
	}

	public int getPlayer2TotalScore() {
		return player2TotalScore;
	}

	public void setPlayer2TotalScore(int player2TotalScore) {
		this.player2TotalScore = player2TotalScore;
	}



}
