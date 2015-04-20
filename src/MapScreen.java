import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.ImageRenderer;
import de.lessvoid.nifty.render.NiftyImage;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class MapScreen implements ScreenController {
	private Nifty nifty;
	private Screen screen;
	private Hashtable hextable = new Hashtable();
	private String lastHover = "hex1";
	private String colors[] = { 
			"util/img/hexes/blue.png",
			"util/img/hexes/yellow.png",
			"util/img/hexes/green.png",
			"util/img/hexes/purple.png",
			"util/img/hexes/black.png" };
	private String hovers[] = { 
			"util/img/hexes/bluehover.png",
			"util/img/hexes/yellowhover.png",
			"util/img/hexes/greenhover.png",
			"util/img/hexes/purplehover.png",
			"util/img/hexes/blackhover.png" };
	private String colornames[] = { 
			"blue",
			"yellow",
			"green",
			"purple",
			"black" };
	private String nums[] = { 
			"util/img/nums/1.png",
			"util/img/nums/2.png",
			"util/img/nums/3.png",
			"util/img/nums/4.png",
			"util/img/nums/5.png"};
	private int curPlayer = 1;
	private String curAction = "Select";
	private int maxPlayers = 4;
	private String[] clicked = new String[2];
	private int mapOddCols = 6;
	private int mapEvenCols = 6;
	private int mapHeight = 8;
	@Override
	public void bind(Nifty thisnifty, Screen thisscreen) {
		nifty = thisnifty;
		screen = thisscreen;
	}

	@Override
	public void onStartScreen() {
		System.out.println("START PROGRAM");
		drawMap();
		clicked[0] = "";
		clicked[1] = "";
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
		String color = (String) hextable.get(elementID);
		String path = "util/img/hexes/" + color +".png";

		if((path.equals(colors[curPlayer - 1])&& curAction == "Select")){
			//System.out.println("BLUE CLICKED");
			//System.out.println(elementID);
			path = "util/img/hexes/" + color + "click.png";
			Screen screen = nifty.getCurrentScreen();

			NiftyImage newImage = nifty.getRenderEngine().createImage(path, false);
			Element image = screen.findElementByName(elementID);
			image.getRenderer(ImageRenderer.class).setImage(newImage);		
			clicked[0] = elementID;

			curAction = "Attack";
		}
		else if((!path.equals(colors[curPlayer -1]) && curAction == "Attack")){
			String[] surrounding = getSurroundingTerritories(clicked[0]);
			boolean inArray = Arrays.asList(surrounding).contains(elementID);
			System.out.println("CLICKED[0]");
			System.out.println(clicked[0]);
			System.out.println("---------------");
			for(int i=0;i<6;i++){
				System.out.println(surrounding[i]);
			}
			
			if(color == "black" || !inArray){
				return;
			}
			path = "util/img/hexes/" + color + "click.png";
			Screen screen = nifty.getCurrentScreen();

			NiftyImage newImage = nifty.getRenderEngine().createImage(path, false);
			Element image = screen.findElementByName(elementID);
			image.getRenderer(ImageRenderer.class).setImage(newImage);		
			clicked[1] = elementID;
			//System.out.println("NOT BLUE CLICKED");
			//System.out.println(elementID);

			curAction = "Select";
		}
	}
	
	private String[] getSurroundingTerritories(String elementID) {
		int startingnum = Integer.parseInt(elementID.substring(3, elementID.length()));
		String[] availibleHexes = new String[6];
		System.out.println("startingnum");
		System.out.println(startingnum);
		System.out.println("--------------");
		if(startingnum % 8 >1){
			availibleHexes[0] = "hex" + Integer.toString(startingnum + 1);
			availibleHexes[1] = "hex" + Integer.toString(startingnum - 1);
			availibleHexes[2] = "hex" + Integer.toString(startingnum + mapHeight);
			availibleHexes[3] = "hex" + Integer.toString(startingnum + mapHeight -1);
			availibleHexes[4] = "hex" + Integer.toString(startingnum - mapHeight);
			availibleHexes[5] = "hex" + Integer.toString(startingnum - mapHeight -1);
		}
		else if(startingnum % 8 == 1 && Math.ceil(startingnum/8) % 2 == 0){
			availibleHexes[0] = "hex" + Integer.toString(startingnum + 1);
			availibleHexes[1] = "hex" + Integer.toString(startingnum + mapHeight);
			availibleHexes[2] = "hex" + Integer.toString(startingnum + mapHeight -1);
			availibleHexes[3] = "hex" + Integer.toString(startingnum - mapHeight);
			availibleHexes[4] = "hex" + Integer.toString(startingnum - mapHeight -1);
		}
		else if(startingnum % 8 == 1 && Math.ceil(startingnum/8) % 2 == 1){
			availibleHexes[0] = "hex" + Integer.toString(startingnum + 1);
			availibleHexes[1] = "hex" + Integer.toString(startingnum + mapHeight);
			availibleHexes[2] = "hex" + Integer.toString(startingnum - mapHeight);
		}
		else if(startingnum % 8 == 0 && Math.ceil(startingnum/8) % 2 == 0){
			availibleHexes[0] = "hex" + Integer.toString(startingnum - 1);
			availibleHexes[1] = "hex" + Integer.toString(startingnum + mapHeight);
			availibleHexes[2] = "hex" + Integer.toString(startingnum - mapHeight);
		}
		else if(startingnum % 8 == 0 && Math.ceil(startingnum/8) % 2 == 1){
			availibleHexes[0] = "hex" + Integer.toString(startingnum - 1);
			availibleHexes[1] = "hex" + Integer.toString(startingnum + mapHeight);
			availibleHexes[2] = "hex" + Integer.toString(startingnum + mapHeight -1);
			availibleHexes[3] = "hex" + Integer.toString(startingnum - mapHeight);
			availibleHexes[4] = "hex" + Integer.toString(startingnum - mapHeight -1);
		}
		
		
		return availibleHexes;
	}

	public void hexMouseOver(String elementID){
		//System.out.println("mouseover");
		//System.out.println(clicked[0]);
		//System.out.println(clicked[1]);
		//System.out.println(elementID);
		if(elementID.equals(clicked[0])|| elementID.equals(clicked[1])){
			//System.out.println("EXIT mouseover");
			return;
		}
		
		//System.out.println("CHECK 2");

		String color = (String) hextable.get(lastHover);
		String path = "util/img/hexes/" + color + ".png";
		Screen screen = nifty.getCurrentScreen();
		NiftyImage newImage = nifty.getRenderEngine().createImage(path, false);
		Element image = screen.findElementByName(lastHover);
		if(!lastHover.equals( clicked[0] )&& !lastHover.equals(clicked[1])){
			image.getRenderer(ImageRenderer.class).setImage(newImage);
		}


		color = (String) hextable.get(elementID);
		path = "util/img/hexes/" + color + "hover.png";

		newImage = nifty.getRenderEngine().createImage(path, false);
		image = screen.findElementByName(elementID);
		image.getRenderer(ImageRenderer.class).setImage(newImage);
		
		lastHover = elementID;
		
		//System.out.println("mouseover");
	}
	
	private void drawMap(){
	Element map = screen.findElementByName("map");
		
		double colWidth = 13.67;
		int counter = 1;
		for (int i = 0; i < mapOddCols; i++) {
			int depth = 1;
			while (depth <= mapHeight) {
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

				if(counter % 8 == 0){
					counter+=mapHeight +1;
				}
				else{
					counter++;
				}
				

				
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
		counter = 9;
		for (int i = 0; i < mapEvenCols; i++) {
			int depth = 1;
			while (depth <= mapHeight) {

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
				if(counter % 8 == 0){
					counter+=mapHeight +1;
				}
				else{
					counter++;
				}

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
	
	

}