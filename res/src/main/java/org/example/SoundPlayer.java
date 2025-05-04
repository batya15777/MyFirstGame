package org.example;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.IOException;


public class SoundPlayer {

    private Clip clip;

    SoundPlayer(String fileName) {

      try {
         URL soundRL = getClass().getResource("/"+fileName);
         if (soundRL == null){
             System.err.println("File not found: "+fileName);
             return;
         }
         AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundRL);
         clip = AudioSystem.getClip();
         clip.open(audioInput);

       }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void playOne() {

        if (clip != null){
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public void playLoop() {

        if (clip != null){
            clip.loop(clip.LOOP_CONTINUOUSLY);
        }

    }
    public void stop(){
        if (clip != null){
           clip.stop();;
        }
    }




}
