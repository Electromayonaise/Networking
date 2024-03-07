import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
     public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        int PUERTO = 12345;

        DataInputStream in; //del cliente al servidor
        DataOutputStream out; //del servidor al cliente
        try{
           servidor = new ServerSocket(PUERTO);
           System.out.println("Servidor iniciado...");
           while(true){
              sc = servidor.accept(); //socket del cliente
              System.out.println("Cliente conectado..");
              in = new DataInputStream(sc.getInputStream());
              out = new DataOutputStream(sc.getOutputStream());
              String msj = in.readUTF();
              System.out.println(msj);

              out.writeUTF("Hola CLIENTE, un saludo desde el servidor");
              sc.close();
              System.out.println("Cliente desconectado");


           }

        }catch(Exception e){

            System.out.println(e.getMessage());
        }
        

        
     }
 


}
