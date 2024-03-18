import java.io.*;
import java.net.*;

import javax.sound.sampled.*;

public class MusicSender {	   
    //debe pasar el nombre de la cancion en los argumentos
	public static void main(String[] args) throws Exception {
        InetAddress IPAddress = InetAddress.getByName("localhost"); // Dirección IP del servidor en la red local        
        String song = "songs/Song1_16k.wav";
        int PORT = 6789;
        
        DatagramSocket serverSocket = new DatagramSocket(PORT,IPAddress);

        System.out.println("Esperando solicitud del cliente!!");
         //esperar cliente
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        System.out.println("Cliente conectado!! \nEnviando Cancion!!");
        //crear objeto e iniciar envio
        PlayerSender sender = new PlayerSender(song,receivePacket,serverSocket);
        sender.sendAudio();

	}
}
