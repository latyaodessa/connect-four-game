package uni.contactfour.business;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerMatchedColumn {
	
	int xAxe;
	HashMap<Integer, String> colorYAxe;
	ArrayList<String> column;
	ArrayList<Integer> yAxeColumn;
	String winnerColor = null;
	public PlayerMatchedColumn(int xAxe){
		colorYAxe = new HashMap<Integer, String>();
		this.xAxe = xAxe;
		column = new ArrayList<String>();
		yAxeColumn = new ArrayList<Integer>();
	}
	
	public void putColorYAxe(int yAxe, String node){
		colorYAxe.put(yAxe, node);
	}
	public void addNodeToColumn(String node){
		column.add(node);
	}
	public void addYtoYAxeColumn(int yAxe){
		yAxeColumn.add(yAxe);
	}
	
	public String checkVericalMatch(){
		int counter = 0;
		for (int i = 0; i < column.size(); i++){
			counter = 0;
			for(int j = i+1; j < column.size();j++){
				if(column.get(i).equals(column.get(j))){
					counter++;
					if(counter == 3)
						return column.get(i);
				}else{
					j=column.size();
					counter = 0;
					
				}
			}
		}
		return null;
	}
	public boolean horizontalMatched(int activeX, int activeY, String activeColor) {
		for(int i = 0; i<column.size();i++)
			if(activeY == yAxeColumn.get(i) && column.get(i).equals(activeColor))
				return true;
		return false;
		
	}
	
	public HashMap<Integer, String> getColorYAxe() {
		return colorYAxe;
	}
	public void setColorYAxe(HashMap<Integer, String> colorYAxe) {
		this.colorYAxe = colorYAxe;
	}
	public ArrayList<String> getColumn() {
		return column;
	}
	public void setColumn(ArrayList<String> column) {
		this.column = column;
	}
	public ArrayList<Integer> getyAxeColumn() {
		return yAxeColumn;
	}
	public void setyAxeColumn(ArrayList<Integer> yAxeColumn) {
		this.yAxeColumn = yAxeColumn;
	}
	public int getxAxe() {
		return xAxe;
	}
	public void setxAxe(int xAxe) {
		this.xAxe = xAxe;
	}
	

}
