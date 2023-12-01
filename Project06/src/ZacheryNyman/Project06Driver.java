package ZacheryNyman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Project06Driver
{
	private static long start, end;
	
	public static <E> void main(String[] args)
	{
		UnionFindForest unionForest = new UnionFindForest();
		ZachImplementation<E> zach = new ZachImplementation<>();
		
		/*
		unionForest = groupStudents(unionForest);
		
		System.out.println("Union find forest:");
		//System.out.println("\nGroup representatives: " + unionForest.getGroupLeaders() + "\nGroups size: " + unionForest.getNumberOfGroups());
		//System.out.println(unionForest + "\nForest size: " + unionForest.getSize());
		
		System.out.println("The groups are:\n" + unionForest.getMembers());
		System.out.println("There are " + unionForest.getMembersSize() + " groups.");
		
		/*
		
		zach = groupStudents(zach);
		
		System.out.println("\nPersonal Implementation:");
		//System.out.println(zach + "\nZach size: " + zach.getSize());
		System.out.println("The groups are:\n" + zach.getMembers());
		System.out.println("There are " + zach.getMembersSize() + " groups.");
		*/
		
		unionForest = integerGroupStudents(unionForest);
		
		System.out.println("Union find forest:");
		//System.out.println("\nGroup representatives: " + unionForest.getGroupLeaders() + "\nGroups size: " + unionForest.getNumberOfGroups());
		//System.out.println(unionForest + "\nForest size: " + unionForest.getSize());
		
		System.out.println("The groups are:\n" + unionForest.getMembers());
		System.out.println("There is " + unionForest.getMembersSize() + " group.\n");
		
		zach = integerGroupStudents(zach);
		
		System.out.println("Personal Implementation:");
		//System.out.println(zach + "\nZach size: " + zach.getSize());
		System.out.println("The groups are:\n" + zach.getMembers());
		System.out.println("There is " + zach.getMembersSize() + " group.");
		
	}
	
	public static <T extends GroupPartition<E>, E> T groupStudents(T dataStructure)
	{
		Scanner inFile;
		String a, b;
		int numStudents;
		
		try
		{
			inFile = new Scanner(new FileInputStream("sampleInput.txt"));
			numStudents = inFile.nextInt();
			
			for(int i = 0; i < numStudents; i++)
			{
				dataStructure.createGroup((E)inFile.next());
			}
			
			while(inFile.hasNext())
			{
				a = inFile.next();
				a = a.substring(0, a.length()-1);
				b = inFile.next();
				dataStructure.combineGroup((E)a, (E)b);
			}
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found");
			System.exit(0);
		}
		return dataStructure;
	}
	
	public static <T extends GroupPartition<E>, E> T integerGroupStudents(T dataStructure)
	{
		int n = (int) Math.pow(2, 11);
		Integer even = 2;
		ArrayList<Integer> list = new ArrayList<>(n);
		for(Integer i = 0; i < n; i++)
		{
			list.add(i);
		}
		
		start = System.currentTimeMillis();
		for(Integer integer : list)
		{
			dataStructure.createGroup((E)integer);
		}
		int counter = 1;
		Integer power = (Integer)(int) Math.pow(2, counter);
		do
		{
			for(Integer i = 0; i < n; i += power)
			{
				dataStructure.combineGroup((E)i, (E)(Integer)(i+(power/2)));
			}
			counter++;
			power = (Integer)(int) Math.pow(2, counter);
		}while(power <= n);
		
		end = System.currentTimeMillis();
		System.out.println(n + " , " + (end - start));
		
		return dataStructure;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
