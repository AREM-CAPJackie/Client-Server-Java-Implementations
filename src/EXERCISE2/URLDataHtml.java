package EXERCISE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class URLDataHtml {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("result.html");
               
        URL google = new URL("http://www.google.com/");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                writer.println(inputLine);
            }
            writer.close();
        } catch (IOException x) {
            System.err.println(x);
        }
        
    }

}
