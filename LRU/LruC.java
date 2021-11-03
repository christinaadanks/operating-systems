import java.util.*;

/**
 * Program to simulate the page table in a computer system.
 *
 * @author Christina Liu
 * @version 6/22/2021
 */
 
public class LruC  {

   ///////////////////////
   /////// FIELDS  ///////
   ///////////////////////
   private int size;
   private int counter;
   
   private List<Page> pageTable;
   private Set<Integer> pageList;
   
   /////////////////////////
   ////// CONSTRUCTOR //////
   /////////////////////////
   public LruC (int n) {
      size = n;
      counter = 0;
      pageTable = new ArrayList<>();
      pageList = new HashSet<>();
      
      for (int i = 0; i < size; i++) {
         pageTable.add(new Page());       //create page table
      }
      
   }
   
   //////////////////////
   /////// METHODS //////
   //////////////////////
   
   /**
    * Method to add page to the page table.
    * @param page - physical address of this block of memory.
    * @return true if valid and false if invalid.
    */
   public boolean addPage(int page) {
      boolean found = false;        //initialize boolean value
      counter++;                    //timestamp
      
      pageList.add(page);           //add page to full list(not table)
      
      for (int i = 0; i < size; i++)  {
         Page p = pageTable.get(i); //get address, timestamp, & validity
         
         if (p.address == page)  {  //if page already exists
            p.time = counter;       //update time stamp
            found = true;           //return page is valid
            break;
         }
      }
      
      if (!found) {
         int vicIndex = 0;                   //initialize victim index
         int vicTime = Integer.MAX_VALUE;    //initialize victim timestamp
         
         for (int i = 0; i < size; i++) {
            Page p = pageTable.get(i);       //get address, timestamp, & validity
            
            if (p.time < vicTime)   {        //find victim with lowest timestamp
               vicIndex = i;
               vicTime = p.time;
            }
         }
         
         Page pageReplace = pageTable.get(vicIndex);  //get page to be replaced(victim)
         pageReplace.valid = true;                    //update validity
         pageReplace.address = page;                  //update physical address
         pageReplace.time = counter;                  //update timestamp
         found = false;
      }

      return found;
   }
   
   /** 
    * Method to check the valid bit of a page in the page table.
    * @param page - physical address of this block of memory.
    * @return true if valid and false if invalid.
    */
   public boolean checkPage(int page)  {
      boolean found = false;                 //initialize boolean value
      
      for (int i = 0; i < size; i++) {
         Page p = pageTable.get(i);          //get address, timestamp, & validity
         
         if (p.address == page)  {           //if page exists, return valid
            found = true;
            break;
         }
      }
      
      return found;
   }
   
   /**
    * Method to generate a dictionary containing all the pages and their current valid/invalid values.
    * @return the dictionary with the keys and values.
    */
   public Dictionary<Integer, Boolean> getPages()   {
   
      Dictionary<Integer, Boolean> dictionary = new Hashtable<Integer, Boolean>();
      
      for (int page : pageList)  {
         dictionary.put(page, checkPage(page));
      }
      
      return dictionary;
   }
   
   /////////////////////////////
   ////// PRIVATE CLASSES //////
   /////////////////////////////
   private class Page   {
      private int address = Integer.MIN_VALUE;
      private boolean valid = false;
      private int time = 0;
   }

}