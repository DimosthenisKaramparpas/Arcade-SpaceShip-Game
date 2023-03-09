package sounds;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class GameAudioPlayer {
	private AudioInputStream audioInputStream;
	Clip clip;
	public GameAudioPlayer() {
		loadSpaceAmbient();
	}
	void loadSpaceAmbient() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/audio/lifelike.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			
			clip.start();
		}
		catch (Exception ex) {System.out.println(ex);}
	}
	void increaseSound() {
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(+10.0f);
	}
	void decreaseSound() {
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f);
	}
}
