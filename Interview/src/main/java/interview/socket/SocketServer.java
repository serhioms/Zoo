package interview.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int portNumber = 4321;

		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			
			Socket clientSocket = serverSocket.accept();
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			
		    String inputLine, outputLine;
            
		    // Initiate conversation with client
		    KnockKnockProtocol kkp = new KnockKnockProtocol();
		    outputLine = kkp.processInput(null);
		    out.println(outputLine);

		    while ((inputLine = in.readLine()) != null) {
		        outputLine = kkp.processInput(inputLine);
		        out.println(outputLine);
		        if (outputLine.equals("Bye."))
		            break;
		    }

		    serverSocket.close();
		    
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
