//Implementation of the Stack using array in Java

import java.util.Scanner;
class StackOperations
{
	int stack_arr[];
	int top = -1;
	
	//Checks whether the stack is empty or not
	//return true if stack is empty else false
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Checks whether the stack is full or not
	//return true if stack is full else false
	public boolean isFull()
	{
		if(top == (stack_arr.length-1) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Implement the insertion of element in to the stack ( Simply push operation)
	public void push(int val)
	{
		top++;
		stack_arr[top] = val;
	    display();
	}
	
	//Implement the delete operation ( Simply pop operation )
	public void pop()
	{
        System.out.println(stack_arr[top]+" deleted successfuly");
		top--;
	    display();
	}
	
	//Displays all the elements in the stack
	public void display()
	{
		if(isEmpty())
			System.out.println("No more elements in stack to display");
		else
		{
			for(int i = top;i != -1; i--)
			{
				System.out.println("|"+stack_arr[i]+"|");
				System.out.println("----");
			}
		}
	}
}
class StackImplementationArray
{
	public static void main(String args[])
	{
		StackOperations so = new StackOperations();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		int size_array = sc.nextInt();
		
		so.stack_arr = new int[size_array];
		
		int loop = 1;
		while(loop == 1)
		{
			
			System.out.println("Enter your choice");
			System.out.println(" 1 : push \n 2 : display \n 3 : pop \n 4 : exit");
			
			int ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				
				if(so.isFull())
					System.out.println("Stack is full, impossible add new elements");
				else
				{
					System.out.println("Enter the value to push");
					int val = sc.nextInt();
					so.push(val);
				}
				
			break;
			
			case 2:
				
			so.display();
			
			break;
			
			case 3:
				
				if(so.isEmpty())
					System.out.println("No more elements in the stack to delete");
				else
					so.pop();
				
			break;
			
			case 4:
			
			System.out.println("exit");
			loop = 0;
			
			break;
			
			default:System.out.println("ypou have entered a wrong choice");
			
			}
			
		}
	}
}