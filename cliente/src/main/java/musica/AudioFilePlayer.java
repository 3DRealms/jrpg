package musica;

import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
 
public class AudioFilePlayer extends Thread{
	
	final File file;
	float volumen;
	boolean loop;
	boolean detener = false;
	
	public AudioFilePlayer(String filePath){
		file = new File(filePath);
		volumen = 80;
		this.loop = false;
	}
	public AudioFilePlayer(String filePath, float volumen){
		file = new File(filePath);
		this.volumen = volumen;
		this.loop = false;
	}
	public AudioFilePlayer(String filePath, float volumen, boolean loop){
		file = new File(filePath);
		this.volumen = volumen;
		this.loop = loop;
	}

 
    public void detener() {
    	detener = true;
    }
    
    @Override
	public void run(){
    	

    	do{
    		try (final AudioInputStream in = getAudioInputStream(file)) {

    			final AudioFormat outFormat = getOutFormat(in.getFormat());
    			final Info info = new Info(SourceDataLine.class, outFormat);

    			try (final SourceDataLine line =
    					(SourceDataLine) AudioSystem.getLine(info)) {

    				if (line != null) {

    					line.open(outFormat);
    					if (line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
    						FloatControl volume = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
    						volume.setValue(calcularVol());
    					}
    					line.start();
    					stream(getAudioInputStream(outFormat, in), line);
    					line.drain();
    					line.stop();
    				}
    			}

    		} catch (UnsupportedAudioFileException 
    				| LineUnavailableException 
    				| IOException e) {
    			throw new IllegalStateException(e);
    		}
    	}
    	while(loop && !detener);
	}
 
    private float calcularVol() {
		return volumen - 80;
	}
	private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();
        final float rate = inFormat.getSampleRate();
        return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }
 
    private void stream(AudioInputStream in, SourceDataLine line) 
        throws IOException {
        final byte[] buffer = new byte[65536];
        int n = 0;
        while(n != -1 && !detener) {
            line.write(buffer, 0, n);
            n = in.read(buffer, 0, buffer.length);
        }
    }
}