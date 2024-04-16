import MathCalc.*;
import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;

public class Server {
    
    public static void main(String[] args) {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "server.config")) {
            ObjectAdapter adapter = communicator.createObjectAdapter("services");
            Object object = new CalculatorI();
            adapter.add(object, Util.stringToIdentity("DistributedCalculator"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}