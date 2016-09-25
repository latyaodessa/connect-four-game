package uni.contactfour.business;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import uni.contactfour.gui.components.GameMainPanel;
import uni.contactfour.gui.components.SMenu;
import uni.contactfour.gui.components.WinnerPanel;

import uni.contactfour.business.PlayerMatchedColumn;


import uni.contactfour.business.PlayerMatchedColumn;
public class GUICreator {
	
	public WinnerPanel getWinnerPanel() {
		return winnerPanel;
	}

	public static void setWinnerPanel(WinnerPanel winnerPanel) {
		GUICreator.winnerPanel = winnerPanel;
	}

	public GameMainPanel getRenderer() {
		return renderer;
	}

	@SuppressWarnings("static-access")
	public void setRenderer(GameMainPanel renderer) {
		this.renderer = renderer;
	}
	public SMenu getStartMenu() {
		return startMenu;
	}

	@SuppressWarnings("static-access")
	public void setStartMenu(SMenu startMenu) {
		this.startMenu = startMenu;
	}

	private static int WIDTH = 800;
	private static int HEIGHT = WIDTH/12*9;
	private static int SCALE = 3;
	private static String NAME = "Connect Four";
	public static Graphics g;
	
	protected static GameMainPanel renderer = new GameMainPanel();
	protected static SMenu startMenu = new SMenu();
	protected static WinnerPanel winnerPanel = new WinnerPanel();

	
	public GUICreator(){
		
		 renderer = new GameMainPanel();
		 startMenu = new SMenu();
		 startMenu.setVisible(true);
		 renderer.setVisible(false);
		 winnerPanel.setVisible(false);
		 
		 renderer.addKeyListener(renderer);
		 renderer.setFocusable(true);
		

	}
	

	public static void addPanel(JFrame f, JPanel p){
		f.add(p);
		p.setVisible(true);
		SwingUtilities.updateComponentTreeUI(f);
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public static int getSCALE() {
		return SCALE;
	}

	public static void setSCALE(int sCALE) {
		SCALE = sCALE;
	}

	public static String getNAME() {
		return NAME;
	}

	public static void setNAME(String nAME) {
		NAME = nAME;
	}
	
	public static ArrayList<PlayerMatchedColumn> getPlayerMatchedColumn(){
		return renderer.getPlayerMatchedColumn();
	}

	
}
