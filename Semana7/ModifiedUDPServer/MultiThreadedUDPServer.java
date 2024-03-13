import java.net.*;

public class MultiThreadedUDPServer {
    public static void main(String[] args) {
        try {
            InetAddress IPAddress = InetAddress.getByName("172.30.187.204"); // Modificar por la dirección IP de la máquina, o usar InetAddress.getLocalHost()
            DatagramSocket serverSocket = new DatagramSocket(9876, IPAddress);
            System.out.println("Servidor UDP iniciado");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Start a new thread to handle the client request
                new ClientHandler(serverSocket, receivePacket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    DatagramSocket serverSocket;
    DatagramPacket receivePacket;

    public ClientHandler(DatagramSocket serverSocket, DatagramPacket receivePacket) {
        this.serverSocket = serverSocket;
        this.receivePacket = receivePacket;
    }

    public void run() {
        try {
            // Simulating delay
            Thread.sleep(5000);

            String mensaje = new String(receivePacket.getData()).trim();
            System.out.println("Mensaje recibido: " + mensaje);

            InetAddress IPClientAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            byte[] sendData = "Hola desde el servidor".getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPClientAddress, port);
            serverSocket.send(sendPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
