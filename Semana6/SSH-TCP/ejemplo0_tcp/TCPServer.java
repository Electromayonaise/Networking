import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        Socket sc = null; //para aceptar al cliente
        System.out.println("Servidor iniciado.. ");
        PrintWriter out;
        BufferedReader in; 
        while(true){
                System.out.println("Esperando conexión...");
                sc = serverSocket.accept();
        
                out = new PrintWriter(sc.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(sc.getInputStream()));

                String mensajeCliente = in.readLine();
                System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

                out.println(" Mensaje modificado: " + mensajeCliente.toUpperCase());

                sc.close();
        }

        //serverSocket.close();

    }
}
