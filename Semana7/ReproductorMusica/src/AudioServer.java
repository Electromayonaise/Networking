import java.io.*;
import java.net.*;

public class AudioServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(65478); 
            System.out.println("Servidor de Audio iniciado. Esperando conexión...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String songName = reader.readLine(); // Lee el nombre de la canción enviado por el cliente
                String songPath = System.getProperty("user.dir") + File.separator + ".." + File.separator + "songs" + File.separator + songName + ".wav"; // Construye la ruta completa del archivo de audio
                
                AudioPlayer reproductor = new AudioPlayer();
                reproductor.initiateAudio(new BufferedInputStream(new FileInputStream(songPath))); // Inicia la reproducción del audio

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
