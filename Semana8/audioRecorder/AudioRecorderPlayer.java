import javax.sound.sampled.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class AudioRecorderPlayer {
    private static  int SAMPLE_RATE = 16000; // Frecuencia de muestreo en Hz
    private static  int SAMPLE_SIZE_IN_BITS = 16; // Tamaño de muestra en bits
    private static  int CHANNELS = 1; // Mono
    private static  boolean SIGNED = true; // Muestras firmadas
    private static  boolean BIG_ENDIAN = false; // Little-endian

    public static void main(String[] args) {
        //Iniciar variables y objetos necesarios para definir formato y buffer donde se guardara el audio
        int duration = 5; //cuantos segundos vamos a grabar?
        AudioFormat format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE_IN_BITS, CHANNELS, SIGNED, BIG_ENDIAN);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        //iniciar objeto de grabacion de audio
        RecordAudio recorder = new RecordAudio(format, duration,byteArrayOutputStream);
        Thread recorderTrh   = new Thread(recorder);
        recorderTrh.start();
        //esperar a que la grabacion termine
        try{
            recorderTrh.join();
        }catch(Exception e){
            //TODO
        }

        // Reproducir el audio grabado
        byte[] audioData = byteArrayOutputStream.toByteArray();
        PlayerRecording player = new PlayerRecording(format);
        player.initiateAudio(audioData);
        
    }

    
}
