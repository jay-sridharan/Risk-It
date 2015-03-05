//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//import org.lwjgl.opengl.ContextAttribs;
//import org.lwjgl.opengl.Display;
//import org.lwjgl.opengl.DisplayMode;
//import org.lwjgl.opengl.PixelFormat;
//
//import de.lessvoid.nifty.nulldevice.NullSoundDevice;
//import de.lessvoid.nifty.renderer.lwjgl.input.LwjglInputSystem;
//import de.lessvoid.nifty.renderer.lwjgl.render.LwjglRenderDevice;
//import de.lessvoid.nifty.tools.TimeProvider;

//public class Main {
//
//	@SuppressWarnings("unused")
//	public Main() {
//		
//		LwjglInputSystem inputSystem = new LwjglInputSystem();
//		try {
//			inputSystem.startup();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		initLWJGL();
//		NiftyGame game = new NiftyGame(
//				 new LwjglRenderDevice(),
//				 new NullSoundDevice(),
//				 inputSystem,
//				 new TimeProvider());
//
//	}
//
//	@SuppressWarnings("unused")
//	public static void main(String[] args) {
//		Main main = new Main();
//		//Test test = new Test();
//		//test.start();
//	}
//	
//	
//	private static void initLWJGL() throws Exception {
//	    DisplayMode currentMode = Display.getDisplayMode();
//	    DisplayMode[] modes = Display.getAvailableDisplayModes();
//	    List<DisplayMode> matching = new ArrayList<DisplayMode>();
//	    for (int i=0; i<modes.length; i++) {
//	      DisplayMode mode = modes[i];
//	      if (mode.getWidth() == WIDTH &&
//	          mode.getHeight() == HEIGHT &&
//	          mode.getBitsPerPixel() == 32 ) {
//	        matching.add(mode);
//	      }
//	    }
//
//	    DisplayMode[] matchingModes = matching.toArray(new DisplayMode[0]);
//	    boolean found = false;
//	    for (int i=0; i<matchingModes.length; i++) {
//	      if (matchingModes[i].getFrequency() == currentMode.getFrequency()) {
//	        Display.setDisplayMode(matchingModes[i]);
//	        found = true;
//	        break;
//	      }
//	    }
//
//	    if (!found) {
//	      Arrays.sort(matchingModes, new Comparator < DisplayMode >() {
//	        public int compare(final DisplayMode o1, final DisplayMode o2) {
//	          if (o1.getFrequency() > o2.getFrequency()) {
//	            return 1;
//	          } else if (o1.getFrequency() < o2.getFrequency()) {
//	            return -1;
//	          } else {
//	            return 0;
//	          }
//	        }
//	      });
//
//	      for (int i=0; i<matchingModes.length; i++) {
//	        Display.setDisplayMode(matchingModes[i]);
//	        break;
//	      }
//	    }
//
//	    int x = (currentMode.getWidth() - Display.getDisplayMode().getWidth()) / 2;
//	    int y = (currentMode.getHeight() - Display.getDisplayMode().getHeight()) / 2;
//	    Display.setLocation(x, y);
//	    Display.setFullscreen(false);
//	    Display.create(new PixelFormat(), new ContextAttribs(3, 2).withProfileCore(true));
//	    Display.setVSyncEnabled(false);
//	    Display.setTitle("Hello Nifty");
//	  }
//}