package utdallas.edu;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 * Here This Program will Compare the performances of Trees, Lists, Skip lists, and Hashing
 on the operations add, contains, remove.  For Tree, List, and Hashing,
 use the Java library
 * 
 * */
public class ComparingThePerformance {

	static int SIZE = 1000000;

	/*
	 * Tree-TreeSet - Balanced binary Tree Lists - LinkedList SkipList
	 * Hashing-HashSet This function will add the elements to the above
	 * datastructure.
	 */

	public void addToABoveDataStructure(Collection<Integer> element) {
		for (int i = 0; i < SIZE; i++) {
			element.add(i);
		}
	}
	
	
	/*
	 * This function will search for an element in Lists,HashSet and TreeSet
	 * */
	public long search(Collection<Integer> dataStructure,Integer element){
		long startTime = System.currentTimeMillis();
		System.out.println(dataStructure.contains(element));
		long endTime = System.currentTimeMillis();
		return endTime-startTime;
	}
	
	/*
	 * This function will delete an element from Lists,HashSet,TreeSet
	 * */
     public long deleteElement(Collection<Integer> element){
    	 Integer deleteNumber = (new Random().nextInt()%1000000);
    	 /*
    	  * Avoid negative number while generating the Random()
    	  * */
    	 if(deleteNumber<0){
    		 deleteNumber*=-1;
    	 }
    	 System.out.println("Number to be deleted is : " + deleteNumber);
    	 System.out.println();
    	 long startTime = System.currentTimeMillis();
    	 element.remove(deleteNumber);
    	 long endTime = System.currentTimeMillis();
    	 return endTime-startTime;
     }
	

	public static void main(String[] args) {
		ComparingThePerformance obj = new ComparingThePerformance();
		List<Integer> list = new LinkedList<Integer>();
		Set<Integer> hashset = new HashSet<Integer>();
		Set<Integer> treeset = new TreeSet<Integer>();
        
		obj.addToABoveDataStructure(list);
		obj.addToABoveDataStructure(hashset);
		obj.addToABoveDataStructure(treeset);
		
		
		
		long sTime = System.currentTimeMillis();
		treeset.add(new Integer(-1)); 
		long eTime = System.currentTimeMillis();
		System.out.println("Time taken to insert in a tree map : "
				+ (eTime - sTime));

		sTime = System.currentTimeMillis();
		list.add(new Integer(-1));
		eTime = System.currentTimeMillis();
		System.out.println("Time taken to insert in a linked list : "
				+ (eTime - sTime));

		sTime = System.currentTimeMillis();
		hashset.add(new Integer(-1));
		eTime = System.currentTimeMillis();
		System.out.println("Time taken to insert in a hash set : "
				+ (eTime - sTime));
		
		System.out.println();
		Integer element = (new Random().nextInt() % 1000000);
		if (element < 0) {
			element *= -1;
		}
		System.out.println("Search for an Element " + element);

		System.out.println("Time taken to Search in a tree map : "
				+ obj.search(treeset, element));

		System.out.println("Time taken to Search in a linked list : "
				+ obj.search(list, element));

		System.out.println("Time taken to Search in a hash set : "
				+ obj.search(hashset, element));
		
		
		
		System.out.println();
		
		

		System.out.println("Time taken to delete in a tree map : "
				+ obj.deleteElement(treeset));

		System.out.println("Time taken to delete in a linked list : "
				+ obj.deleteElement(list));

		System.out.println("Time taken to delete in a hash set : "
				+ obj.deleteElement(hashset));

	}
}
