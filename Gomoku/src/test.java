import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test temp = new test();
		try {
			temp.CreateTCPClient(0);
			System.out.println("Mom");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TCP Client
	private void CreateTCPClient(int socket) throws IOException
	{
		Socket clientSocket = new Socket("localhost", 11111);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes("Suh dude");
		
		
	}
}
