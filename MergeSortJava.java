import java.util.Scanner;
class MergeSortJava
{
	public void merge(int arr[],int l,int m,int r)
	{
		//setting the sizes of the two sub arrays
		int n1 = m-l+1;
		int n2 = r-m;
		
		int l_arr[] = new int[n1];
		int r_arr[] = new int[n2];
		
		for(int i = 0;i < n1; i++)
			l_arr[i] = arr[l+i];
		for(int j = 0;j < n2; j++)
			r_arr[j] = arr[m+1+j];
		
		int i =0,j=0,k=l;
		
		while(i<n1 && j<n2)
		{
			if(l_arr[i] <= r_arr[j])
			{
				arr[k] = l_arr[i];
				i++;
			}
			else
			{
				arr[k] = r_arr[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			arr[k] = l_arr[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			arr[k] = r_arr[j];
			j++;
			k++;
		}
		
		
		
		
	}
	public void sort(int arr[],int l,int r)
	{
		//find the middle element
		int m = (l+r)/2;
		
		if(l<r)
		{
			//making the arrays in to two halves
			sort(arr,l,m);
			sort(arr,m+1,r);
			
			//merge the divided arrays
			merge(arr,l,m,r);
		}
	}
	public static void main(String args[])
	{
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
		
		sc.close();
		
		MergeSortJava msj = new MergeSortJava();
		msj.sort(arr,0,arr.length-1);
		
		System.out.println("So the sorted array is");
		for(int i = 0; i < size_array; i++)
		{
			System.out.println(arr[i]);
		}
	}
}