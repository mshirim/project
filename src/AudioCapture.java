
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class AudioCapture 
{
    public int getSixteenBitSample(int high, int low)   // Convert to bytes to short type
    {
        return (high << 8) + (low & 0x00ff);
    } 
    private ArrayList<int[]> lst; // the array list that contains the audio
    public AudioCapture()   // Capturing the audio in an Array List
    {
        ArrayList<int[]> lst2 = new ArrayList<int[]>(); 
        TargetDataLine line;
	int depth = 2; //depth in bytes
        AudioFormat format = new AudioFormat(44100, depth*8, 1, true, false);
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
            Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();    // get the possible mixers
            Mixer mixer = AudioSystem.getMixer(mixerInfos[3]);   //choose the correct mixe
            line = (TargetDataLine) mixer.getLine(info);
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
        //System.out.println("start");
        while (++i < 6) 
        {
            // System.out.println("OK");
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
            this.lst = lst2;
            line.close();
    }
    public ArrayList<int[]> getList()
    {
            return this.lst;
    }
}
