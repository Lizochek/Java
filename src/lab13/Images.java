package lab13;

        import javax.imageio.ImageIO;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;

public class Images {

    public static void main(String[] args)
    {

        String srcFolder = "images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int k=Runtime.getRuntime().availableProcessors();
        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }
            final int groupSize=files.length/k;

            for(int i=0;i<k;i++)
            {
                final int I=i;
                new Thread(() ->{

                    for(int j=groupSize*I;j<groupSize*(I+1);j++)
                    {
                        BufferedImage image = null;
                        try {
                            image = ImageIO.read(files[j]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(image == null) {
                            continue;
                        }

                        int newWidth = (int)(image.getWidth() * 0.5);
                        int newHeight = (int) Math.round(
                                image.getHeight() / (image.getWidth() / (double) newWidth)
                        );
                        BufferedImage newImage = new BufferedImage(
                                newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                        );

                        int widthStep = image.getWidth() / newWidth;
                        int heightStep = image.getHeight() / newHeight;

                        for (int x = 0; x < newWidth; x++)
                        {
                            for (int y = 0; y < newHeight; y++) {
                                int rgb = image.getRGB(x * widthStep, y * heightStep);
                                newImage.setRGB(x, y, rgb);
                            }
                        }

                        File newFile = new File(dstFolder + "/" + files[j].getName());
                        try {
                            ImageIO.write(newImage, "jpg", newFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}