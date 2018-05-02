package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8080;
    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started");
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                try {
                    new ServerOneThread(clientSocket);
                } catch (Throwable cause) {
                    System.out.println("connection error: " + cause.getMessage());
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}
