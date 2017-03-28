package FlightResrvationSystem;

public class Flight 
{
    String source;
    int daysOfWeek[]=new int[7];
    String FlightNumber;
    String depTime;
    String arrTime;
   
    
    
    public Flight(String source,int days[],String FNo,String dTime,String aTime)
    {

            this.source=source;
            this.daysOfWeek=days;
            this.FlightNumber=FNo;
            this.depTime=dTime;
            this.arrTime=aTime;
            
            
    }
}
