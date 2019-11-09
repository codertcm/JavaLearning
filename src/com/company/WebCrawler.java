package com.company;

import java.net.*;
import java.io.*;

public class WebCrawler {

    public static void main(String[] args) throws Exception {
        URL cs = new URL("http://www.sina.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.openStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    }


}
