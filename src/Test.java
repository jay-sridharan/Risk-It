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

public class Test {
	Texture texture;
	/** The fonts to draw to the screen */
	private TrueTypeFont font;
	private TrueTypeFont font2;
	private DisplayMode displayMode;

	/** Boolean flag on whether AntiAliasing is enabled or not */
	private boolean antiAlias = true;

	/**
	 * Start the test
	 */
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

	/**
	 * Initialise the GL display
	 * 
	 * @param width
	 *            The width of the display
	 * @param height
	 *            The height of the display
	 */
	private void initGL() {
		
		try {
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
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glScalef(2.25f, 0.95f, 1f);
		GL11.glMatrixMode(GL11.GL_TEXTURE);
		GL11.glLoadIdentity(); // Make sure we are starting from the identity
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		GL11.glClearDepth(1);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, displayMode.getWidth(), displayMode.getHeight());
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, displayMode.getWidth(), displayMode.getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	/**
	 * Initialise resources
	 */
	public void init() {
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, antiAlias);

		// load font from file
		try {
			InputStream inputStream = ResourceLoader
					.getResourceAsStream("util/fonts/pdark.ttf");

			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(24f); // set font size
			font2 = new TrueTypeFont(awtFont2, antiAlias);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Game loop render
	 */
	public void render() {
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
		Color.white.bind();

		font.drawString(100, 50, "THE LIGHTWEIGHT JAVA GAMES LIBRARY",
				Color.yellow);
		font2.drawString(100, 100, "NICE LOOKING FONTS!", Color.green);
	}

	/**
	 * Main method
	 */

}