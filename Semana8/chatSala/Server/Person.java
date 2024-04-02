import java.util.Set;
import java.io.PrintWriter;
import java.net.Socket;

//objeto que representa un cliente o usuario o persona en el chat
public class Person {
    private String name; //nombre de usuario
    PrintWriter out;    //canal para enviarle mensajes a ese usuario

    public Person(String name, PrintWriter out){
        this.name = name;
        this.out  = out;
    }
   
    public String getName() {
        return name;
    }
    
    public PrintWriter getOut() {
        return out;
    }

    
}