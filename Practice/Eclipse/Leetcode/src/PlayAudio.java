import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayAudio {

	public static void main(String[] args) {
		AudioClip a;
		try {
			a = Applet.newAudioClip(new URL("file:///C:\\Windows\\WinSxS\\amd64_microsoft-windows-shell-sounds_31bf3856ad364e35_10.0.14393.0_none_4486e7adcc3c3b8e\\Alarm01.wav"));
			a.play();
		Thread.sleep(10000);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}