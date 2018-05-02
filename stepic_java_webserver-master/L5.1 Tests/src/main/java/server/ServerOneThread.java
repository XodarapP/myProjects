package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerOneThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerOneThread(Socket socket) throws IOException{
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        start();
    }

    @Override
    public void run(){
        try {
            while (true) {
                String inputLine = in.readLine();
                //System.out.println("Server :" + inputLine);
                //System.out.println("Thread :" + Thread.currentThread().toString());
                if (inputLine.equals("Bye.")){
                    break;
                }
                else {
                    out.println(inputLine);
                    //Thread.sleep(1000);
                }
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket not closed, reason: " + e.getMessage());;
            }
        }
    }
}
