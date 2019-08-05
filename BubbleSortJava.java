import java.util.Scanner;
class BubbleSortJava
{
	//bubble sort method, which implements the sort
	public void bubbleSortMethod(int arr[])
	{		
		int size_array = arr.length;
		
		//bubble sort core logic
		for(int i = 0; i < (size_array-1); i++)
		{
			for(int j = 0;j < (size_array-i-1); j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//So finally printing the sorted array
		System.out.println("Sorted array using the bubble sort logic is");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
	}
	public static void main(String args[])
	{
		BubbleSortJava bsj = new BubbleSortJava();
		
		Scanner sc = new Scanner(System.in);
		int arr[];
		
		//Taking the size of the array
		System.out.println("Enter the size of the array");	
		int size_array = sc.nextInt();
		arr = new int[size_array];
		
		//Taking the array elements input
		System.out.println("enter the elements of the array");
		for(int i = 0; i < size_array;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		//Printing array elements 
		System.out.println("So the array is ");
		for(int i = 0; i < size_array; i++)
		{
			System.out.println(arr[i]);
		}
		
		//calling bubble sort function which implements the logic
		bsj.bubbleSortMethod(arr);
	}
}