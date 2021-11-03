import java.util.LinkedList;

/**
 * @author Christina Liu
 * 
 * @version 6/12/2021
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
    * Add a PCB to a specific queue.
    * @param pcb - PCB to be added.
    * @param n - name of the queue to add to.
    * @return true if added, false if PCB not added to queue.
    */
   public boolean addPcb(Pcb pcb, String n) {
      if (names.contains(n))   {
         int i = names.indexOf(n);
         
         if (!pidCheck(pcb, i))  {
            if (n.equals("SJF"))   {
               return addSJF(pcb, i);
            }
            
            else if (n.equals("PS"))   {
               return addPS(pcb, i);
            }
            
            else  {
               queue.get(i).addLast(pcb);
               return true;
            }
            
         }
         return false;

      }
      
      return false;
   }
   
   /**
    * Private method to check if pid is unique.
    * @param pcb - PCB to check.
    * @param index - index of queue.
    * @return true if pid is not unique, false if it is unique.
    */
   private boolean pidCheck(Pcb pcb, int index)   {
      LinkedList<Pcb> queueCheck = this.queue.get(index);
      for (int i = 0; i < queueCheck.size(); i++)  {
         if (queueCheck.get(i).getPid() == pcb.getPid())   {
            return true;
         }
      }
      
      return false;
   }
   
   /**
    * Private method to add PCB into shortest-job-first queue.
    * @param pcb - PCB to add.
    * @param index - index of queue.
    * @return true if PCB is added (always true if this method is called).
    */
   private boolean addSJF(Pcb pcb, int index)  {
      LinkedList<Pcb> sQueue = queue.get(index);
      for (int j = 0; j < sQueue.size(); j++)   {
         if (pcb.getBursts() < sQueue.get(j).getBursts())  {
            sQueue.add(j, pcb);
            return true;
         }
      }     
      sQueue.addLast(pcb);
      return true;
   }
   
   /**
    * Private method to add PCB into priority-scheduling queue.
    * @param pcb - PCB to add.
    * @param index - index of queue.
    * @return true if PCB is added (always true if this method is called).
    */
   private boolean addPS(Pcb pcb, int index) {
      LinkedList<Pcb> pQueue = queue.get(index);
      for (int j = 0; j < pQueue.size(); j++)   {
         if (pcb.getPriority() < pQueue.get(j).getPriority()) {
            pQueue.add(j, pcb);
            return true;
         }
      }
      pQueue.addLast(pcb);
      return true;
   }
   
   /**
    * Remove the first Pcb from a specific queue.
    * @param n - name of the queue to remove the Pcb from.
    * @return Pcb that was removed, if no Pcb was removed, return Pcb with pid = -1.
    */
   public Pcb removePcb(String n)  {
      Pcb pcb = new Pcb(4,10,3,-1,0,0);
      
      if (names.contains(n))  {
         int i = names.indexOf(n);
         if (queue.get(i).size() > 0)  {
            pcb = queue.get(i).removeFirst();
         }
      }
      
      return pcb;
   }

}