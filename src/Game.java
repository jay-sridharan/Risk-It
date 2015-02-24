import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
/**
 * @author jsridha2
 *
 */
public class Game {
	Texture texture;
	public Game() {
		
		try {
			Display.setDisplayMode(Display.getDesktopDisplayMode());
			Display.setFullscreen(true);
			Display.create();

			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			 GL11.glEnable(GL11.GL_TEXTURE_2D);      
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("util/img/menuTexture.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glMatrixMode(GL11.GL_TEXTURE);
		GL11.glLoadIdentity(); // Make sure we are starting from the identity matrix.
		System.out.println(texture.getImageWidth());
		System.out.println(texture.getImageHeight());
		GL11.glScalef(texture.getImageWidth() / Display.getWidth(),texture.getImageHeight() / Display.getHeight(),1);

		while (!Display.isCloseRequested()) {

			// render OpenGL here
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(0.5f, 0.5f, 1.0f);
		    Color.white.bind();
	        texture.bind(); // or GL11.glBind(texture.getTextureID());
			// draw quad
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(0,0);
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(Display.getWidth(),0);
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(Display.getWidth(),Display.getHeight());
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(0,Display.getHeight());
			GL11.glEnd();
			Display.update();
		}

		Display.destroy();
	}

}
