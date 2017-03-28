package FlightResrvationSystem;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author win8.1
 */

public class DisplayMgr implements DisplayMgrInterface
{  
    Screen1 s1;
    Screen2 s2;
    Screen3 s3;
    Screen4 s4;
    FRSManager mgr;
    int myindex;
    /**
     * 
     * @param mgr 
     */
    DisplayMgr(FRSManager mgr)
    {
        this.mgr=mgr;
        s1=new Screen1(mgr);
        s2=new Screen2(mgr);
        s3=new Screen3(mgr);
        s4=new Screen4(mgr);
     }
    
    void addDateCombo()
    {
        String MONTH="OCT";
        String YEAR="2016";
        for(int i=1;i<=31;i++)
        {
            if (i<10)
            s1.jComboBox1.addItem(MONTH+" 0"+i+", "+YEAR);
            else
            s1.jComboBox1.addItem(MONTH+" "+i+", "+YEAR);
            
        }
        String MONTH2="NOV";
        String YEAR2="2016";
        for(int i=1;i<=13;i++)
        {
            if (i<10)
            s1.jComboBox1.addItem(MONTH2+" 0"+i+", "+YEAR2);
            else
            s1.jComboBox1.addItem(MONTH2+" "+i+", "+YEAR2);
            
        }
    }
    void addCityCombo()
    {
        s1.jComboBox2.addItem("Kolkata (CCU)");
        s1.jComboBox2.addItem("Hydrabad (HYD)");
        s1.jComboBox2.addItem("Chennai (MAA)");
        s1.jComboBox2.addItem("Bengaluru (BLR)");
    }
    /**
     * This method shows result in screen2 
     */
    void showResult()
    {
        DefaultTableModel model=(DefaultTableModel) s2.jTable1.getModel();
        while(model.getRowCount()>0)
        {
            for(int j=0;j<model.getRowCount();j++)
                model.removeRow(j);
        }
        int n=mgr.sMgr.ChooseFlight(mgr.SilkFlight, mgr.SearchCity, mgr.SearchDate).size();
       // System.out.println(n);
                //ChooseFlight(mgr.silk, mgr.SearchCity, mgr.SearchDate);
        for(int i=0;i<n;i++)
        {
            Flight f=mgr.sMgr.ChooseFlight(mgr.SilkFlight, mgr.SearchCity, mgr.SearchDate).get(i);
                    //ChooseFlight(mgr.silk, mgr.SearchCity, mgr.SearchDate).get(i);
            String[] data=new String[9];           
            data[0]=f.source;
            
            data[1]="Singapore";
            
            data[2]=f.FlightNumber;
            data[3]=f.depTime;
            data[4]=f.arrTime;

            model.addRow(data);
        }
    }
    void addPassengerCombo()
    {
        for(int i=1;i<=10;i++)
            s1.jComboBox3.addItem(i);
       
    }
    public void ShowScreen1()
    {
        
        //s2.setVisible(false);
        //s4.setVisible(false);
        s1.jComboBox1.removeAllItems();
        s1.jComboBox2.removeAllItems();
        s1.jComboBox3.removeAllItems();
        addDateCombo();
        addCityCombo();
        addPassengerCombo();
        s1.setVisible(true);
    }
    public void ShowScreen2()
    {
        s1.setVisible(false);
        s2.jLabel1.setText(mgr.SearchCity);
        s1.jLabel12.setVisible(false);
        mgr.SilkFlight = (ArrayList<Flight>) mgr.sMgr.ChooseFlight(mgr.Silk, mgr.SearchCity, mgr.SearchDate);
        if(mgr.SilkFlight != null)
        {
            showResult();
            s2.setVisible(true);
            
        }
        else
        {    
            s1.jLabel12.setVisible(true);
            mgr.dspMgr.ShowScreen1();
        }
        
        
    } 
    
    public void ShowScreen3(int index)
    {
        s2.setVisible(false);
        //ComboFlight res=mgr.ResCombo.get(mgr.selectedResult);
        s3.jLabel9.setText(mgr.passNum+"");
        //s3.jLabel4.setText(res.SpiceNo);
        //s3.jLabel5.setText(res.dateSpice);
        s3.jLabel3.setText(mgr.SilkFlight.get(index).FlightNumber);
        s3.jLabel8.setText(mgr.SearchDate);
        s3.jLabel7.setText(mgr.SearchCity);
        s3.setVisible(true);
        myindex = index;
    }
    public void ShowScreen4()
    {
       s3.setVisible(false);
       s4.jLabel8.setText(mgr.SilkFlight.get(myindex).FlightNumber);
       s4.jLabel10.setText(mgr.SearchCity);
       s4.jLabel11.setText("Singapore");
       s4.jLabel12.setText(mgr.SearchDate);
       s4.jLabel13.setText(String.valueOf(mgr.passNum));
       
      s4.setVisible(true);
    }
    public void ExitProject()
    {
        System.exit(0);
    }
    
}
