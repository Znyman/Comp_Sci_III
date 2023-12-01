
public class StringBuilderExample
{
	
	public static String appendString(int n)
	{
		String r = "";
		for(int i = 0; i < n; i++)
		{
			r += '*';
		}
		return r;
	}
	
	public static String buildString(int n)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			sb.append('*');
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		for(int n = 1000; n < 200000; n += 1000)
		{
			long start = System.currentTimeMillis();
			StringBuilderExample.appendString(n);
			long end = System.currentTimeMillis();
			
			long start2 = System.nanoTime();
			StringBuilderExample.buildString(n);
			long end2 = System.nanoTime();
			
			System.out.println(n + " , " + (end - start) + " , " + (end2 - start2)/1000000.0);
		}
	}
	
}
