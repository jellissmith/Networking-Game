import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Gomoku_Rules extends Gomoku_GUI {

	private String hostName = "";
	private String port = "";
	
	private boolean whitesTurn = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public void connect()
	{
		btnConnect = new JButton("Connect");
		btnConnect.setBounds(545, 7, 117, 25);
		frame.getContentPane().add(btnConnect);
	}
	
	public JButton getBtnConnect()
	{
		
		return btnConnect;
	}
	public String getHostName()
	{
		return HostNameTextField.getText();
		
	}
	
	public String getPortNum()
	{
		return PortTextField.getText();
		
	}
	
	public void setHostName(String hostName)
	{
		this.hostName = hostName;
		
	}
	
	public void setPortNum(String port)
	{
		this.port = port;
		
	}
	
}

