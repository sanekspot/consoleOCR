import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by sanekspot on 10.03.14.
 */
public class ConsoleOCR
{
    private BufferedImage img;
    private int xOrigin;
    private int yOrigin;
    private Map<String, BufferedImage> samples;

    public ConsoleOCR(BufferedImage img, int xOrigin, int yOrigin, Map<String, BufferedImage> samples)
    {
        this.img = img;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.samples = samples;
    }

    public String recognize()
    {
        SymbolFinder finder = new SymbolFinder(img, xOrigin, yOrigin);
        StringBuilder stringBuilder = new StringBuilder();
        SymbolRecognizer symbolRecognizer = new SymbolRecognizer(samples);
        BufferedImage symbol = finder.getNextSymbol();
        while(symbol != null)
        {
            stringBuilder.append(symbolRecognizer.recognize(symbol));
            symbol = finder.getNextSymbol();
        }
        return stringBuilder.toString();
    }


}
