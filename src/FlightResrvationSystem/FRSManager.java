
package FlightResrvationSystem;

import java.util.ArrayList;
import java.io.*;

public class FRSManager 
{
    DataMgr dMgr;       
    DisplayMgrInterface dspMgr;
    SearchMgr sMgr;
    BookingMgr bMgr;
    String SearchCity;
    String SearchDate;
    ArrayList<Flight> Silk;
    int selectedResult;
    int passNum;
    Ticket genTicket;
    String name;
    ArrayList<Flight> SilkFlight;
    public static void main(String args[]) 
    {
        int i=2;
        String SilkNm= args[0];
        String inter=null;
        FRSManager MGR=new FRSManager();
        MGR.dMgr=new DataMgr(MGR);       
        MGR.sMgr=new SearchMgr(MGR);
        MGR.bMgr=new BookingMgr(MGR);
        MGR.Silk=MGR.dMgr.readSilkAir(SilkNm);
        MGR.dspMgr=new DisplayMgr(MGR);
        MGR.dspMgr.ShowScreen1();
        
     }
}
