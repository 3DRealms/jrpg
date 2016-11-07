
package sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class cargaImagen {
	
	public static BufferedImage cargarImagen(String path){
		try {
			return ImageIO.read(new FileImageInputStream(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
