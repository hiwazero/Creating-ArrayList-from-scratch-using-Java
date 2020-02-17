/*
 Operations on list:
 1. determine whether the array is empty
 2. determine whether the array is full
 3. find the size of list
 4. clear the list
 5. determine whether the item is the same as a given list element
 6. insert an item in the list at the specified location
 7. remove an item from the list at the specified location
 8. replace an item at the specified location with another item
 9. retrieve an item from the list from the specified location
 10 search the list for a given item.
*/

public class ArrayList{
 //instance variables
 protected int count;//monitor the number of elements
 protected int items[];//storage of elements
 protected int re[];
 protected int x;
 
 public ArrayList (int size){
  items = new int[size];
  count = 0;
  re = new int[size];
  x =0;
 }
 
 public ArrayList(){
  this(10);
 }
 

public boolean isEmpty(){
 return count == 0;
}

public void clear(){

 for(int i = 0; i < count ; i++)
  items[i]  = 0;
 count = 0;
}

public boolean isFull(){
 return count == items.length;
}

public void doubleTheArray(){
 int temp[] = new int[items.length * 2];
 //transfer all elements from the old array
 for(int i = 0; i < items.length; i++)
  temp[i ] = items[i];
 items = temp;
}

public void addFirst(int item){
   if (count>0)
      insertAt(0,item);
   else 
   {
      items[0] = item;
      count++;
   }
}

public void addLast(int item){
   items[count++] = item;
}

public void insertAt(int pos, int item){
 if(pos >= 0 && pos <= count)
    shiftRight(pos);
  items[pos] = item;
 count++;
}

private void shiftRight(int pos){
 int c = count;
 while(c > pos){
  items[c] = items[--c];
 }
}

//determine whether the item is the same as a given list element
public void replace(int pos , int item)
{
   items[pos] = item;
}

public int getFirstElement()
{
  return items[0];
}

public int getLastElement()
{
 return items[getCount()-1];
}

public boolean determineElement(int pos , int item)
{
   return items[pos]==item;  
}

public boolean search(int item)
{
   boolean check = false;
   for(int i=0 ; i<count ; i++)
      {
         if(items[i]==item)
         check = true ; 
      }
      
      return check;
}


public void removeFirst(){
   if(!isEmpty()){
      re[x++] = items[0];
      for(int i=0; i<count; i++){
         int temp = items[i];
         items[i] = items[i+1];
         items[i+1] = temp;
      }
      count--;
   }
}

public void removeLast(){
   if(!isEmpty()){
   re[x++]=items[count-1];
   items[count-1]=0;
   count--;
   }
}

public void retrieve(int item){
   for(int i=0; i<x; i++){
      if(re[i]==item){
      addFirst(item);
      re[i]=0;
      x--;
      }
      
   }   
}

public int getCount(){
 return count;
}
 
//for display
public String toString(){
 StringBuffer sb = new StringBuffer();
 sb.append("{ ");
 for(int i = 0; i < count; i++)
  sb.append(items[i] + " ");
 sb.append("}");
  
return sb.toString();
}

public void add(int item){
 items[count++] = item;
}
 //for testing purposes
 public static void main(String [] args){
  ArrayList list = new ArrayList();
  list.add(5);
  System.out.println("list = " + list);
  list.add(6);
  System.out.println("list = " + list);
  list.add(4);//replace to 10
  System.out.println("list = " + list);
  list.add(6);
  System.out.println("list = " + list);
  list.insertAt(2,9);//insert to index 2
  System.out.println("list = " + list);
  list.replace(3,10);
  System.out.println("list = " + list);
   
  System.out.println("Searching... "+list.search(9));
  
  list.retrieve(10);
  System.out.println("list = " + list);
  list.retrieve(5);
  System.out.println("list = " + list);

  list.addFirst(8); 
  System.out.println("list = " + list);
  
  list.removeFirst();
  System.out.println("list = " + list);

  list.removeLast();
  System.out.println("list = " + list);



  }
}