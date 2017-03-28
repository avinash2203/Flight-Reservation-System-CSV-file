package FlightResrvationSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author win8.1
 */


public class DataMgr 
{
    FRSManager mgr;
    DataMgr(FRSManager mgr)
    {
        this.mgr=mgr;
    }
    
    /**
     * This method reads the silk_air file
     * @param filename
     * @return 
     */
    public ArrayList<Flight> readSilkAir(String filename)
    {
        ArrayList<Flight> arr =new ArrayList<>();
        try
        {
            BufferedReader br=new BufferedReader(new FileReader(filename.trim()));
            String line=null;
            int i=1;
            while((line=br.readLine())!=null)
            {
                if(i>3)
                {
                    StringTokenizer tokn=new StringTokenizer(line,"|");
                    String srcCity=tokn.nextToken();
                    String daysOfWeek=tokn.nextToken();
                    String FlightNumber=tokn.nextToken();
                    String time=tokn.nextToken();
                   
                    StringTokenizer timedivide=new StringTokenizer(time,"/");
                    String depTime=timedivide.nextToken();
                    String arrTime=timedivide.nextToken();
                   
                    
                    int days[]={0,0,0,0,0,0,0};
                    StringTokenizer daysFind=new StringTokenizer(daysOfWeek,",");
                    while(daysFind.hasMoreTokens())
                    {
                        String tem=daysFind.nextToken();
                        //System.out.println(tem);
                        if(tem.equalsIgnoreCase("Mon"))
                            days[1]=1;
                        else if(tem.equalsIgnoreCase("Tue"))
                            days[2]=1;
                        else if(tem.equalsIgnoreCase("Wed"))
                            days[3]=1;
                        else if(tem.equalsIgnoreCase("Thu"))
                            days[4]=1;
                        else if(tem.equalsIgnoreCase("Fri"))
                            days[5]=1;
                        else if(tem.equalsIgnoreCase("Sat"))
                            days[6]=1;
                        else if(tem.equalsIgnoreCase("Sun"))
                            days[0]=1;
                    }
                    Flight obj=new Flight(srcCity.trim(),days,FlightNumber.trim(),depTime.trim(),arrTime.trim());
                    arr.add(obj);
                }
                else
                    i++;
            }
            br.close();
        }        
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }  
        return arr ;
    }
    /**
     * This method writes the ticket details into booked_tickets file
     * @param t 
     */
   public void writeFile(Ticket t) 
   {
       BufferedWriter br = null;
        try {
            
            br = new BufferedWriter(new FileWriter("bookedTickets.csv",true));
            String line=null;
            File f=new File("bookedTickets.csv");
            if(f.exists())
            {
            
            String Tickt=t.BookId+"|"+t.flightID+"|"+t.DateSilk+"|"+t.Source+"|"+t.passNum+"|";
            br.append(Tickt);
            br.newLine();
            br.close();
            
            }
        } catch (IOException ex) {
            Logger.getLogger(DataMgr.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(DataMgr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
   }
    
  
            
    
}
