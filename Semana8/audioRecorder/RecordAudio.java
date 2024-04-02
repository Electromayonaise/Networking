import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

public class RecordAudio implements Runnable{
    private AudioFormat format;
    private int duration;
    private  ByteArrayOutputStream out; 
    public RecordAudio(AudioFormat format, int duration, ByteArrayOutputStream out){
        this.format = format;
        this.duration= duration;
        this.out    = out;
    }

    @Override
    public void run(){        
        int bytesRead;
        try {
            // Abrir línea de captura de audio
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);
            targetLine.open(format);
            targetLine.start(); // Comenzar la captura de audio
            System.out.println("Grabando durante " + duration +" segundos...");
            // grabar audio durante t segundos
            byte[] buffer = new byte[targetLine.getBufferSize() / 5];
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < TimeUnit.SECONDS.toMillis(duration)) {
                    bytesRead = targetLine.read(buffer, 0, buffer.length);
                    out.write(buffer, 0, bytesRead);
                }
                targetLine.stop();
                targetLine.close();
            
        }catch(Exception e){
          //TODO: handle exception
        }
    }



}