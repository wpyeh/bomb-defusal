import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

class LightSupervisor extends BaseMiniGameClient {
	private final int GAME_ID = 1;
	
	LightSupervisorComponents comps;
	Image background;
	
	//MediaPlayer sfx = new MediaPlayer(new Media("Assets\\Light\\LightSFX.mp3"));
	
	LightSupervisor(BaseClient bc) {
		super(bc);
		try {
			if(System.getProperty("os.name").toLowerCase().contains("indow")) {
				background = ImageIO.read(new File("Assets\\Light\\SupervisorBackground.jpg"));
			}
			else  {
				background = ImageIO.read(new File("Assets/Light/SupervisorBackground.jpg"));
			}
			
			background = background.getScaledInstance(500,500,Image.SCALE_SMOOTH);
		} catch(IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		comps = new LightSupervisorComponents(bc);
		add(comps);
		
	}

	@Override
	public void parseCommand(String command) {
		comps.parseCommand(command);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		
	}
	
}
