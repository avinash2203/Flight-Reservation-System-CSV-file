
package FlightResrvationSystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Collections;

public class SearchMgr 
{
    
   FRSManager mgr; 
   
   int my=0;
   
   SearchMgr(FRSManager mgr)
    {
        this.mgr=mgr;
    }
    
    ArrayList<Flight> ChooseFlight(ArrayList<Flight> Silk,String Source,String TDate)
    {   
      String silkdepstr = TDate;
      String silkarrstr = TDate;
      ArrayList<Flight> selectedFlight = null;     
      Calendar c = Calendar.getInstance();
      Date silkdep = new Date();
      Date silkarr = new Date();
      /*Date dateFrom = new Date();
      Date dateTill = new Date();*/
      
      SimpleDateFormat time1=new SimpleDateFormat("MMM dd, yyyy"); //  MMM dd, yyyy
      try
      {
            silkdep = time1.parse(TDate);
            c.setTime(silkdep); 
            selectedFlight = new ArrayList<Flight>();   
      }
      catch(ParseException e)
      {
          System.out.println("Incorrect Date Format");
            mgr.dspMgr.ShowScreen1();//e.getMessage());
      }
      
         for(Flight sf:Silk){
             
            //System.out.println(sf.source); 
             
             if(sf.source.equalsIgnoreCase(mgr.SearchCity)&& (sf.daysOfWeek[c.get(Calendar.DAY_OF_WEEK)-1]==1)){
                
                     selectedFlight.add(sf);
                     
                }   
         }
       return selectedFlight;
    }   

   
}
       
