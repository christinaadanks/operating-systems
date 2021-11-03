import java.util.*;

/**
 * Program to simulate the page table in a computer system.
 *
 * @author Christina Liu
 * @version 6/25/2021
 */
 

public class LruS {

   ///////////////////////
   /////// FIELDS  ///////
   ///////////////////////
   private int size;
   
   private LinkedList<Page> pageTable;
   private List<Integer> pageList;
   
   /////////////////////////
   ////// CONSTRUCTOR //////
   /////////////////////////   
   public LruS(int n)   {
      size = n;
      pageTable = new LinkedList<>();
      pageList = new LinkedList<>();
      
      for (int i = 0; i < size; i++)   {
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
      boolean found = false;                       //initialize boolean value
      
      pageList.add(page);                          //add page to full list(not table)
      
      for (int i = 0; i < size; i++)   {
         Page p = pageTable.get(i);                //get address & validity
         
         if (p.address == page)  {                 //if page already exists
            found = true;                          //return page is valid
            Page remove = pageTable.remove(i);     //remove found page
            pageTable.addFirst(remove);            //move found page to the top of stack
            break;
         }
      }
      
      if (!found) {
         Page remove = pageTable.remove(size - 1); //remove page at bottom of stack
         remove.valid = false;                     //set page to invalid
         
         Page p = new Page();                      //create new page         
         p.address = page;                         //set new page address
         p.valid = true;                           //set new page to valid
         pageTable.addFirst(p);                    //add new page to top of stack
      }
      
      return found;
   }
   
   /** 
    * Method to check the valid bit of a page in the page table.
    * @param page - physical address of this block of memory.
    * @return true if valid and false if invalid.
    */  
   public boolean checkPage(int page)  {
      boolean found = false;              //initialize boolean value
      
      for (int i = 0; i < size; i++)   {
         Page p = pageTable.get(i);       //get address & validity
         
         if (p.address == page)  {        //if page exists, return valid
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
   public Dictionary<Integer, Boolean> getPages()  {
      Dictionary<Integer, Boolean> dictionary = new Hashtable<Integer, Boolean>();
      for (int page : pageList)  {
         dictionary.put(page, checkPage(page));
      }
      return dictionary;
   }
   
   /////////////////////////////
   ////// PRIVATE CLASSES //////
   /////////////////////////////   
   private class Page  {
      private int address = Integer.MIN_VALUE;
      private boolean valid = false;
       
   }
   
}