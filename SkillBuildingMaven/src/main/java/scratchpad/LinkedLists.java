package scratchpad;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {
/*
 * To learn how to work with Linked Lists in Java
 */
	
	void practice() {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.addFirst(0);
		list.add(5);
		
//		for(Integer i : list) {
//			System.out.println("value=" + i.intValue());
//		}
//		
		
		System.out.println("list=" + list);
		
		ListIterator<Integer> li = list.listIterator();
		while(li.hasNext()) {
			System.out.println("value=" + li.next());
		}
		
	}
	
	public static void main(String[] args) {
		LinkedLists ll = new LinkedLists();
		ll.practice();
	}
}
