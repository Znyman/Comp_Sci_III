
public class Driver {

	public static void main(String[] args) 
	{
		Map<Integer, Double> map = new HashMap<>();
		
		for(int i=0; i < 100000; i++)
		{
			map.put((int)(Math.random() * Integer.MAX_VALUE-1), Math.random());
		}
		
		System.out.println(map);
	}

}
