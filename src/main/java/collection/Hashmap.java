package collection;

import java.util.Scanner;

public class Hashmap {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
		int n;

		n= s.nextInt();
		
		int arr[]= new int[n]; 
		
		for(int i=0;i<n;i++)
		{
			arr[i] = s.nextInt();
		}
		
		int count[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
		 count[arr[i]]++;
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(count[i]);
		}
		
	}

}
