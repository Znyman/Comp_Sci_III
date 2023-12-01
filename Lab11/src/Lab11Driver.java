import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab11Driver 
{
	public static void main(String[] args)
	{
		long start, end;
		BST<Integer> treeSetInt = new BST<>();
		BST<String> treeSetString = new BST<>();
		
		for(int n = 1000; n <= 16000; n *= 2)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				treeSetInt.add((int)(i+1));
			}
			end = System.currentTimeMillis();
			System.out.println("In order: " + n + " , " + (end - start));
			
			treeSetInt.removeAll(treeSetInt);
			
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				treeSetInt.add((int)(Math.random() * 1000));
			}
			end = System.currentTimeMillis();
			System.out.println("Random: " + n + " , " + (end - start));
			
		}
		
		String filename = "SortedWordList.txt";
		Scanner inFile = null;
		
		try
		{
			inFile = new Scanner(new FileInputStream(filename));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot open file: " + filename);
			System.exit(0);
		}
		
		start = System.currentTimeMillis();
		while(inFile.hasNext())
		{
			treeSetString.add(inFile.next());
		}
		end = System.currentTimeMillis();
		System.out.println("Sorted word list: " + (end - start));
		
		filename = "WarAndPeace.txt";
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
		
		start = System.currentTimeMillis();
		while(inFile.hasNext())
		{
			treeSetString.add(inFile.next());
		}
		end = System.currentTimeMillis();
		System.out.println("War and Peace: " + (end - start));
		
		
		
		
		
		
		
		
		
		
	}
}
