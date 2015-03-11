import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class DrawHex {
	
	
	
	public void start() {
		displayMode = Display.getDesktopDisplayMode();
		initGL();
		init();

		while (true) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			render();

			Display.update();
			Display.sync(100);

			if (Display.isCloseRequested()) {
				Display.destroy();
				System.exit(0);
			}
		}
	}
	
	
	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(0.5f, 0.5f, 1.0f);
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
		// draw quad
		GL11.glBegin(GL11.GL_Polygon);
		GL11.glVertex2f(0, 10);
		GL11.glVertex2f(5, 0);
		GL11.glVertex2f(15, 0);
		GL11.glVertex2f(20, 10);
		GL11.glVertex2f(15, 20);
		GL11.glVertex2f(5, 20);
		GL11.glEnd();
		Color.white.bind();

		font.drawString(100, 50, "THE LIGHTWEIGHT JAVA GAMES LIBRARY",
				Color.yellow);
		font2.drawString(100, 100, "NICE LOOKING FONTS!", Color.green);
	}

	/**
	 * Main method
	 */

}
}
	