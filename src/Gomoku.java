import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Gomoku {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JButton BtnCon = new JButton("Connect");
		Gomoku_Rules game = new Gomoku_Rules();
		Gomoku_P2P player = new Gomoku_P2P();
		game.connect();
		BtnCon = game.getBtnConnect();
		BtnCon.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//what happens when you click connect.
				game.setHostName(game.getHostName());
				game.setPortNum(game.getPortNum());
			}
			
		});
		
		game.frame.setVisible(true);
		
	}

}
