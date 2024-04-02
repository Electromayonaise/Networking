import java.io.*;
import java.net.*;
import java.util.*;
//esta clase se debe encargar de gestionar los clientes de forma individual
//implementa la interfaz Runnable y en el metodo run valida el nombre de usuario
//agrega el usuario y su canal de comunicacion a la lista de chatters
//permite enviar mensajes a todos los usuarios
class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private String clientName;
    Chatters clientes;
    public ClientHandler(Socket socket,Chatters clientes) {
        //asignar los objetos que llegan a su respectivo atributo en la clase
        //crear canales de entrada in y de salida out para la comunicacion
    }

    @Override
    public void run() {
        String message;
        //implementar la logica que permita soliciar a un cliente un nombre de usuario 
        //verificar que no exista en chatters
        //notificar a los demas clientes que un nuevo usuario se ha unido
        //agregar al nuevo usuario a chatters junto con su canal de salida out
        //notificar al cliente que ha sido aceptado

        //ante un nuevo mensaje de ese cliente, enviar el mensaje a todos los usuarios
        
    }
}
