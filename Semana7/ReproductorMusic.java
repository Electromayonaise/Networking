//package cliente;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class ReproductorMusic {
	public static Scanner sc = new Scanner(System.in);
	AudioInputStream in; //datos de entrada
	SourceDataLine out;  //salida a la tarjeta de audio

	public ReproductorMusic() {
		initiateAudio();
	}

	public void initiateAudio(String path) {
		try {
			File file = new File(path);
			in = AudioSystem.getAudioInputStream(file);

			out = AudioSystem.getSourceDataLine(in.getFormat());
			out.open(in.getFormat());
			out.start();
			playAudio();
		} catch (Exception e) {
			// TODO: handle exception
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
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		System.out.println("Ingrese el nombre de la canción: ");
		String song = sc.nextLine();
		String path = "./songs/" + song + ".wav";
		new ReproductorMusic().initiateAudio();
	}
}
