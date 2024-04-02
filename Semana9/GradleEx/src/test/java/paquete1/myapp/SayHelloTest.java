package paquete1.myapp;
import org.junit.jupiter.api.Test;
import paquete1.myapp.SayHello;
import java.io.IOException;

public class SayHelloTest {
    @Test
    public void testSayHello() throws IOException {

        SayHello.main(new String[] { "en" });
    }
}
