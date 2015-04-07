import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class StartScreen implements ScreenController {
	private Nifty nifty;

	@Override
	public void bind(Nifty thisnifty, Screen screen) {
		nifty = thisnifty;
	}

	@Override
	public void onStartScreen() {
	}

	@Override
	public void onEndScreen() {
	}

	public void startGame() {
		nifty.gotoScreen("game");
	}

	public void showRules() {
		nifty.gotoScreen("rules");
	}

	public void exitGame() {
		nifty.exit();
	}
	
	public void goToStartScreen(){
		nifty.gotoScreen("start");
	}
	

}