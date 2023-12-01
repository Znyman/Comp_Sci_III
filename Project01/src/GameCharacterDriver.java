/**
 * Project 01
 * @author Zachery Nyman
 * 07 April 2017
 */
public class GameCharacterDriver {

	public static void main(String[] args) {
		
		LinkedList<GameCharacter> linkedList = new LinkedList<>();
		DoublyLinkedList<GameCharacter> doublyLinkedList = new DoublyLinkedList<>();
		GameCharacter gc1 = new GameCharacter("Priest");
		GameCharacter gc2 = new GameCharacter("Barbarian");
		GameCharacter gc3 = new GameCharacter("Mage");
		GameCharacter gc4 = new GameCharacter("Archer");
		GameCharacter gc5 = new GameCharacter("Rogue");
		
		//linkedList.remove(gc5);//remove from empty
		linkedList.insertAtTail(gc5);
		linkedList.insertAtHead(gc2);
		linkedList.insertAtHead(gc3);
		linkedList.insertAtHead(gc1);
		linkedList.insertAtTail(gc4);
		System.out.println(linkedList);
		System.out.println(linkedList.remove(gc2));//remove middle
		System.out.println(linkedList);
		System.out.println(linkedList.remove(gc4));//remove tail
		System.out.println(linkedList);
		System.out.println(linkedList.remove(gc1));//remove head
		System.out.println(linkedList.remove(gc1));//remove value that's not in the list
		System.out.println(linkedList);
		System.out.println(linkedList.remove(gc3));
		System.out.println(linkedList);
		System.out.println(linkedList.remove(gc5));//remove from one element list
		System.out.println(linkedList);
		
		//doublyLinkedList.remove(gc2);//remove from empty
		doublyLinkedList.insertAtHead(gc2);
		doublyLinkedList.insertAtTail(gc1);
		doublyLinkedList.insertAtHead(gc3);
		doublyLinkedList.insertAtHead(gc4);
		doublyLinkedList.insertAtHead(gc5);
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.remove(gc3));//remove middle
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.remove(gc1));//remove tail
		System.out.println(doublyLinkedList.remove(gc1));//remove value that's not in the list
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.remove(gc5));//remove head
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.remove(gc4));
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.remove(gc2));//remove from one element list
		System.out.println(doublyLinkedList);
	}

}
