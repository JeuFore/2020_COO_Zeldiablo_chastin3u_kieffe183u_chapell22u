package code;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
    
    public static void play(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                System.out.println("oui");
            }
            else {
                System.out.println("La musique demandée n'existe pas");
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("La musique demandée n'a pas pu être chargée");
        }
    }

}
