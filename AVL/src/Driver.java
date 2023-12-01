
public class Driver 
{
	public static void main(String[] args)
	{
		AVL<Integer> tree = new AVL<>();
		
		for(int i=0; i < 2000; i++)
		{
			tree.add(i);
		}
		
		System.out.println(tree);
	}

}
