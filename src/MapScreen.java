import java.util.Hashtable;
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
	private Hashtable hextable = new Hashtable();

	@Override
	public void bind(Nifty thisnifty, Screen thisscreen) {
		nifty = thisnifty;
		screen = thisscreen;
	}

	@Override
	public void onStartScreen() {

		Element map = screen.findElementByName("map");

		String colors[] = { 
				"util/img/blue.png",
				"util/img/yellow.png",
				"util/img/green.png",
				"util/img/purple.png",
				"util/img/black.png" };
		
		String colornames[] = { 
				"blue",
				"yellow",
				"green",
				"purple",
				"black" };


		String nums[] = { 
				"util/img/nums/1.png",
				"util/img/nums/2.png",
				"util/img/nums/3.png",
				"util/img/nums/4.png",
				"util/img/nums/5.png"};
		
		

		
		double colWidth = 13.67;
		int counter = 1;
		for (int i = 0; i < 6; i++) {
			int depth = 1;
			while (depth < 9) {
				int mycounter = counter;
				int num = randInt(0, 4);
				int num2 = randInt(0, 4);

				double rowpos = i * colWidth;
				double curdepth = depth;
				new ImageBuilder() {
					{
						filename(colors[num]);
						height("80");
						width("95");
						x(Double.toString(7.5 + rowpos) + "%");
						y(Double.toString((curdepth * 10.0) - 2.5) + "%");
						id("hex" + mycounter);
						interactOnClick("hexClick(hex" + mycounter + ")");
						interactOnMouseOver("hexMouseOver(hex" + mycounter + ")");

					}
				}.build(nifty, screen, map);
				
				hextable.put("hex" + counter, colornames[num]);

				counter++;

				
				new ImageBuilder() {
					{
						filename(nums[num2]);
						height("56");
						width("52");
						x(Double.toString(7.5 + 2 + rowpos) + "%");
						y(Double.toString((curdepth * 10.0) - 2.5 +1.6) + "%");
						id("hexnum" + mycounter);
						interactOnClick("hexClick(hex" + mycounter + ")");

					}
				}.build(nifty, screen, map);

				depth++;
			}

		}

		colWidth = 13.7;

		for (int i = 0; i < 6; i++) {
			int depth = 1;
			while (depth < 9) {

				int num = randInt(0, 4);

				int num2 = randInt(0, 4);

				int mycounter = counter;

				double rowpos = i * colWidth;
				double curdepth = depth;
				new ImageBuilder() {
					{
						filename(colors[num]);
						height("80");
						width("95");
						x(Double.toString(16.8 - 2.5 + rowpos) + "%");
						y(Double.toString((curdepth * 10.0) + 2.5) + "%");
						id("hex" + mycounter);
						interactOnClick("hexClick(hex" + mycounter + ")");
						interactOnMouseOver("hexMouseOver(hex" + mycounter + ")");

					}
				}.build(nifty, screen, map);
				hextable.put("hex" + counter, colornames[num]);
				counter++;

				new ImageBuilder() {
					{
						filename(nums[num2]);
						height("56");
						width("52");
						x(Double.toString(16.8 - 2.5 + 2 + rowpos) + "%");
						y(Double.toString((curdepth * 10.0) + 2.50 +1.6) + "%");
						id("hexnum" + mycounter);
						interactOnClick("hexClick(hex" + mycounter + ")");
					}
				}.build(nifty, screen, map);

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

	public void hexClick(String elementID) {
		System.out.println(hextable.get(elementID));
	}
	
	public void hexMouseOver(String elementID){
		
		//NiftyImage newImage = nifty.getRenderEngine().createImage("new-image.png", false);
		//accountAvatar = profileScreen.findElementByName("accountImage");
		//accountAvatar.getRenderer(ImageRenderer.class).setImage(newImage);
		
		System.out.println("mouseover");
	}

}