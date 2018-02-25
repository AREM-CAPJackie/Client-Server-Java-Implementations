/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXERCISE2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;

/**
 *
 * @author 2110805
 */
public class URLDataHtml {
    public static void main(String[] args) throws Exception {
        //FileOutputStream salida = new FileOutputStream("documentacion.html");
        //PrintStream p = new PrintStream(salida);
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
