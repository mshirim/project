import javax.sound.sampled.DataLine;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import javax.sound.sampled.*;

public class AudioCapture 
{
	public int getSixteenBitSample(int high, int low)
	{
	    return (high << 8) + (low & 0x00ff);
	} 
	private ArrayList<int[]> lst; 
	public AudioCapture()
	{
		ArrayList<int[]> lst2 = new ArrayList<int[]>();
		TargetDataLine line;
		int depth = 2; //depth in bytes
		AudioFormat format = new AudioFormat(44100, depth*8, 2, true, false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, 
		    format); // format is an AudioFormat object
		int channels = 2;
		if (!AudioSystem.isLineSupported(info)) 
		{
		    // Handle the error ... 
		}
		// Obtain and open the line.
		try 
		{
		    line = (TargetDataLine) AudioSystem.getLine(info);
		    line.open(format);
		} 
		catch (LineUnavailableException ex)
		{
			System.out.println("error");
			ex.printStackTrace();
		   return;
		}
		
		
		// Assume that the TargetDataLine, line, has already
		// been obtained and opened.
		ByteArrayOutputStream out  = new ByteArrayOutputStream();
		int numBytesRead;
		byte[] data = new byte[line.getBufferSize() / 5];
		// Begin audio capture.
		line.start();
		int i = 0;
		// Here, stopped is a global boolean set by another thread.
		while (++i < 80) 
		{
		   // Read the next chunk of data from the TargetDataLine.
		   numBytesRead =  line.read(data, 0, data.length);
		   // Save this chunk of data.
		   out.write(data, 0, numBytesRead);
		   int[][] samples = new int[channels][data.length/4];
	        int sampleIndex = 0;
	        int last = 0;
	        for (int t = 0; t < data.length;)
	        {
	            for (int channel = 0; channel < channels; channel++) 
	            {
	                int low = (int) data[t];
	                t++;
	                int high = (int) data[t];
	                t++;
	                int sample = getSixteenBitSample(high, low);
	                // Sample is a 16 bit consists of the 8-bit of the high and low bytes
	                samples[channel][sampleIndex] = sample;
	            }
	            sampleIndex++;
	        }
	        int[] sample = new int[samples[0].length];
	        for(int b=0; b<samples[0].length; b++)
	        {
	        	sample[b]=samples[0][b];
	        }
	        	lst2.add(last, sample);
	        	last++;
		}
		this.lst =lst2;  
	}
	public ArrayList<int[]> getList()
	{
		return this.lst;
	}

//	public static void main(String[] args) 
//	{
//		AudioCapture g = new AudioCapture();
//	}
}
