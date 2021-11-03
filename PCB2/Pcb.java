
/**
 * @author Christina Liu
 *
 * Program that implements a simple PCB.
 *  
 * @version 6/9/2021
 */

public class Pcb  {

   ////////////////////
   //     FIELDS     //
   ////////////////////

   private int low, high, state, pid, priority, bursts;

   ///////////////////////////
   //      CONSTRUCTOR      //
   ///////////////////////////
   
   public Pcb(int lowIn, int highIn, int stateIn, 
            int pidIn, int priorityIn, int burstsIn)  {
      low = lowIn;
      high = highIn;
      state = stateIn;
      pid = pidIn;
      priority = priorityIn;
      bursts = burstsIn;
   }
   
   ///////////////////////
   //      METHODS      //
   ///////////////////////

   /**
    * Set the low memory bound.
    * @param lowIn - value of low memory bound.
    */
   public void setLowMem(int lowIn)   {
      low = lowIn;
   }
   
   /**
    * Get the low memory bound.
    * @return low memory bound.
    */
   public int getLowMem()  {
      return low;   
   }
   
   /**
    * Set the high memory bound.
    * @param highIn - value of high memory bound.
    */   
   public void setHighMem(int highIn) {
      high = highIn;
   }
   
   /**
    * Get the high memory bound.
    * @return high memory bound.
    */
   public int getHighMem() {
      return high; 
   }
   
   /**
    * Set the state.
    * @param stateIn - value of state.
    */   
   public void setState(int stateIn)  {
      state = stateIn;
   }
   
   /**
    * Get state.
    * @return state.
    */
   public int getState()   {
      return state; 
   }

   /**   
    * Set the process ID.
    * @param pidIn - value of process ID.
    */
   public void setPid(int pidIn)   {
      pid = pidIn;
   }
   
   /**
    * Get process ID.
    * @return process ID.
    */
   public int getPid()  {
      return pid; 
   }
   
   /**
    * Set priority.
    * @param priorityIn - value of priority.
    */
   public void setPriority(int priorityIn)   {
      priority = priorityIn;
   }
   
   /**
    * Get priority.
    * @return priority.
    */
   public int getPriority()   {
      return priority;
   }
   
   
   /**
    * Set bursts.
    * @param burstsIn - value of bursts.
    */
   public void setBursts(int burstsIn) {
      bursts = burstsIn;
   }
   
   /**
    * Get bursts.
    * @return bursts.
    */
   public int getBursts()  {
      return bursts;
   }

}