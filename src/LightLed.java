

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author דודו
 */
import com.pi4j.io.gpio.*;
public class LightLed 
{
    /**
     * @param args the command line arguments
     */
    public static void Light()
    {
        // TODO code application logic here
         try
        { 
            final GpioController gpio = GpioFactory.getInstance();

            // provision gpio pin #17 as an output pin and turn on
            final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "pin",PinState.HIGH);

            PinState state = pin.getState();
            Thread.sleep(5000);
//            if(state == PinState.HIGH)
//            {
//                 // set shutdown state for this pin
//                  pin.setShutdownOptions(true, PinState.LOW);
//            }
//             if(state == PinState.LOW)
//            {
//                 // set shutdown state for this pin
//                  pin.setShutdownOptions(true, PinState.HIGH);
//            }
        pin.setShutdownOptions(true, PinState.HIGH);
        }
        catch(Exception ex)
        {
               System.out.println(ex);     
        }
    }
      
    
}
