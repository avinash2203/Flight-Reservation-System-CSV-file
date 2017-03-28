
package FlightResrvationSystem;


public class Ticket 
{
    String Source;
    String BookId;
    int passNum;
    String DateSilk;
    String arr;
    String dept;
   
    
    String flightID;
    public Ticket(String Source,String BookId,int num,String DateSilk,String flightID)
    {
        this.Source=Source;
        this.BookId=BookId;
        this.passNum=num;
        this.DateSilk=DateSilk;
        this.flightID=flightID;
    }

    Ticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
}
