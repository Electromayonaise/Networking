import java.net.*;
import java.util.Scanner;
public class UDPClient {
    //necesita conocer la ip y el puerto del server
    //como el cliente y el server hacen parte del mismo pc
    // se pone local host o lo que equivale a 127.0.0.1
    //el cliente no necesita un puerto especifico
    public static void main(String[] args) throws Exception {
        Scanner reader= new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("172.30.187.204");
        
        String clientMsg="";
        while(clientMsg!="#"){
            clientMsg=reader.next();

            //Convierte la data en bytes
            byte[] sendData = clientMsg.getBytes();


            //reservar un buffer en la memoria para almacenar lo que me lleve si no llega nada, entonces
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

            //no hay verificaciones de que el paquete llegò
            clientSocket.send(sendPacket);
        }


        clientSocket.close();

        reader.close();
    }
}