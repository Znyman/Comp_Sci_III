
public class Driver {

	/*
	 *             5
	 *            /\
	 *           7  9
	 *          /   /\
	 *         8    3 1
	 *        /\       \
	 *        6  10     0
	 *                
	 */
	public static void main(String[] args)
	{
		BinaryTree<Integer> t = new BinaryTree<>();
		
		Position<Integer> r = t.addRoot(5);
		Position<Integer> eight = t.addLeft(8, t.addLeft(7, r));
		t.addLeft(6, eight);
		t.addRight(10,  eight);
		
		Position<Integer> nine = t.addRight(9, r);
		t.addLeft(3, nine);
		t.addRight(0, t.addRight(1, nine));
		
		System.out.println(t);
		System.out.println("Height: " + t.height());
		System.out.println("Depth of p1: " + t.depth(eight));
	}
}
