package com.company;

import java.io.*;
import java.net.*;

public class C_S_Server_Thread {

    public static int clientNum = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        boolean listening = true;

        try {
            serverSocket = new ServerSocket(2000);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 2000");
            System.exit(-1);
        }

        while (listening){
            new ServerThread(serverSocket.accept(), clientNum).start();
            clientNum++;
        }
        serverSocket.close();
    }
}

class ServerThread extends Thread {

    Socket socket = null;
    int clientNum;
    public ServerThread(Socket socket, int num){

        this.socket = socket;
        clientNum = num;
    }

    public void run(){
        try {
            String line;
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            line = sin.readLine();

            while(! line.equals("exit")){
                os.println(line);
                os.flush();
                System.out.println("Server:" + line);
                System.out.println("Client " + clientNum + " : " + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
}
