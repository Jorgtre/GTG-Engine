package Engine;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

public class Display {

    private int width = 0;
    private int height = 0;
    private int FPSCap = 0;

    public Display(int w, int h) {
        this.width = w;
        this.height = h;
        construct();
    }
    private void construct() {
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
    public void destroy() {
        org.lwjgl.opengl.Display.destroy();
    }
    public void resize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
        glViewport(0, 0, this.width, this.height);
        glOrtho(0, this.width, this.height , 0, 1, -1);
    }
    public boolean isCloseRequested() {
        return org.lwjgl.opengl.Display.isCloseRequested();
    }
    public void update() {
        org.lwjgl.opengl.Display.update();
        if (FPSCap > 0) { org.lwjgl.opengl.Display.sync(FPSCap); }
        if (org.lwjgl.opengl.Display.wasResized())
        {
            this.resize(org.lwjgl.opengl.Display.getWidth() ,
                        org.lwjgl.opengl.Display.getHeight());
        }
    }


    //####### Getters #######
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }
    public int getFPSCap()
    {
        return this.FPSCap;
    }
    //####### Setters #######
    public void setFPSCap(int cap)
    {
        this.FPSCap = cap;
    }
    public void setTitle(String title) {
        org.lwjgl.opengl.Display.setTitle(title);
    }

}
