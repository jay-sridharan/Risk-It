import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * @author jsridha2
 *
 */
public class Game {
	private Texture texture;
	private TrueTypeFont titleFont;
	private DisplayMode displayMode;

	public Game() {
		init();
		render();
		destroy();
	}

	private void init(){
		try {
			displayMode = Display.getDesktopDisplayMode();
			Display.setDisplayMode(displayMode);
			Display.setFullscreen(true);
			Display.create();

			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			
			texture = TextureLoader.getTexture("PNG", ResourceLoader
					.getResourceAsStream("util/img/menuTexture.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			InputStream inputStream = ResourceLoader
					.getResourceAsStream("util/fonts/venus_rising_rg.ttf");

//			Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(48f); // set font size
			titleFont = new TrueTypeFont(awtFont, false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
//		System.out.print(displayMode.getWidth());
		System.out.print(displayMode.getHeight());
		GL11.glLoadIdentity(); // Make sure we are starting from the identity
//		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		GL11.glOrtho(0, displayMode.getWidth() * 0.94f, displayMode.getHeight() * 0.53f, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_TEXTURE);
								// matrix.

		//GL11.glScalef(2.25f, 0.95f, 1f); // Test for Other monitors
		//GL11.glScalef(0.9f, 1f, 1f); 
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);        
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);                    
  
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
        GL11.glClearDepth(1);                                       
  
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private void render(){

		while (!Display.isCloseRequested()) {

			// render OpenGL here
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(0.5f, 0.5f, 1.0f);
			Color.white.bind();
			texture.bind(); // or GL11.glBind(texture.getTextureID());
			// draw quad
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(0, 0);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(Display.getWidth(), 0);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(Display.getWidth(), Display.getHeight());
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(0, Display.getHeight());
			GL11.glEnd();
			String title = "Risk It     ";
			int width = (int)Display.getWidth();
	        float stringWidth = titleFont.getWidth(title);
	        float x = (float)width/2 - (float)stringWidth/2;
	        float y = 50;
//	        System.out.println(x);
//	        System.out.println(width);
			titleFont.drawString(x, y, title,
					Color.white);
			

			Display.update();
		}

	}
	private void destroy(){
		Display.destroy();

	}
	
}
