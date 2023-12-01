
public class StackDriver 
{
	public static void main(String[] args)
	{
		Stack<Integer> s1 = new ArrayStack<>(10);
		
		for(int i=0; i < 10; i++)
		{
			s1.push(i);
			System.out.println(s1);
		}
		
		for(int i=0; i < 10; i++)
		{
			s1.pop();
			System.out.println(s1);
		}
		
	}

}
