package EXERCISE4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine = null;
        String function = "fun:cos";
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:" + inputLine);
            if("fun:sin".equals(inputLine.trim()) || "fun:cos".equals(inputLine.trim()) || "fun:tan".equals(inputLine.trim())){
                function = inputLine;
                out.println("");
            }
            else{
                if("fun:sin".equals(function)){
                    outputLine = "Respuesta:" + Math.sin(Double.parseDouble(inputLine));                   
                } else if("fun:cos".equals(function)){
                    outputLine = "Respuesta:" + Math.cos(Double.parseDouble(inputLine)); 
                } else{
                    outputLine = "Respuesta:" + Math.tan(Double.parseDouble(inputLine));
                }
                out.println(outputLine);
            }
            
            
            if (outputLine.equals("Respuestas: Bye."))break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
   }
 }