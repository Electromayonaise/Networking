import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        String HOST = "localhost"; //127.0.0.1
        int PUERTO  = 12345;
        DataInputStream in; //del servidor al cliente
        DataOutputStream out; //del cliente al servidor
        try {
            Socket sc = new Socket(HOST, PUERTO);    
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("Hola SERVIDOR, saludo desde el CLIENTE");
            String msj = in.readUTF();
            System.out.println(msj);

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        






    }
    
}
