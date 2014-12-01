import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class OperatorGUI extends BaseClient{
	private JPanel jpInstruction,jpTwoStageGame_Ope,jpCutWireGame_Ope,jpFindLocationGame_Ope,jpLogicGame_Ope, jplogicRestart_Ope;
	int teamNum;
	
	
	// no lobby panel
	OperatorGUI(int teamNum, Socket s){
		this.setSize(800,500);
		this.setLayout(new BorderLayout());
		
		mySocket = s;
		//initiate all panels
		mainPanel = new JPanel();
		this.teamNum  = teamNum;
		myUserName = "Operator";
		String teamNumStr = teamNum + "";
		jpInstruction = new Instruction(myUserName,teamNumStr);
		
		jpTwoStageGame_Ope = new TwoStageOperator();
		jpCutWireGame_Ope = new CutTheWireOperator();
		jpFindLocationGame_Ope = new FindTheLocationOperator();
		jpLogicGame_Ope = new LogicGameOperator();
		
		mainCardLayout = new CardLayout();		
		mainPanel = new JPanel(mainCardLayout);
		
		mainPanel.add(jpInstruction,"Intruction");
		
		mainPanel.add(jpTwoStageGame_Ope,"TwoStageGame_Operator");
		mainPanel.add(jpCutWireGame_Ope,"CutWireGame_Operator");
		mainPanel.add(jpFindLocationGame_Ope,"FindLocationGame_Operator");
		mainPanel.add(jpLogicGame_Ope,"LogicGame_Operator");
		
		//for logic game
		jplogicRestart_Ope = new LogicGameRestartOperator();
		mainPanel.add(jplogicRestart_Sup,"LogicRestart_Ope");
		
		//other teamNUm
		chat = new Chat(this,(3-teamNum));
		
		add(mainPanel,BorderLayout.CENTER);
		add(chat,BorderLayout.EAST);
		//show instruction page
		mainCardLayout.show(mainPanel,"Instruction");
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		
		setVisible(true);	
	}
}
