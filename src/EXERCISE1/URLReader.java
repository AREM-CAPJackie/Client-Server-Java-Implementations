package EXERCISE1;

import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
        URL conveniosLabIsis = new URL("http://laboratorio.is.escuelaing.edu.co:80/index.php?page_id=59#122145119436521");System.out.println("Protocol: " + conveniosLabIsis.getProtocol());        System.out.println("Authority: " + conveniosLabIsis.getAuthority());       System.out.println("Host: " + conveniosLabIsis.getHost());       System.out.println("Port: " + conveniosLabIsis.getPort());       System.out.println("Path: " + conveniosLabIsis.getPath());        System.out.println("Query: " + conveniosLabIsis.getQuery());        System.out.println("File: " + conveniosLabIsis.getFile());       System.out.println("Ref: " + conveniosLabIsis.getRef());
    }
}