/**
 * Project02
 * @author Zachery Nyman
 * 14 April 2017
 */
package project02;

import java.util.Arrays;
import java.util.Random;

public class PositiveNegativeSearchDriver {

	public static void main(String[] args) {
		
		long start, end;
		int value;
		Random randomNumber = new Random();
		
		System.out.println("Random scenario: ");
		System.out.println("Sequential Search: ");
		for(int n = 50000; n <= 800000; n *= 2)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)//initialize the array
			{
				value = randomNumber.nextInt();
				while(value == 0)
				{
					value = randomNumber.nextInt();
				}
				arr[i] = value;
			}
			Arrays.sort(arr);
			start = System.currentTimeMillis();
			PositiveNegativeSearch.sequentialSearch(arr);
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		System.out.println("Binary Search: ");
		for(int n = 50000; n <= 800000; n *= 2)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)//initialize the array
			{
				value = randomNumber.nextInt();
				while(value == 0)
				{
					value = randomNumber.nextInt();
				}
				arr[i] = value;
			}
			Arrays.sort(arr);
			start = System.currentTimeMillis();
			PositiveNegativeSearch.binarySearch(arr);
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		System.out.println("Sum Search: ");
		for(int n = 50000; n <= 800000; n *= 2)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)//initialize the array
			{
				value = randomNumber.nextInt();
				while(value == 0)
				{
					value = randomNumber.nextInt();
				}
				arr[i] = value;
			}
			Arrays.sort(arr);
			start = System.currentTimeMillis();
			PositiveNegativeSearch.sumSearch(arr);
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		System.out.println("Worst case scenario: ");
		System.out.println("Sequential Search: ");
		for(int n = 50000; n <= 800000; n *= 2)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)//initialize the array
			{
				arr[i] = 1;
			}
			Arrays.sort(arr);
			start = System.currentTimeMillis();
			PositiveNegativeSearch.sequentialSearch(arr);
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		System.out.println("Binary Search: ");
		for(int n = 50000; n <= 800000; n *= 2)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)//initialize the array
			{
				arr[i] = 1;
			}
			Arrays.sort(arr);
			start = System.currentTimeMillis();
			PositiveNegativeSearch.binarySearch(arr);
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		System.out.println("Sum Search: ");
		for(int n = 50000; n <= 800000; n *= 2)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)//initialize the array
			{
				arr[i] = 1;
			}
			Arrays.sort(arr);
			start = System.currentTimeMillis();
			PositiveNegativeSearch.sumSearch(arr);
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		
		
		
		
		
		
		
	}

}
