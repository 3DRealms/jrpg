
package sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;

public class CargaImagen {
	
	public static BufferedImage cargarImagen(String path){
		try {
			return ImageIO.read(new FileImageInputStream(new File(path)));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra la imagen "+path+" llamar al 0800-333-JUNIT");
			System.exit(1);
		}
		return null;
	}
}
