import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Gomoku_P2P {

	String hostName1;
	String hostName2;
	
	int portNumber1;
	int portNumber2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gomoku_P2P temp = new Gomoku_P2P();
		try {
			System.out.println("Hi");
			temp.CreateTCPServer(0, 11111);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	//constructor
	public Gomoku_P2P()
	{
		
		
	}
	
	//TCP Server
	private void CreateTCPServer(int Socket, int port) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(port);
		Socket clientSocket = serverSocket.accept();
		//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String userInput = in.readLine();
		System.out.println("Client said: " + userInput);
		
	}
	
	//TCP Client
	private void CreateTCPClient(int socket) throws IOException
	{
		Socket clientSocket = new Socket("localhost", 11111);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes("Suh dude");
		
		
	}
	
	//set portNumbers for the two players.
	public void setPortNumber(int player, int portNumber)
	{
		
		
	}
	
	//set hostNames for both players.
	public void setHostName(int player, String name)
	{
		
		
	}
	
	//send board to other player to update board and end the turn.
	public void sendBoard()
	{
		
		
	}

}
