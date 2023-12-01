package lab15;

public class Lab15Driver
{

	public static void main(String[] args)
	{
		double i = 6;
		int n = 5;
		int result;
		
		System.out.println(((3*n)+5) + " % 11 = " + (result = ((3*n)+5)%11));
		System.out.println((result+(i*(7-(result%7))))%11);
		
	}

}
