package uni.contactfour.business;

import java.util.ArrayList;

public class CheckWinner {
	public static final int WIDTH = 280;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 3;
	int step = 80;
	ArrayList<Player> players;
	ArrayList<PlayerMatchedColumn> playerMatchedColumn;
	String player1, player2;
	public CheckWinner(){
		
	}
	public CheckWinner(ArrayList<Player> players, ArrayList<PlayerMatchedColumn> playerMatchedColumn, String player1, String player2){
		this.players = players;
		this.playerMatchedColumn = playerMatchedColumn;
		this.player1 = player1;
		this.player2 = player2;
	
	}
	

	public void checkConnectFour(int activeX, int activeY, String activeColor){
	
	//vertical
	PlayerMatchedColumn column = null;
	for(int xAxe = (WIDTH*SCALE)/6+19; xAxe <= 639; xAxe+=step){
		column = new PlayerMatchedColumn(xAxe);
		for(int i = 0; i < 42; i++)			
			if(players.get(i).getPlayer().x == xAxe){
				column.putColorYAxe(players.get(i).getPlayer().y, players.get(i).getColorPlayer());
				column.addNodeToColumn(players.get(i).getColorPlayer());
				column.addYtoYAxeColumn(players.get(i).getPlayer().y);
			}
		playerMatchedColumn.add(column);
	}
	// Horizontal
	int horizontalMatched = 0;
	for(PlayerMatchedColumn col : playerMatchedColumn){
		if(col.horizontalMatched(activeX,activeY,activeColor))
				horizontalMatched++;
		else if(horizontalMatched < 4) horizontalMatched = 0;
			
		if(activeX == col.getxAxe() && col.checkVericalMatch() != null)
			matchTheWinner(activeColor);
	}
	if(horizontalMatched >= 4) {
		matchTheWinner(activeColor);
	}
	
	//Diagonal
	diagonalChecker(activeX,activeY,activeColor);
	
	
			
}

public void diagonalChecker(int activeX, int activeY, String activeColor){
	
	int activeXforRight= activeX + step;
	int activeYupRight = activeY-step;

	int acttiveYdownRight = activeY + step;
	int activeYup= activeY-step;
	
	int activeXforLeft = activeX - step;
	int activeYforLeft = activeY + step;

	int counterDownLeft = 0;
	int counterUpLeft = 0;
	for(int i = playerMatchedColumn.size()-1; i!=-1 ;i--){
		if(playerMatchedColumn.get(i).getxAxe() == activeXforLeft){	
			if(playerMatchedColumn.get(i).getColorYAxe().get(activeYforLeft) != null){
				if(playerMatchedColumn.get(i).getColorYAxe().get(activeYforLeft).equals(activeColor)){
					counterDownLeft++;
					activeYforLeft+=step;
				}else activeYforLeft=0;

			}else{ activeYforLeft=0;
			}
			
			if(playerMatchedColumn.get(i).getColorYAxe().get(activeYup) != null){
			if(playerMatchedColumn.get(i).getColorYAxe().get(activeYup).equals(activeColor)){
				counterUpLeft++;
				activeYup-=step;
			}else activeYup=0;
			}else{ activeYup=0;
			}
			activeXforLeft-=step;
		}
		
	}
	
	int rightUp = 0;
	int rightDown = 0;
	for(int i = 0; i<playerMatchedColumn.size() ;i++){

		if(playerMatchedColumn.get(i).getxAxe() == activeXforRight){	
			if(playerMatchedColumn.get(i).getColorYAxe().get(acttiveYdownRight) != null){
				if(playerMatchedColumn.get(i).getColorYAxe().get(acttiveYdownRight).equals(activeColor)){
					rightDown++;
					acttiveYdownRight+=step;
				}else acttiveYdownRight = 0;
				}
				else{ acttiveYdownRight = 0;
				}
			if(playerMatchedColumn.get(i).getColorYAxe().get(activeYupRight) != null) {
			if(playerMatchedColumn.get(i).getColorYAxe().get(activeYupRight).equals(activeColor)){
				rightUp++;
				activeYupRight-=step;

			}else 	activeYupRight=0;
			}else{ 	activeYupRight=0;
			}
			
			activeXforRight+=step;
		}
		
	}
	if(counterDownLeft + rightUp >= 3){
		System.out.println(activeColor);
		matchTheWinner(activeColor);
	}
	
	if(counterUpLeft + rightDown >= 3){
		System.out.println(activeColor);
		matchTheWinner(activeColor);
	}
	System.out.println(counterDownLeft + " " + counterUpLeft);
	System.out.println(rightDown + " " + rightUp);

	playerMatchedColumn =  new ArrayList<PlayerMatchedColumn>();
}

	public void matchTheWinner(String activeColor){
		if(activeColor.equals("RED")){
		Handler.winnderFound(player1, activeColor, player2);
		}
		else{
			Handler.winnderFound(player2, activeColor, player1);

		}
	}


	public void noWinner() {
		Handler.noWinner();	
	}

}
