package Engine;


public class Game {

    private Display window = null;
    private boolean keepRunning = true;
    private FPSCounter fpsCounter = null;

    public Game() {

    }

    public void construct() {
        window = new Display(800,600);
        fpsCounter = new FPSCounter();
    }
    public void destroy() {
        window.destroy();
    }


    public boolean isRunning() {
        if (keepRunning && !window.isCloseRequested())
        {
            return true;
        }
        return false;
    }
    public void update() {
        window.update();
        fpsCounter.update();
        window.setTitle( "FPS: " + fpsCounter.getFps());
    }


}
