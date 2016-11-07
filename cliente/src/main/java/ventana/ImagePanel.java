package ventana;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    
    AffineTransform tx;
    AffineTransformOp op;
    boolean invertido = false;
    
    public ImagePanel(String path) {
       try {                
          image = ImageIO.read(new File(path));
       } catch (IOException ex) {
            // handle exception...
       }

    }
    
    public ImagePanel(String path, boolean invertido) {
        try {                
           image = ImageIO.read(new File(path));
        } catch (IOException ex) {
             // handle exception...
        }
        this.invertido = invertido;
        if(invertido){
        	tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(null), 0);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            image = op.filter(image, null);
        }

     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     // Flip the image horizontally
        
        
        
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}