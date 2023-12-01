/**
 * LinkedList2
 * @author Zachery Nyman
 * 31 March 2017
 */
public class LinkedListDriver {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		//System.out.println(list);
		//list.removeHead();
		//System.out.println(list.min());
		
		list.insertAtTail(7);
		list.insertAtHead(2);
		list.insertAtHead(5);
		list.insertAtTail(9);
		
		System.out.println(list);
		System.out.println("The size of the list is: " + list.getSize());
		System.out.println(list.min());
		System.out.println(list.max());
		System.out.println(list);
		list.removeHead();
		System.out.println(list);
		list.removeHead();
		System.out.println(list);
		list.removeHead();
		System.out.println(list);
		list.removeHead();
		System.out.println(list);
		System.out.println("The size of the list is: " + list.getSize());
		
		//list.removeHead();
		//System.out.println(list);
		
		list.insertAtTail(7);
		list.insertAtHead(2);
		list.insertAtHead(5);
		list.insertAtTail(9);
		
		System.out.println(list);
		System.out.println("The size of the list is: " + list.getSize());
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		System.out.println("The size of the list is: " + list.getSize());
		//list.removeLast();
		//System.out.println(list);
		

		
	}

}
