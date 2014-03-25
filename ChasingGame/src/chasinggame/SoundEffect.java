package chasinggame;

import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class SoundEffect {
    private Clip clip;
    private boolean loop;
    private boolean paused;

    public SoundEffect(String soundFileName) {
        try {
            URL url = this.getClass().getClassLoader()
                    .getResource(soundFileName);
            if (url != null) {
                AudioInputStream audioInputStream = AudioSystem
                        .getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(final boolean loop) {
        this.loop = loop;
        pause();
        if(clip == null) System.out.println("It's null");
        if (clip != null) {
            clip.setFramePosition(0);
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (loop && !paused) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.setFramePosition(0);
                            clip.start();
                        }
                    }
                }
            });
        }
        unpause();
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            paused = true;
            clip.stop();
        }
    }

    public void unpause() {
        paused = false;
        if (clip != null) {
            clip.start();
        }
    }
}

// Possible nice approach to using it
// Create enums representing the sounds you want to play, then play them
// e.g. given the enum defined below call
// SoundEffect.BACKGROUND.play(true);
// SoundEffect.TICK.play(false);

enum SoundEffects {
    TICK("tick.wav"),
    TOCK("tock.wav"),
    CRASH("crash.wav"),
    BACKGROUND("song.wav");

    private SoundEffect sound;

    SoundEffects(String file) {
        sound = new SoundEffect(file);
    }

    public void play(final boolean loop) {
        sound.play(loop);
    }

    public void pause() {
        sound.pause();
    }

    public void unpause() {
        sound.unpause();
    }

    // force all to load on initialization
    static void init() {
        values();
    }
}
                                                                              

    

