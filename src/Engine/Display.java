package Engine;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

public class Display {

    private int width = 0;
    private int height = 0;
    private int FPSCap = 0;

    public Display(int w, int h)
    {
        this.width = w;
        this.height = h;
    }
    public void Construct()
    {
        try
        {
            org.lwjgl.opengl.Display.setDisplayMode(new DisplayMode(this.width, this.height));
            org.lwjgl.opengl.Display.create();
            org.lwjgl.opengl.Display.setResizable(true);
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
    }
    public void Update(int newWidth, int newHeight)
    {
        this.width = newWidth;
        this.height = newHeight;
        glViewport( 0, 0, this.width, this.height );
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, this.width, this.height , 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }
    public boolean isCloseRequested()
    {
        return org.lwjgl.opengl.Display.isCloseRequested();
    }
    public void update()
    {
        org.lwjgl.opengl.Display.update();
        if (FPSCap > 0)
        {
            org.lwjgl.opengl.Display.sync(FPSCap);
        }
    }






}
