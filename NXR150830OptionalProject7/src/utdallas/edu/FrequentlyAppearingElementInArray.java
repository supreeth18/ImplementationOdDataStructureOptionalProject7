package utdallas.edu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Java's HashMap to find Frequently appearing Element In The Array:
 * 
 * */
public class FrequentlyAppearingElementInArray {

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	Map<Integer, Integer> secondHashMap = new HashMap<Integer, Integer>();
	int count = 0;

	int size = 100000;
	int[] array = new int[size];

	/*
	 * Here this function will basically return the most Frequent Element in the
	 * array So first it uses one HashTable that will keep track of how many
	 * times each element of the array occurs. so key->element value-> number of
	 * times it occurs
	 */
	public int getMostFrequentElementArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				count = map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}

		// Here this will return the Maximum value from the HashMap
		int maxValuesInMap = Collections.max(map.values());
		int currentIndexSeen = Integer.MAX_VALUE;
		int prevIndexSeen = Integer.MAX_VALUE;

		/*
		 * Iterating the HashMap Here I will maintain Two Index Previoud index
		 * and CurrentIndex to keep track of the smallest index if there is tie
		 * count will return the element with most repeated element
		 */
		for (Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == maxValuesInMap) {
				prevIndexSeen = currentIndexSeen;
				currentIndexSeen = secongHashTableForIndex(entry.getKey(),
						array);
				if (currentIndexSeen < prevIndexSeen) {
					count = entry.getKey();
				} else {
					currentIndexSeen = 0;
				}

			}
		}

		return count;

	}

	/*
	 * Here this Second HashTable will basically take an array and will keep
	 * track of key->Element Value->element's Index Here basically we will put
	 * all the unique elements in the index starting from 0..N So finally this
	 * hashtable will return element as key and Element's index as value to the
	 * Above function This k-v result will be used in the First HashTable for
	 * keeping track of the Index i,e smallest Index in case of Tie.
	 */
	public void buildSecondHashTable(int[] array) {

		int index = 0;

		for (int i = 0; i < array.length; i++) {
			if (secondHashMap.containsKey(array[i])) {
				i++;
			} else {
				secondHashMap.put(array[i], index);
				index++;
			}
		}

	}

	/*
	 * Here This Function will basically return the Index of the Frequently
	 * occured Element since in case of the Tie we have to return the element at
	 * smallest Index.
	 */
	public int secongHashTableForIndex(int indexOfElementInHashTable,
			int[] array) {
		buildSecondHashTable(array);

		int returnIndex = 0;

		for (Entry<Integer, Integer> entry : secondHashMap.entrySet()) {
			if (entry.getKey() == indexOfElementInHashTable) {
				returnIndex = entry.getValue();
			}
		}
		return returnIndex;
	}

	public int[] initializeArray() {
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;

	}

	public void printElements() {

		for (int resArray : array) {
			System.out.println(resArray);
		}
	}

	public static void main(String[] args) {
		FrequentlyAppearingElementInArray obj = new FrequentlyAppearingElementInArray();
		Timer timer = new Timer();
		timer.start();
		int[] array = obj.initializeArray();
		System.out.println("Array Elements are : ");
		obj.printElements();
		System.out.println(" ");
		System.out.println(obj.getMostFrequentElementArray(array));

		timer.end();
		System.out.println(timer);

	}
}
