
import com.pi4j.io.gpio.*;

public class LightLed 
{
    private GpioPinDigitalOutput pin;   // the pin that'll light
    private GpioController gpio;		//the type of the interface
    
    public LightLed()
    {
         try
        { 
            this.gpio = GpioFactory.getInstance();// the only PGIO controller instance 
            // provision gpio pin #17 as an output pin and turn on
            this.pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00); //configure the pin
            
        }
        catch(Exception ex)
        {
               System.out.println(ex);     
        }
    }
    public void Light() // Light LED if it's off and turn off if it's on
    {
         try
        { 
            if(this.pin.getState()==  PinState.LOW)
            {
                this.pin.setState(PinState.HIGH);
            }
            else if(this.pin.getState() == PinState.HIGH)
            {
                this.pin.setState(PinState.LOW);
            }
            //   Thread.sleep(5000);
            //   pin.setShutdownOptions(true, PinState.HIGH);
        }
        catch(Exception e)
        {
               System.out.println(e);     
        }
    }
}
      
    

