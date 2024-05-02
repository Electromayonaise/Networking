import java.io.*;
import java.net.*;
import java.util.*;

public class HTTPServer {

    public static void main(String[] args) {
        int port = 8080; // Puerto en el que escucha el servidor
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor HTTP iniciado en el puerto " + port + "...");
            System.out.println("Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                // Manejar la solicitud inicial en un hilo separado
                new RequestHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class RequestHandler extends Thread {
        private Socket clientSocket;

        public RequestHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Leer la solicitud del cliente
                String requestLine = in.readLine();
                System.out.println("Solicitud recibida: " + requestLine);

                // Enviar la página HTML como respuesta
                sendHTMLPage(out);

                // Cerrar el socket del cliente
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendHTMLPage(PrintWriter out) {
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println();
            out.println("<html><head><title>Uso de GET y POST</title></head><body>");
            out.println("<h1>Uso de GET y POST</h1>");
            out.println("<h2>Solicitud GET</h2>");
            out.println("<p>La siguiente solicitud GET enviará un mensaje al servidor:</p>");
            out.println("<form action=\"http://localhost:8080\" method=\"get\">");
            out.println("<input type=\"text\" name=\"message\" placeholder=\"Escribe un mensaje\">");
            out.println("<button type=\"submit\">Enviar GET</button>");
            out.println("</form>");

            out.println("<h2>Solicitud POST</h2>");
            out.println("<p>La siguiente solicitud POST enviará un mensaje al servidor:</p>");
            out.println("<form action=\"http://localhost:8080\" method=\"post\">");
            out.println("<input type=\"text\" name=\"message\" placeholder=\"Escribe un mensaje\">");
            out.println("<button type=\"submit\">Enviar POST</button>");
            out.println("</form>");

            out.println("</body></html>");
        }
    }
}
