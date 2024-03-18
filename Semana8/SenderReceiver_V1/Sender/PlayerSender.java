import java.io.*;
import java.net.*;
import javax.sound.sampled.*;
import java.nio.ByteBuffer;

public class PlayerSender {    
    
    AudioInputStream in; //datos de entrada
	private String route;
    private InetAddress clienteIPAddress;
    private int         clientPort; 
    private DatagramSocket socket;
    private int BUFFER_SIZE = 1024;

	public PlayerSender(String route, DatagramPacket receivePacket, DatagramSocket serverSocket) {
        this.route=route;
        this.clienteIPAddress = receivePacket.getAddress();
        this.clientPort = receivePacket.getPort();
        this.socket = serverSocket;
	}
    //metodo principal para leer el audio y enviarlo
	public void sendAudio() {
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_SIZE+4);

		try {
			File file = new File(route);
			in = AudioSystem.getAudioInputStream(file);
            // Leer los datos de audio y enviarlos en paquetes
            int count = 0;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) != -1) {
                byteBuffer.clear();
                byteBuffer.putInt(count);
                byteBuffer.put(buffer, 0, bytesRead);
                byte data[] = byteBuffer.array();
                
                sendPacket(data);

                System.out.println("Sent packet " + count++);
            }
            byteBuffer.clear();
            byteBuffer.putInt(-1);
            byte data[] = byteBuffer.array();
            sendPacket(data);
            socket.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    //armar el datagram y ponerlo en el socket
    public void sendPacket(byte[] audioData) throws Exception {        
        DatagramPacket packet = new DatagramPacket(audioData, audioData.length, clienteIPAddress, clientPort);
        socket.send(packet);
    }


}