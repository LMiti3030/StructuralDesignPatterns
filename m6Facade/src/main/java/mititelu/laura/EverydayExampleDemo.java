package mititelu.laura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class EverydayExampleDemo {

    public static void main(String[] args) {
        try{
            URL url = new URL("http", "www.pluralsight.com", 80, "/author/bryan-hansen");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); //empl Decorator

            String inputLine;

            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine); //should dump the html code - no longer works the same
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
