
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Crear un ThreadPool con un número fijo de hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Agregar tareas al ThreadPool
        for (int i = 1; i <= 5; i++) {
            Runnable task = new Task(i);
            executor.execute(task);
        }

        // Apagar el ThreadPool una vez que se completen todas las tareas
        executor.shutdown();
    }
}
