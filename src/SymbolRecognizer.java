import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by sanekspot on 10.03.14.
 */
public class SymbolRecognizer
{
    private Map<String, BufferedImage> samples;

    public SymbolRecognizer(Map<String, BufferedImage> samples)
    {
        this.samples = samples;
    }

    public String recognize(BufferedImage symbol)
    {
        for (Map.Entry<String, BufferedImage> sample : samples.entrySet())
        {
            if (isEquals(symbol, sample.getValue()))
            {
                return sample.getKey();
            }
        }
        return " ";
    }

    public static boolean isEquals(BufferedImage one, BufferedImage two)
    {
        boolean isEquals = true;
        if (one.getHeight() != two.getHeight() || one.getWidth() != two.getWidth())
        {
            return false;
        }
        for (int y = 0; y < one.getHeight() && isEquals; ++y)
        {
            for (int x = 0; x < one.getWidth(); ++x)
            {
                if (one.getRGB(x, y) != two.getRGB(x, y))
                {
                    isEquals = false;
                    break;
                }
            }
        }
        return isEquals;
    }
}
