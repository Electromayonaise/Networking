import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, PORT);
            System.out.println("Conectado al servidor.");

            String message;
            //canal de entrada para el usuario
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); 
            
            //usando el socket, crear los canales de entrada in y salida out
                      
            //solicitar al usuario un alias, o nombre y enviarlo al servidor
            //no debe salir de este bloque hasta que el nombre no sea aceptado
            //al ser aceptado notificar, de lo contrario seguir pidiendo un alias


                 
            //creamos el objeto Lector e iniciamos el hilo que nos permitira estar atentos a los mensajes
            //que llegan del servidor
            //inicar el hilo


            //estar atento a la entrada del usuario para poner los mensajes en el canal de salida out
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
