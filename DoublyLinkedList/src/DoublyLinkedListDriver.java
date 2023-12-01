
public class DoublyLinkedListDriver {

	public static void main(String[] args)
	{
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		System.out.println(list);
		System.out.println(list.toStringBackward());
		
		for(int i = 0; i < 5; i++)
		{
			list.insertAtHead(i+1);
		}
		
		System.out.println(list);
		System.out.println(list.toStringBackward());
		
		for(int i = 10; i < 15; i++)
		{
			list.insertAtTail(i+1);
		}
		
		System.out.println(list);
		System.out.println(list.toStringBackward());
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Removing: " + list.removeHead());
			System.out.println(list);
			System.out.println(list.toStringBackward());
		}
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Removing: " + list.removeTail());
			System.out.println(list);
			System.out.println(list.toStringBackward());
		}
		System.err.println("Removing from empty list should throw exception");
		list.removeTail();
	}

}
