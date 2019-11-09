package com.company;

import java.io.*;
import java.net.*;

public class C_S_Client {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("47.101.161.96", 2000);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            String readLine;
            readLine = sin.readLine();
            while (!readLine.equals("exit")){
                os.println(readLine);
                os.flush();
                System.out.println("Client:" + readLine);
                System.out.println("Server:" + is.readLine());
                readLine = sin.readLine();
            }
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
