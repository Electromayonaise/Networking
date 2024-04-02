import java.io.*;
import java.net.*;

import javax.sound.sampled.*;

public class PlayerRecording {
    
    private AudioFormat format;
    private byte[] audioData; //datos de entrada
	private SourceDataLine out;  //salida a la tarjeta de audio
    private AudioInputStream in;

    public PlayerRecording(AudioFormat format) {
        this.format=format;       
   	}

    public void initiateAudio(byte[] audioData) {
		try {

			in = new AudioInputStream(new ByteArrayInputStream(audioData), format,
                    audioData.length / format.getFrameSize());
            // Abrir línea de salida de audio
            out = AudioSystem.getSourceDataLine(format);
            out.open(format);
            out.start(); // Comenzar la reproducción de audio
            playAudio();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void playAudio() {
		byte[] buffer = new byte[1024];
        int count;
		try {
			
            System.out.println("Reproduciendo...");
			while ((count = in.read(buffer)) != -1) {			
					out.write(buffer, 0, count);				
			}            
            out.drain();
            out.stop();
            out.close();
            in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}