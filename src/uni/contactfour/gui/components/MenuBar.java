package uni.contactfour.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uni.contactfour.business.Handler;


public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	JMenu file = new JMenu("File");
	
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem load = new JMenuItem("Load");
	
	
	int board[][] = new int[7][6];
	
	public MenuBar(){
		
		file.add(save);
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Handler.saveGame();
			}
		});
		
		file.add(load);
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Handler.loadGame();
			}
		});
		
		file.add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		file.add(exit);
		add(file);
		
	}
}
