import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sanekspot on 10.03.14.
 */
public class Main
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Usage: java -jar consoleOcr.jar imageFile samplesDir");
            System.exit(1);
        }
        try {
            BufferedImage img = ImageIO.read(new File(args[0]));
            ConsoleOCR ocr = new ConsoleOCR(img, 0, 0, SampleLoader.loadSamples(args[1]));
            System.out.print(ocr.recognize().replaceAll("\\s+", " "));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
