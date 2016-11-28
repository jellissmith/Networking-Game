import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Canvas;

public class Gomoku_GUI {

	private JLabel HostNamelbl;
	private JLabel PortRecievelbl;
	protected JFrame frame;
	protected JTextField HostNameTextField;
	protected JTextField RecTextField;
	protected Canvas canvasBoard;
	protected JButton btnConnect;
	protected JTextField SendTextField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gomoku_GUI window = new Gomoku_GUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gomoku_GUI() {
		createGUI();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 889, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		HostNameTextField = new JTextField();
		HostNameTextField.setBounds(147, 10, 196, 19);
		frame.getContentPane().add(HostNameTextField);
		HostNameTextField.setColumns(10);
		
		HostNamelbl = new JLabel("HostName (IP): ");
		HostNamelbl.setBounds(12, 12, 117, 15);
		frame.getContentPane().add(HostNamelbl);
		
		PortRecievelbl = new JLabel("Port Recieve: ");
		PortRecievelbl.setBounds(361, 12, 114, 15);
		frame.getContentPane().add(PortRecievelbl);
		
		RecTextField = new JTextField();
		RecTextField.setBounds(466, 10, 114, 19);
		frame.getContentPane().add(RecTextField);
		RecTextField.setColumns(10);
		
		JLabel PortSendlbl = new JLabel("port to Send:");
		PortSendlbl.setBounds(585, 12, 136, 15);
		frame.getContentPane().add(PortSendlbl);
		
		SendTextField = new JTextField();
		SendTextField.setBounds(693, 10, 114, 19);
		frame.getContentPane().add(SendTextField);
		SendTextField.setColumns(10);
		
		
	}



	
	
	public int getXCoords()
	{
		return (int) (MouseInfo.getPointerInfo().getLocation().getX() );
		
	}
	
	public int getYCoords()
	{
		return (int) (MouseInfo.getPointerInfo().getLocation().getY() );
		
	}
}
