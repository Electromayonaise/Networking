import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import javax.sound.sampled.*;

public class MusicReceiver {

	   
    //debe pasar el nombre de la cancion en los argumentos
	public static void main(String[] args) throws Exception {
        InetAddress IPAddress = InetAddress.getByName("localhost"); // Dirección IP del servidor en la red local 
        int PORT = 6789;
        int BUFFER_SIZE = 1024 + 4;       
        DatagramSocket clientSocket = new DatagramSocket();
        PlayerThread playerThread;  //rrepductor usando un hilo para almacenar paquetes y no saturar la tarjeta de audio
        // Configurar el reproductor de audio
        AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, false);
       
        playerThread = new PlayerThread(audioFormat,BUFFER_SIZE);
        playerThread.start();

        // contactar al servidor para que inicie el envio de la cancion
        String mensaje = "Hola servidor, enviame una cancion... #" ;
        byte[] sendData = mensaje.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
        clientSocket.send(sendPacket);

        byte[] buffer = new byte[BUFFER_SIZE];
   
       // Recibir los paquetes y reproducir el audio
       int count = 0;
       while (true) {
           DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
           clientSocket.receive(packet);
           buffer = packet.getData();
           ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
           int packetCount = byteBuffer.getInt();
           if (packetCount == -1) {
               System.out.println("Received last packet " + count);
               break;
           } else {
               byte[] data = new byte[1024];
               byteBuffer.get(data, 0, data.length);
               playerThread.addBytes(data);
               
               System.out.println("Received packet " + packetCount + " current: " + count);

           }
           count++;
       }
       clientSocket.close();

        

	}
}
