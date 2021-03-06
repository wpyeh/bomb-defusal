import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

class LightSupervisorComponents extends BaseMiniGameClient {
	private final int GAME_ID = 1;
	
	boolean[] lights = new boolean[6];
	JLabel[] lightLabels = new JLabel[6];
	ImageIcon lightOff;
	ImageIcon lightOn;
	
	//MediaPlayer sfx = new MediaPlayer(new Media("Assets\\Light\\LightSFX.mp3"));
	
	LightSupervisorComponents(BaseClient bc) {
		super(bc);
		if(System.getProperty("os.name").contains("indow")) {
			lightOff = new ImageIcon("Assets\\Light\\LightBulbOff.png");
			lightOn = new ImageIcon("Assets\\Light\\LightBulbOn.png");
		}
		else  {
			lightOff = new ImageIcon("Assets/Light/LightBulbOff.png");
			lightOn = new ImageIcon("Assets/Light/LightBulbOn.png");
		}
		setLayout(new GridLayout());
		for(int i = 0;i < lightLabels.length;i++) {
			lightLabels[i] = new JLabel();
			lightLabels[i].setIcon(lightOn);
			add(lightLabels[i],i);
		}
		setSize(500,500);
		setOpaque(false);
		repaint();
	}

	@Override
	public void parseCommand(String command) {
		if(command.startsWith("WIN")) {
			Lobby.DisableLightGame();
			bc.switchToLobby();
		}
		if(command.startsWith("LIGHT")) {
			String[] inp = command.split(" ");
			for(int i = 0;i < inp[1].length();i++) {
				lights[i] = (inp[1].charAt(i) == '0') ? false : true;
				if(lights[i])
					lightLabels[i].setIcon(lightOn);
				else lightLabels[i].setIcon(lightOff);
			}
			//sfx.play();
			if(solved()) {
				//TODO: Other win stuff?
				bc.sendCommand(GAME_ID+"WIN");
			}
		}
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	private boolean solved() {
		for(int i = 0;i < lights.length;i++)
			if(!lights[i])
				return false;
		return true;
	}
}
