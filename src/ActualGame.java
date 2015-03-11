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
	private x;
	private y;
	private a;
	private b
	
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
		while a < 10;
			x = a * 20
			while b < 10	
				GL11.glBegin(GL11.GL_Polygon);
				GL11.glVertex2f(x, y+10);
				GL11.glVertex2f(x+5, y+0);
				GL11.glVertex2f(15, 0);
				GL11.glVertex2f(20, 10);
				GL11.glVertex2f(15, 20);
				GL11.glVertex2f(5, 20);
		GL11.glEnd();
		Color.white.bind();
	}

	/**
	 * Main method
	 */

}
}
	