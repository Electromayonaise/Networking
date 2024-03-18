import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public class PlayerThread extends Thread {
    private static int MAX_ITEMS_IN_QUEUE = 3;
    private int secondsBuffer = 280;
    BlockingQueue<byte[]> buffer;
    private SourceDataLine sourceDataLine;
    private int count = 0;
    private int packes = 0;

    public PlayerThread(AudioFormat audioFormat, int BUFFER_SIZE) {
        try {
            MAX_ITEMS_IN_QUEUE = (int) audioFormat.getSampleRate() * secondsBuffer *
                    audioFormat.getFrameSize()
                    / BUFFER_SIZE;

            System.out.println("Max items in queue: " + MAX_ITEMS_IN_QUEUE);
            buffer = new ArrayBlockingQueue<>(MAX_ITEMS_IN_QUEUE, true);
            sourceDataLine = AudioSystem.getSourceDataLine(audioFormat);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    //agregar bytes a la cola, esto deberia permitir que no se pierdan paquetes
    public void addBytes(byte[] bytes) {
        try {
            count++;
            buffer.put(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //hilo principal, toma los bytes de la cola y los pone en la tarjeta de audio
    public void run() {
        while (true) {
            try {
                if (buffer.isEmpty()) {
                    if (packes > 0) {
                        System.out.println("Packets: write " + packes + " add Count: " + count);
                        packes = 0;
                        count = 0;
                    }
                    Thread.yield();
                    continue;
                }
                byte[] bytes = buffer.take();
                packes++;
                sourceDataLine.write(bytes, 0, bytes.length);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
