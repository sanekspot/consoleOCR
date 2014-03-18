import java.awt.image.BufferedImage;

/**
 * Created by sanekspot on 10.03.14.
 */
public class SymbolFinder
{
    public final int X_LETTER_SIZE = 8;
    public final int Y_LETTER_SIZE = 10;
    public final int X_SPACING_SIZE = 1;
    public final int Y_SPACING_SIZE = 6;

    private int xOrigin;
    private int yOrigin;
    private BufferedImage img;

    private int xCur;
    private int yCur;

    public SymbolFinder(BufferedImage img, int xOrigin, int yOrigin)
    {
        this.img = img;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.xCur = xOrigin;
        this.yCur = yOrigin;
    }

    public void reset()
    {
        xCur = xOrigin;
        yCur = yOrigin;
    }

    public BufferedImage getNextSymbol()
    {
        if (xCur + X_LETTER_SIZE > img.getWidth())
        {
            goToNextLine();
            return new BufferedImage(X_LETTER_SIZE, Y_LETTER_SIZE, BufferedImage.TYPE_3BYTE_BGR);
        }
        if (yCur + Y_LETTER_SIZE > img.getHeight())  // end of file
        {
            return null;
        }
        BufferedImage symbol = img.getSubimage(xCur, yCur, X_LETTER_SIZE, Y_LETTER_SIZE);
        xCur += X_LETTER_SIZE + X_SPACING_SIZE;
        return symbol;
    }

    private void goToNextLine()
    {
        xCur = xOrigin;
        yCur += Y_LETTER_SIZE + Y_SPACING_SIZE;
    }
}
