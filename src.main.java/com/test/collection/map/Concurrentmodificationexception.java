package com.test.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * We can Iterator or ConcurrentHashMap to remove the element while iterating
 *
 */
public class Concurrentmodificationexception {

	public static void main(String[] args) {
		
//		Create Map from Array using java 8
		
		Map<String, String> mapFromArray = Stream.of(new String[][] {
			{"test1", "test2"},
			{"test", "value1"},
		}).collect(Collectors.toMap(data-> data[0], data -> data[1]));
		
		
		Map<String, String> map = new HashMap<String, String>(){
			{
				put("key", "value1");
				put("key2", "value2");
				put("key3", "value3");
				put("key4", "value4");
			}
		};
		
		System.out.println(map.size());
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
//			map.remove("key");  // java.util.ConcurrentModificationException
			if(str.equals("key")) { //You can remove entry from the map like this
				map.remove("key");
			}
			
		}
		System.out.println(map.size());
		
		List<String> list = new ArrayList<String>() {
			{
				add("1");
				add("2");
				add("3");
				add("4");
			}
		};
		
		Iterator<String> listItr = list.iterator();
		System.out.println("Before list modification "+list.size());
		while(listItr.hasNext()) {
			String str = listItr.next();
//			list.remove("2"); // java.util.ConcurrentModificationException
			if(str.equals("2"))
				listItr.remove();
		}
		System.out.println("After list modification "+list.size());
		
	}
}
