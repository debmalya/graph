package deb.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] myArray = new Integer[] { 100, 1000, 600, 50 };
		TreeSet<Integer> treeSet = new TreeSet<Integer>(Arrays.asList(myArray));
		System.out.println(treeSet);
		
		HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(myArray)); 
		System.out.println(hashSet);
		
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>(Arrays.asList(myArray)); 
		System.out.println(linkedHashSet);

		System.out.println("A".compareTo("B"));

		HashMap<Integer, Integer> myMap = new HashMap<>();

		myMap.put(2, 3);
		myMap.put(null, 3);
		myMap.put(null, 4);

		for (Map.Entry<Integer, Integer> entry : myMap.entrySet()){
		    System.out.println(entry);
		}
		
		TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

		sortedMap.put(8, 4);
		sortedMap.put(2, 3);
		sortedMap.put(5, 4);
		sortedMap.put(3, 6);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
		    System.out.println(entry);
		}
		
		Comparator<String> stringLengthComparator = new Comparator<String>() {

		    @Override
		    public int compare(String s1, String s2) {
		        return s1.length() - s2.length();
		    }

		};

		SortedMap<String, Integer> wordMap = new TreeMap<String, Integer>(
		        stringLengthComparator);

		wordMap.put("Peter", 8);
		wordMap.put("Harry", 2);
		wordMap.put("John", 5);
		wordMap.put("Jack", 3);

		for (Map.Entry<String, Integer> entry : wordMap.entrySet()){
		    System.out.println(entry);
		}
	}

}
