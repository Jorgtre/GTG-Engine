package Engine;

import org.lwjgl.Sys;

public class FPSCounter {

    private long lastFPS = 0;
    private int x;
    private int fps;

    public FPSCounter() {
        lastFPS = getTime();
    }
    private long getTime() {
        return(Sys.getTime() * 1000 / Sys.getTimerResolution());
    }
    public void update() {
        if (getTime() - lastFPS > 1000)
        {
            fps = x;
            x = 0;
            lastFPS += 1000;
        }
        x++;
    }
    public int getFps()
    {
        return fps;
    }





}
