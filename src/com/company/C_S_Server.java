package com.company;

import java.io.*;
import java.net.*;

public class C_S_Server {

    public static void main(String[] args) throws Exception{

        try{
            ServerSocket serverSocket = null;

            try{
                serverSocket = new ServerSocket();
            } catch (Exception e){
                System.out.println("error" + e);
            }

            Socket socket = null;

            try {
                socket = serverSocket.accept();
            } catch (Exception e){
                System.out.println("error" + e);
            }

            String line;

            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:" + is.readLine());
            line = sin.readLine();
            while (! line.equals("exit")){
                os.println(line);
                os.flush();
                System.out.println("Server:" + line);
                System.out.println("Client:" + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
