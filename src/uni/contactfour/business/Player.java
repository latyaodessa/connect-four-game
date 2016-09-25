package uni.contactfour.business;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player{

	Rectangle player;
	int step = 80;
	int HEIGHT =0;
	int SCALE = 0;
	int WIDTH = 0;
	Graphics g;
	public Player(int WIDTH, int HEIGHT,int SCALE){
		this.HEIGHT = HEIGHT;
		this.SCALE = SCALE;
		this.WIDTH = WIDTH;
		 player = new Rectangle((WIDTH*SCALE), (HEIGHT*SCALE)/15, 40, 40);
	
	}

public void paint(int i, int x, int y, int width, int height){
	if(i%2 == 0){
		g.setColor(Color.RED);
		colorPlayer = "RED";
	}else{
		g.setColor(Color.YELLOW);
		colorPlayer = "YELLOW";
	}
	g.fillOval(x, y, width, height);
	
}






public String getColorPlayer() {
	return colorPlayer;
}

public void setColorPlayer(String colorPlayer) {
	this.colorPlayer = colorPlayer;
}

String colorPlayer = null;
public Graphics getG() {
	return g;
}

public void setG(Graphics g) {
	this.g = g;
}

public Rectangle getPlayer() {
	return player;
}

public void setPlayer(Rectangle player) {
	this.player = player;
}

}
