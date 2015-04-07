import de.lessvoid.nifty.Nifty;


public class Game {

	public Game(Nifty nifty){
		System.out.println("VALIDATING XML");
		try {
			nifty.validateXml("util/xml/gameGUI.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    nifty.fromXml("util/xml/gameGUI.xml", "start");
	    LwjglInitHelper.renderLoop(nifty, null);
	    LwjglInitHelper.destroy();
	}
	
}
