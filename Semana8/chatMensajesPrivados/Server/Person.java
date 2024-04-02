import java.util.Set;
import java.io.PrintWriter;
import java.net.Socket;

//
public class Person {
    private String name;
    PrintWriter out;

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