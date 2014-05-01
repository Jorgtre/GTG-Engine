
import Engine.Game;

public class mains
{
    public mains()
    {
        Game TestGame = new Game();

        TestGame.construct();

        while(TestGame.isRunning())
        {





            TestGame.update();
        }

        TestGame.destroy();

    }

    public static void main(String[] args)
    {
        new mains();
    }
}