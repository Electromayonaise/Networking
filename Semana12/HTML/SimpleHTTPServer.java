import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException { 
        ServerSocket serverSocket = new ServerSocket(8080); 
        System.out.println("Servidor escuchando en el puerto 8080..."); 
         
        while (true) { 
            Socket clientSocket = serverSocket.accept(); 
            System.out.println("Nueva conexión entrante: " + clientSocket); 
            // Leer contenido HTML desde un archivo 
            StringBuilder htmlContent = new StringBuilder(); 
            try (BufferedReader br = new BufferedReader(new FileReader("portfolio.html"))) { 
                String line; 
                while ((line = br.readLine()) != null) { 
                    htmlContent.append(line); 
                } 
            } catch (FileNotFoundException e) { 
                System.err.println("Archivo HTML no encontrado"); 
                return; 
            } 
             
            // Enviar respuesta HTTP con contenido HTML del archivo 
            String  httpResponse  =  "HTTP/1.1  200  OK\r\n\r\n"  + htmlContent.toString(); 
            OutputStream outputStream = clientSocket.getOutputStream(); 
            outputStream.write(httpResponse.getBytes("UTF-8")); 
            outputStream.close(); 
        } 
    }
}
