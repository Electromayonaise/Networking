import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Crear un socket UDP
        DatagramSocket clientSocket = new DatagramSocket();
        // Obtener la dirección IP del servidor
        InetAddress IPAddress = InetAddress.getByName("localhost");
        System.out.println("Escribe un mensaje al servidor:");
        String dataToSend = sc.nextLine();
        byte[] sendData = dataToSend.getBytes(); // Convertir el mensaje a bytes, pues es lo que se envía
        // Crear un paquete con el mensaje, la dirección IP y el puerto del servidor
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        // Reservar un buffer para recibir el mensaje
        byte[] receiveData = new byte[1024];
        // Construir un paquete para recibir el mensaje
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // Recibir el mensaje
        clientSocket.receive(receivePacket);
        String mensaje = new String(receivePacket.getData());
        System.out.println("Mensaje recibido: " + mensaje);
        // Cerrar el socket
        clientSocket.close();
    }
}
