package sprites;

import java.awt.image.BufferedImage;

public class Animacion {
		private int velocidad;
		private int i;
		private long lastTime;
		private long timer;
		
		private BufferedImage[] frames;
		
		public Animacion(int velocidad, BufferedImage[] frames) {
			this.velocidad = velocidad;
			this.frames = frames;
			i = 0;
			//tiempo en milisegundos desde q arranco
			lastTime = System.currentTimeMillis();
		}
			
		public void actualizar(){
			timer+= System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			if(timer >velocidad){
				i++;
				timer = 0;
				
				if(i >= frames.length-1)
					i = 0;
			}
		}
			
		public BufferedImage getFrameActual(){
			return frames[i];
		}

		public BufferedImage getFrame(int i) {
			return frames[i];
		}
}
