import java.net.*;
import java.io.*;

public class MultiThreadedTCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Servidor iniciado.. ");
            while (true) {
                System.out.println("Esperando conexión...");
                Socket sc = serverSocket.accept();
                System.out.println("Cliente conectado.. ");
                ClientHandler ch = new ClientHandler(sc);
                ch.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // serverSocket.close();

    }
}

class ClientHandler extends Thread {
    Socket sc;

    public ClientHandler(Socket sc) {
        this.sc = sc;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            String clientMessage = in.readLine();
            System.out.println("Mensaje del cliente: " + clientMessage);
            out.println("Espere un momento.. ");
            clientMessage = in.readLine();
            System.out.println("Mensaje del cliente: " + clientMessage);
            Thread.sleep(5000);
            out.println("Gracias por conectarse.. ");
            sc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
         