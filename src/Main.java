import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.renderer.lwjgl.input.LwjglInputSystem;
import de.lessvoid.nifty.renderer.lwjgl.render.LwjglRenderDevice;
import de.lessvoid.nifty.sound.openal.OpenALSoundDevice;
import de.lessvoid.nifty.spi.time.impl.AccurateTimeProvider;


public class Main {

	public Main(){
		 if (!LwjglInitHelper.initSubSystems("Risk It")) {
		      System.exit(0);
		    }
		 Nifty nifty = new Nifty(
			        new LwjglRenderDevice(),
			        new OpenALSoundDevice(),
			        new LwjglInputSystem(),
			        new AccurateTimeProvider());
		 Game game = new Game(nifty);
	}
	
	
	public static void main(final String[] args) throws Exception {
	   Main main = new Main();
	}

}