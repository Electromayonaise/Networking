import com.zeroc.Ice.Current;

public class CalculatorI implements Calculator{

    public int add(int a, int b, Current current) {
        return a + b;
    }

    public int sub(int a, int b, Current current) {
        return a - b;
    }

    public int mul(int a, int b, Current current) {
        return a * b;
    }

    public int div(int a, int b, Current current) {
        return a / b;
    }
}
