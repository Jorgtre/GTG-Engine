
import Engine.Display;

public class mains
{
    public mains()
    {
        Display window = new Display(800, 600);


        window.Construct();

        while (!window.isCloseRequested())
        {


            window.update();
        }


    }

    public static void main(String[] args)
    {
        new mains();
    }
}