import java.util.Scanner;
import MathCalc.*;
import com.zeroc.Ice.*;
import java.util.concurrent.CompletableFuture;

public class Client {

    Scanner scanner;

    public static void main(String[] args) throws java.lang.Exception {
        try(Communicator communicator = Util.initialize(args, "client.config")) {
            ObjectPrx base = communicator.propertyToProxy("server.proxy");
            CalculatorPrx calculator = CalculatorPrx.checkedCast(base);
            if(calculator == null) {
                throw new Error("Invalid proxy");
            }
            System.out.println("Connected to the server");
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;
            while(!exit){
                System.out.println("Choose an operation: ");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                double a, b;
                switch(choice) {
                    case 1:
                        System.out.println("Enter two numbers: ");
                        a = scanner.nextDouble();
                        b = scanner.nextDouble();
                        CompletableFuture<Double> answer = calculator.addAsync(a, b);
                        Double r = answer.get();
                        System.out.println("Result: " + r);
                        break;
                    case 2:
                        System.out.println("Enter two numbers: ");
                        a = scanner.nextDouble();
                        b = scanner.nextDouble();
                        System.out.println("Result: " + calculator.subtract(a, b));
                        break;
                    case 3:
                        System.out.println("Enter two numbers: ");
                        a = scanner.nextDouble();
                        b = scanner.nextDouble();
                        System.out.println("Result: " + calculator.multiply(a, b));
                        break;
                    case 4:
                        System.out.println("Enter two numbers: ");
                        a = scanner.nextDouble();
                        b = scanner.nextDouble();
                        System.out.println("Result: " + calculator.divide(a, b));
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
            scanner.close();
        }
    }
} 