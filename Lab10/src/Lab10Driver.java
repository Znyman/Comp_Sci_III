/** Lab10
 * @author Zachery Nyman
 * 08 May 2017
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab10Driver {

	public static void main(String[] args)
	{
		ArraySet<String> girlNameSet = new ArraySet<>();
		ArraySet<String> boyNameSet = new ArraySet<>();
		ArraySet<String> commonNameSet = new ArraySet<>();
		String filename = "girlnames.txt";
		Scanner inFile = null;
		String name;
		try
		{
			inFile = new Scanner(new FileInputStream(filename));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot open file: " + filename);
			System.exit(0);
		}
		for(int i = 0; i < 1000; i++)
		{
			girlNameSet.add(inFile.next());
			inFile.next();
		}
		//System.err.println(girlNameSet);
		
		filename = "boynames.txt";
		inFile = null;
		try
		{
			inFile = new Scanner(new FileInputStream(filename));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot open file: " + filename);
			System.exit(0);
		}
		for(int i = 0; i < 1000; i++)
		{
			name = inFile.next();
			boyNameSet.add(name);
			if(girlNameSet.contains(name))
			{
				commonNameSet.add(name);
			}
			inFile.next();
		}
		//System.err.println(boyNameSet);
		//System.err.println(boyNameSet.size());
		//System.err.println(girlNameSet.size());
		System.out.println("The size of the common name set is: " + commonNameSet.size());
		System.out.println(commonNameSet);
		
	}

}
