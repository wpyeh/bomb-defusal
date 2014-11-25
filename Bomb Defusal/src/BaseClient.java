import java.awt.CardLayout;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;


abstract class BaseClient extends JFrame
{
	private Socket mySocket; 
	private String myUserName; //This is your role in the game (i.e Supervisor 1))
	private int team;
	private Chat chat; 

	CardLayout mainCardLayout;
	JPanel mainPanel;
	
	public BaseClient()
	{
		Database.initialize();
	}
	//should display warning since you've just been kicked and should move you back to lobby (query server for what should be available) 
	void kick()
	{

	}
	public Chat getChat()
	{
		return chat; 
	}
	public void sendCommand(String command){
		String packet = team + command; //appends team# to beginning of packet
	}
}

