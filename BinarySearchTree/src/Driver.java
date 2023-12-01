
public class Driver 
{
	public static void main(String[] args)
	{
		BST<Integer> tree = new BST<>();
		
		for(int i=0; i < 20; i++)
		{
			tree.add((int)(Math.random() * 1000));
		}
		
		for(Integer i : tree)
		{
			System.out.print(i +" ");
		}
	}

}
