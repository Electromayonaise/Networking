public class Task implements Runnable {
    private int taskId;

    public Task(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Tarea " + taskId + " en ejecución...");
        try {
            // Simulación de un retardo de la tarea
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tarea " + taskId + " completada.");
    }
}

