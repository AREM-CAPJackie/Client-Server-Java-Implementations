
package EXERCISE5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
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
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        outputLine = "HTTP/1.1 200 OK \n"
            +"Content-Type: text/html; charset=utf-8\n"
            +"Cache-Control: public, max-age=60, s-maxage=300\n"
            +"Vary: Accept-Encoding\n"
            +"Content-Encoding: raw\n"
            +"Server: DPS/1.3.5\n"
            +"X-SiteId: 2000\n"
            +"Set-Cookie: dps_site_id=2000; path=/\n"
            +"ETag: a1be084ec13bc207c17c49955f875fab\n"
            +"Date: Mon, 26 Feb 2018 21:47:54 GMT\n"
            +"Connection: keep-alive\n"
            +"Transfer-Encoding: chunked\n" 
            +"\n"
            +"3c6f"
            + "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            + "<meta charset=\"UTF-8\">"
            + "<title>Title of the document</title>\n"
            + "</head>"
            + "<body>"
            + "My Web Site"
            + "</body>"
            + "</html>"                                    
            + inputLine;
        out.println(outputLine);       
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}