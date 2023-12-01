/**
 * Lab09
 * @author Zachery Nyman
 * 05 May 2017
 */
public class Lab09Driver {

	/*
	 *             5
	 *            /\
	 *           7  9
	 *          /   /\
	 *         8    3 1
	 *        /\       \
	 *        6  10     0
	 * BinaryTree<Integer> t = new BinaryTree<>();
		
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
	 */
	public static void main(String[] args)
	{
		BinaryTree<Character> t = new BinaryTree<>();
		
		Position<Character> divider = t.addRoot('/');
		Position<Character> multiplier = t.addLeft('*', divider);
		Position<Character> adderLeft = t.addLeft('+', multiplier);
		t.addRight('4', multiplier);
		t.addLeft('3', adderLeft);
		t.addRight('1', adderLeft);
		Position<Character> adderRight = t.addRight('+', divider);
		Position<Character> subtractor = t.addLeft('-', adderRight);
		t.addRight('2', adderRight);
		t.addLeft('9', subtractor);
		t.addRight('5', subtractor);
		
		printExpression(t, divider);
		System.out.println();
		System.out.println(evaluateExpression(t, divider));
	}
	
	public static void printExpression(BinaryTree<Character> t, Position<Character> p)
	{
		if(t.left(p) != null)
		{
			System.out.print("(");
			printExpression(t, t.left(p));
		}
		System.out.print(p.getValue());
		
		if(t.right(p) != null)
		{
			printExpression(t, t.right(p));
			System.out.print(")");
		}
	}
	
	public static double evaluateExpression(BinaryTree<Character> t, Position<Character> p)
	{
		double x, y, result = 0;
		char op;
		
		if(t.left(p) == null && t.right(p) == null)
		{
			return Character.getNumericValue(p.getValue());
		}
		else
		{
			op = p.getValue();
			switch(op)
			{
			case '-':
				result = evaluateExpression(t, t.left(p)) - evaluateExpression(t, t.right(p));
				break;
			case '+':
				result = evaluateExpression(t, t.left(p)) + evaluateExpression(t, t.right(p));
				break;
			case '*':
				result = evaluateExpression(t, t.left(p)) * evaluateExpression(t, t.right(p));
				break;
			case '/':
				result = evaluateExpression(t, t.left(p)) / evaluateExpression(t, t.right(p));
				break;
			}
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
