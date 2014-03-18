import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanekspot on 10.03.14.
 */
public class SampleLoader
{
    public static Map<String, BufferedImage> loadSamples(String samplesFolder)
    {
        Map<String, BufferedImage> samplesMap = new HashMap<String, BufferedImage>(16);
        File folder = new File(samplesFolder);
        if (!folder.isDirectory())
        {
            return null;
        }
        for (File sample : folder.listFiles())
        {
            String sampleName = sample.getName().substring(0, 1);
            try
            {
                BufferedImage sampleImage = ImageIO.read(sample);
                samplesMap.put(sampleName, sampleImage);
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return samplesMap;
    }
}
