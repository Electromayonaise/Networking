import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        InetAddress IPAddress = InetAddress.getByName("172.30.187.204"); // Please keep in mind that this IP address must be updated to your ip address
        // Crear un socket UDP en el puerto 9876
        DatagramSocket serverSocket = new DatagramSocket(9876, IPAddress);
        System.out.println("Servidor UDP iniciado");
        byte[] receiveData = new byte[1024];
        while (true) {
            // Reservar un buffer para recibir el mensaje
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            // Recibir el mensaje
            serverSocket.receive(receivePacket);
            String mensaje = new String(receivePacket.getData());
            System.out.println("Mensaje recibido: " + mensaje);
            // Preparar datos de respuesta
            InetAddress IPClientAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            byte[] sendData = "Hola desde el servidor".getBytes();
            // Crear un paquete con el mensaje, la dirección IP y el puerto del cliente
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPClientAddress, port);
            // Enviar el paquete
            serverSocket.send(sendPacket);
        }
    }
}
