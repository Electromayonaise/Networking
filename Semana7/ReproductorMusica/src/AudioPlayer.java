import java.io.*;
import javax.sound.sampled.*;

public class AudioPlayer {
    private AudioInputStream in; //datos de entrada
    private SourceDataLine out; //salida a la tarjeta de audio

    public void initiateAudio(InputStream inputStream) {
        try {
            in = AudioSystem.getAudioInputStream(inputStream);
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
}
