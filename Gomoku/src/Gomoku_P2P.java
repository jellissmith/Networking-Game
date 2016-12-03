import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Gomoku_P2P extends Thread{

	InetAddress hostName;

	
	int portListen;
	int portSend;
	protected Board board;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Gomoku_P2P temp = new Gomoku_P2P();
		/*try {
			System.out.println("Hi");
			temp.CreateTCPServer(11111);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
		
	}
	
	//constructor
	public Gomoku_P2P()
	{

		
	}
	
	//TCP Server
	public void CreateTCPServer() throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(portListen);
		int row;
		int col;
		while(true){
			Socket clientSocket = serverSocket.accept();
			//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			//BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			//String userInput = in.readLine();
			//System.out.println("Client said: " + userInput);
			row = in.readInt();
			col = in.readInt();
			
			board.addPiece(row, col);
		}
	}
	
	//TCP Client
	public void CreateTCPClient() throws IOException
	{
		Socket clientSocket = new Socket(hostName, portSend);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeInt(board.getPlayersRow());
		outToServer.writeInt(board.getPlayersCol());
		clientSocket.close();
	}
	
	//set portNumbers for the two players.
	public void setPortListen(int portListen)
	{
		this.portListen = portListen;
		
	}
	
	//set portNumbers for the two players.
	public void setPortSend(int portSend)
	{
		this.portSend = portSend;
			
	}
	
	//set hostNames for both players.
	public void setHostName(String playerAddr)
	{
		try {
			hostName = InetAddress.getByName(playerAddr);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	//send board to other player to update board and end the turn.
	public void setBoard(Board board)
	{
		this.board = board;
		
	}
	public Board getBoard()
	{
		return board;
		
	}
	

}
