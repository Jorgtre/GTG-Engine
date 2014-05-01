package Engine;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.DisplayMode;

public class Display {

    private int width = 0;
    private int height = 0;

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
    }


    



}
