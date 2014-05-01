import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class mains
{
    public mains()
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Display.setResizable(true);
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }




        while(!Display.isCloseRequested())
        {
            glClear(GL_COLOR_BUFFER_BIT);



            updateWindow();
            Display.update();
            Display.sync(60);

        }
        Display.destroy();
        System.exit(0);
    }
    public static void updateWindow()
    {
        glViewport( 0, 0, 800, 600);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 600 , 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }


    public static void main(String[] args)
    {
        new mains();
    }
}