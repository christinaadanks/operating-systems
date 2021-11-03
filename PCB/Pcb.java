
/**
 * @author Christina Liu
 * 
 * @version 6/3/2021
 */

public class Pcb  {

   ////////////////////
   //     FIELDS     //
   ////////////////////

   private int low, high, state, pid;

   ///////////////////////////
   //      CONSTRUCTOR      //
   ///////////////////////////
   
   public Pcb(int lowIn, int highIn, int stateIn, int pidIn)  {
      low = lowIn;
      high = highIn;
      state = stateIn;
      pid = pidIn;
   }
   
   ///////////////////////
   //      METHODS      //
   ///////////////////////

   public void setLowMem(int lowIn)   {
      low = lowIn;
   }
   
   public int getLowMem()  {
      return low;   
   }
   
   public void setHighMem(int highIn) {
      high = highIn;
   }
   
   public int getHighMem() {
      return high; 
   }
   
   public void setState(int stateIn)  {
      state = stateIn;
   }
   
   public int getState()   {
      return state; 
   }
   
   public void setPid(int pidIn)   {
      pid = pidIn;
   }
   
   public int getPid()  {
      return pid; 
   }

}