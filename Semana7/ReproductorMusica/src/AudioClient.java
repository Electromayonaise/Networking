import java.io.*;
import java.net.*;

public class AudioClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 65478);
            System.out.println("Conectado al servidor de Audio.");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese el nombre de la canción:");
            String songName = reader.readLine(); // Lee el nombre de la canción desde la entrada del usuario
            writer.println(songName); // Envía el nombre de la canción al servidor

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

