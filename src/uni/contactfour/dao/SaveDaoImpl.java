package uni.contactfour.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import uni.contactfour.business.PlayerMatchedColumn;


public class SaveDaoImpl implements SaveDao{
	
	File file;
	
	public void save(ArrayList<PlayerMatchedColumn> board){
		try{
			JFileChooser fc = new JFileChooser();			
			int userSelection = fc.showSaveDialog(null);
			 
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    file = fc.getSelectedFile();
			    System.out.println("Save as file: " + file.getAbsolutePath());						
			
			    FileOutputStream out = new FileOutputStream(file);
			    ObjectOutputStream objectStream = new ObjectOutputStream(out);
			    
			    objectStream.writeObject(board);
			
			    out.close();
			    objectStream.close();
			    
				System.out.println("Game Saved");
			}
			else System.out.println("Saved Canceled");
		}
		catch (Exception e){
			System.out.println("Save Error");
		}
	}

	@Override
	public ArrayList<PlayerMatchedColumn> load() {
		ArrayList<PlayerMatchedColumn> board = new ArrayList<PlayerMatchedColumn>();
		try{
			JFileChooser fc = new JFileChooser();
			
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				file = fc.getSelectedFile();
				System.out.println("Load from file: " + file.getAbsolutePath());
				
				FileInputStream in = new FileInputStream(file);
				ObjectInputStream objectStream = new ObjectInputStream(in);
				
				board = (ArrayList<PlayerMatchedColumn>) objectStream.readObject();
				
				in.close();
				objectStream.close();
				
				System.out.println("Game Loaded");
			}
			else System.out.println("Load Canceled");
		}
		catch (Exception e){
			System.out.println("Load Error");
		}
		return board;
	}
}
