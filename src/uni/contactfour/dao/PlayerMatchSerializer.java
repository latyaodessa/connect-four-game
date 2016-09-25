package uni.contactfour.dao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import uni.contactfour.business.PayerMatch;

public class PlayerMatchSerializer {
	

	ArrayList<PayerMatch> playerMatchList = new ArrayList<PayerMatch>();
	PlayerMatchDeserializer des = new PlayerMatchDeserializer();

	public PlayerMatchSerializer() {
	}

	
	public void savePlayersObject(PayerMatch playerMatch){
		playerMatchList = des.desirilizeMatches();
		boolean existence = false;
		
		for(PayerMatch match : playerMatchList){
			if(match.getPlayer1().equals(playerMatch.getPlayer1()) && match.getPlayer2().equals(playerMatch.getPlayer2())){
				existence = true;
				match.setPlayer1TotalScore(playerMatch.getPlayer1TotalScore());	
				match.setPlayer2TotalScore(playerMatch.getPlayer2TotalScore());
			}
		}
		
		if(!existence)
			playerMatchList.add(playerMatch);
		
		 try{
			   
				FileOutputStream fout = new FileOutputStream("matches.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(playerMatchList);
				oos.close();
				System.out.println("saved");
				   
			   }catch(Exception ex){
				   ex.printStackTrace();
			   }
	
			
	}

	public ArrayList<PayerMatch> getPlayerMatchList() {
		return playerMatchList;
	}

	public void setPlayerMatchList(ArrayList<PayerMatch> playerMatchList) {
		this.playerMatchList = playerMatchList;
	}

}
