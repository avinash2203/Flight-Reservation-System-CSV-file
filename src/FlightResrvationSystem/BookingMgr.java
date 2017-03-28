
package FlightResrvationSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 
 * @author win8.1
 */

public class BookingMgr 
{
    FRSManager mgr;
    BookingMgr(FRSManager mgr)
    {
        this.mgr=mgr;
    }
    Ticket tkt= new Ticket();
    /**
     * This method writes the booking details into the booked_tickets file
     * @param index 
     */
    
    public void booking(int index) 
    {
        tkt.flightID = mgr.SilkFlight.get(index).FlightNumber;
        tkt.Source = mgr.SilkFlight.get(index).source;
        tkt.passNum = mgr.passNum;
        tkt.DateSilk = mgr.SearchDate;
        tkt.arr  = mgr.SilkFlight.get(index).arrTime;
        tkt.dept = mgr.SilkFlight.get(index).depTime;
        /*System.out.println(tkt.passNum);
        System.out.println(tkt.DateSilk);*/
        mgr.dMgr.writeFile(tkt);
    }
    
   
}
