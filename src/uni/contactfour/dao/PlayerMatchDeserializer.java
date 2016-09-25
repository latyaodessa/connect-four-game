package uni.contactfour.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import uni.contactfour.business.PayerMatch;

public class PlayerMatchDeserializer {
	ArrayList<PayerMatch> desirilizedMatches;

	public PlayerMatchDeserializer() {
		
		desirilizedMatches = new ArrayList<PayerMatch>();
	}


	@SuppressWarnings("unchecked")
	public ArrayList<PayerMatch> desirilizeMatches(){
		
		File matches = new File("matches.ser");
		if(!matches.exists()) {
		   
		    return new ArrayList<PayerMatch>();
		}else {		
		 try{
			 
			   FileInputStream fin = new FileInputStream(matches);
			   fin.available();
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   desirilizedMatches = (ArrayList<PayerMatch>) ois.readObject();
			   ois.close();
			  
			   return desirilizedMatches;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return new ArrayList<PayerMatch>();
		   } 
		}
		
	}

	public ArrayList<PayerMatch> getDesirilizedMatches() {
		return desirilizedMatches;
	}

	public void setDesirilizedMatches(ArrayList<PayerMatch> desirilizedMatches) {
		this.desirilizedMatches = desirilizedMatches;
	}
}
