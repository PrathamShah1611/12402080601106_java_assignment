// Problem Statement:
// TCP Echo Client–Server Program
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running...");

            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String msg;

            // LOOP → keeps server alive
            while ((msg = input.readLine()) != null) {
                System.out.println("Client says: " + msg);

                if (msg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }

                output.println("Echo: " + msg);
            }

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
