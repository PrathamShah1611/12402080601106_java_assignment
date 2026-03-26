import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            System.out.print("Enter message: ");
            String msg = userInput.readLine();

            output.println(msg);

            String response = input.readLine();
            System.out.println("Server replied: " + response);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
