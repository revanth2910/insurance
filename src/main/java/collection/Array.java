package collection;

public class Array {

	public static void main(String[] args) {
		
		Object a[] = new Object [5];
		
		// Object a[] = {true, 10, 10.95, "Radhe", "A"};	// we can add n number of values there is no limit 
		
		a[0] = 10;
		a[1] = 10.85;
		a[2] = "RRR";
		a[3] = true;
		a[4] = "A";
		
		System.out.println(a.length);
		
		for(Object i:a)
		{
			System.out.println(i);
		}
	}

}
