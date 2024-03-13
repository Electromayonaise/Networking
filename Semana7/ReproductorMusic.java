import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class ReproductorMusic {
    public static Scanner sc = new Scanner(System.in);
    private AudioInputStream in; //datos de entrada
    private SourceDataLine out; //salida a la tarjeta de audio

    public void initiateAudio(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("El archivo especificado no existe.");
                return;
            }
            in = AudioSystem.getAudioInputStream(file);
            out = AudioSystem.getSourceDataLine(in.getFormat());
            out.open(in.getFormat());
            out.start();
            playAudio();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    private void playAudio() {
        byte[] buffer = new byte[1024];
        try {
            int count;
            while ((count = in.read(buffer, 0, buffer.length)) != -1) {
                if (count > 0) {
                    out.write(buffer, 0, count);
                }
            }
            out.drain();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Ingrese el nombre de la canción (sin la extensión .wav): ");
        String song = sc.nextLine();
        String path = "./songs/" + song + ".wav";
        new ReproductorMusic().initiateAudio(path);
    }
}
