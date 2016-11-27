import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Canvas;

public class Gomoku_GUI {

	private JLabel HostNamelbl;
	private JLabel Portlbl;
	protected JFrame frame;
	protected JTextField HostNameTextField;
	protected JTextField PortTextField;
	protected Canvas canvasBoard;
	protected JButton btnConnect;
	protected JPanel panel;

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
		frame.setBounds(100, 100, 666, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		HostNameTextField = new JTextField();
		HostNameTextField.setBounds(147, 10, 196, 19);
		frame.getContentPane().add(HostNameTextField);
		HostNameTextField.setColumns(10);
		
		HostNamelbl = new JLabel("HostName (IP): ");
		HostNamelbl.setBounds(12, 12, 117, 15);
		frame.getContentPane().add(HostNamelbl);
		
		Portlbl = new JLabel("Port: ");
		Portlbl.setBounds(361, 12, 70, 15);
		frame.getContentPane().add(Portlbl);
		
		PortTextField = new JTextField();
		PortTextField.setBounds(409, 10, 114, 19);
		frame.getContentPane().add(PortTextField);
		PortTextField.setColumns(10);
		
		createBoard();
		
	}

	public void createBoard()
	{
		panel = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for(int i = 0; i< 9; i++){
					for(int j = 0; j<9; j++){
						//i is the column. j is the row. start in column 1 and fill in 9 rows, etc. [x,y, width, height]
						g.drawRect((i+1)*40, (j+1)*40, 40, 40);
					}
				}
			}
	    };
		panel.setBounds(29, 85, 450, 450);
		frame.getContentPane().add(panel);
		
	}
	
	public void placePiece(String color)
	{
		if(color == "black")
		{
			
			
		}
		
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
