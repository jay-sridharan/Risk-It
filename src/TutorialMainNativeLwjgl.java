import java.io.InputStream;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.renderer.lwjgl.input.LwjglInputSystem;
import de.lessvoid.nifty.renderer.lwjgl.render.LwjglRenderDevice;
import de.lessvoid.nifty.sound.openal.OpenALSoundDevice;
import de.lessvoid.nifty.spi.time.impl.AccurateTimeProvider;

public final class TutorialMainNativeLwjgl {

  private TutorialMainNativeLwjgl() {
  }

  public static void main(final String[] args) throws Exception {
    if (!LwjglInitHelper.initSubSystems("Risk It")) {
      System.exit(0);
    }

    // create nifty
    Nifty nifty = new Nifty(
        new LwjglRenderDevice(),
        new OpenALSoundDevice(),
        new LwjglInputSystem(),
        new AccurateTimeProvider());
    nifty.fromXml("util/tutorial.xml", "start");

    // render
    LwjglInitHelper.renderLoop(nifty, null);
    LwjglInitHelper.destroy();
  }
}
