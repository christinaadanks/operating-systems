import java.util.LinkedList;

/**
 * @author Christina Liu
 * 
 * @version 6/4/2021
 */

public class MasterQueue   {

   ////////////////////
   //     FIELDS     //
   ////////////////////
   
   private LinkedList<String> names;
   private LinkedList<LinkedList<Pcb>> queue;

   ///////////////////////////
   //      CONSTRUCTOR      //
   ///////////////////////////
      
   public MasterQueue() {
      names = new LinkedList<String>();
      queue = new LinkedList<LinkedList<Pcb>>();
   }
   
   ///////////////////////
   //      METHODS      //
   ///////////////////////
   
   /**
    * Create and add a new queue.
    * @param n - name of queue.
    * @return false if queue already exists, true if it is created & added.
    */
     
   public boolean addQueue(String n) {
      if (names.contains(n))   {
         return false;
      }
      else  {
         names.addLast(n);
         queue.addLast(new LinkedList<Pcb>());
         return true;
      }
   }
   
   /**
    * Add a Pcb to a specific queue.
    * @param p - Pcb to be added.
    * @param n - name of the queue to add to.
    * @return true if added, false if the queue doesn't exist.
    */
   public boolean addPcb(Pcb p, String n) {
      if (names.contains(n))   {
         int i = names.indexOf(n);
         queue.get(i).addLast(p);
         return true;
      }
      
      return false;
   }
   
   /**
    * Remove the first Pcb from a specific queue.
    * @param n - name of the queue to remove the Pcb from.
    * @return Pcb that was removed, if no Pcb was removed, return Pcb with pid = -1.
    */
   public Pcb removePcb(String n)  {
      Pcb pcb = new Pcb(4,10,3,-1);
      
      if (names.contains(n))  {
         int i = names.indexOf(n);
         if (queue.get(i).size() > 0)  {
            pcb = queue.get(i).removeFirst();
         }
      }
      
      return pcb;
   }

}