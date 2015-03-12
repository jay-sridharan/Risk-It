import de.lessvoid.nifty.Nifty;


public class Game {

	public Game(Nifty nifty){
	    nifty.fromXml("util/tutorial.xml", "start");
	    LwjglInitHelper.renderLoop(nifty, null);
	    LwjglInitHelper.destroy();
	}
	
}
