import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Gomoku_Rules extends Gomoku_GUI {

	protected Board panel;
	protected JButton btnPlay;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public Gomoku_Rules()
	{
		btnConnect = new JButton("Listen");
		btnConnect.setBounds(12, 45, 117, 25);
		frame.getContentPane().add(btnConnect);
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(608, 107, 117, 25);
		frame.getContentPane().add(btnPlay);
		
		panel = new Board();
		panel.setBounds(29, 85, 450, 450);
		frame.getContentPane().add(panel);
		
	}

	
	public JButton getBtnConnect()
	{
		
		return btnConnect;
	}
	
	public JButton getBtnPlay()
	{
		return btnPlay;
		
	}
	public String getHostName()
	{
		return HostNameTextField.getText();
		
	}
	
	public int getPortList()
	{
		return Integer.parseInt(RecTextField.getText());
		
	}

	public int getPortSend()
	{
		return Integer.parseInt(SendTextField.getText());
	}
	
	public Board getBoard()
	{
		return panel;
		
	}
	
	
	
	
}//end Gomoku Rules.


