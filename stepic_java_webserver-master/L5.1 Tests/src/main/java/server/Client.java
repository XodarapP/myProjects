package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", Server.PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("connect to server: " + socket.toString());
            try {
                for (int i = 0; i < 50000; i++) {
                    out.println("Client " + ": " + i);
                    String str = in.readLine();
                    System.out.println(str);
                }
                out.println("Bye.");
            }
            catch (IOException e) {
                System.err.println("IO Exception");
            }
        }catch (Throwable cause) {
            System.out.println("connection error: " + cause.getMessage());
        }

    }
}
