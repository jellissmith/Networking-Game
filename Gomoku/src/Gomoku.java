import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class Gomoku {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JButton BtnCon = new JButton("Connect");
		JButton BtnPlay = new JButton("Play");
		Gomoku_Rules game = new Gomoku_Rules();
		Gomoku_P2P player = new Gomoku_P2P();
		BtnCon = game.getBtnConnect();
		BtnCon.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//what happens when you click connect.
				player.setHostName(game.getHostName());
				player.setPortSend(game.getPortSend());
				player.setPortListen(game.getPortList());
				
					System.out.println("Hi");
					Runnable serverTask = new Runnable() {
			            @Override
			            public void run() {
			            	try {
								player.CreateTCPServer();
								System.out.println("Waiting for Player...");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			               
			            }
			        };
			        Thread serverThread = new Thread(serverTask);
			        serverThread.start();
					
				
			}
			
		});
		
		BtnPlay = game.getBtnPlay();
		BtnPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//what happens when you click connect.
				
				try {
					//System.out.println("Hi");
					
					player.setBoard(game.getBoard());
					player.CreateTCPClient();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
			
		});
		
		game.frame.setVisible(true);
		
	}

}
