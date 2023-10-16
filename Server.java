import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        // Define the server IP address and port
        String serverIP = "54.145.143.15";
        int serverPort = 80;
        
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server listening on " + serverIP + ":" + serverPort);
            
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to " + clientSocket.getInetAddress());
            
            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Send data to the client
           System.out.println("Hello, client! How are you?");
            
            // Receive data from the client
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);
            
            // Close the client and server sockets
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
