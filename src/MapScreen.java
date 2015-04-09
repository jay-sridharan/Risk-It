import java.util.Random;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class MapScreen implements ScreenController {
	private Nifty nifty;
	private Screen screen;

	@Override
	public void bind(Nifty thisnifty, Screen thisscreen) {
		nifty = thisnifty;
		screen = thisscreen;
	}

	@Override
	public void onStartScreen() {

		Element map = screen.findElementByName("map");
		
		String colors[] = {"util/img/bluehex.png",
						   "util/img/yellowhex.png",
						   "util/img/greenhex.png",
						   "util/img/purplehex.png",
						   "util/img/blackhex.png"
		};
		
		double colWidth = 13.67;
		
		for(int i = 0; i < 6; i++){
			int depth = 1;
			while (depth < 9){
				
				int num = randInt(0,4);
				
				double rowpos = i*colWidth;
				double curdepth = depth;
				new ImageBuilder() {{
					 filename(colors[num]);
					 height("10%");
					 width("9%");
					 x(Double.toString(7.5 + rowpos) + "%");
					 y(Double.toString((curdepth *10.04) - 2.505) + "%");
					 }}.build(nifty, screen, map);
					 
					 depth++;
			}
			

			
		}
		
		colWidth = 13.7;

		
		for(int i = 0; i < 6; i++){
			int depth = 1;
			while (depth < 9){
				
				int num = randInt(0,4);
				
				double rowpos = i*colWidth;
				double curdepth = depth;
				new ImageBuilder() {{
					 filename(colors[num]);
					 height("10%");
					 width("9%");
					 x(Double.toString(16.8 - 2.5 + rowpos) + "%");
					 y(Double.toString((curdepth *10.02) + 2.505) + "%");
					 }}.build(nifty, screen, map);
					 
					 depth++;
			}
			

			
		}
		
		
		 
}

	@Override
	public void onEndScreen() {
	}
	
	private static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}


}