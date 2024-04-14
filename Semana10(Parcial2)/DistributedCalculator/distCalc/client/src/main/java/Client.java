public class Client {

    public static void main(String[] args) {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args)) {
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("DistributedCalculator:tcp -h localhost -p 10000");
            CalculatorPrx calculator = CalculatorPrx.checkedCast(base);
            if(calculator == null) {
                throw new Error("Invalid proxy");
            }
            System.out.println("1 + 2 = " + calculator.add(1, 2));
            System.out.println("1 - 2 = " + calculator.sub(1, 2));
            System.out.println("1 * 2 = " + calculator.mul(1, 2));
            System.out.println("1 / 2 = " + calculator.div(1, 2));
        }
    }
} 