//Implementation of the stack using linked list in java

import java.util.Scanner;
class StackImplementationLinkedList
{
	Scanner sc;
	Node top;
	
	//Static class which represents the node structure
	public static class Node
	{
		public int data;
		public Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	//Insert a new element in to a stack 
	//this is same as insert a new node in to the linked list at beginning
	public void push()
	{
		System.out.println("Enter a value to insert in to the stack");
		int val = sc.nextInt();
		
		StackImplementationLinkedList.Node node = new StackImplementationLinkedList.Node(val);
		//if the node is the first node
		if(top == null)
		{
			top = node;
		}
		else   //Code for remaining nodes other than first node
		{
			node.next = top;
			top = node;
		}
		
		display();
	}
	
	//deletion of elements from the stack
	//this is same as deletion of first node from the linked list
	public void pop()
	{
		StackImplementationLinkedList.Node del_node = top;
		System.out.println(del_node.data+" is deletd successfuly");
		top = top.next;
		display();
	}
	
	//to display all the elements in the stack
	public void display()
	{
		StackImplementationLinkedList.Node disp_node = top;
		
		while(disp_node != null)
		{
			System.out.println("|"+disp_node.data+"|");
			System.out.println("----");
			disp_node = disp_node.next;
		}
		
	}
	public static void main(String args[])
	{
		StackImplementationLinkedList sill = new StackImplementationLinkedList();
		sill.sc = new Scanner(System.in);
		
		int loop = 1;
		
		while(loop == 1)
		{
			System.out.println("Enter your option");
			System.out.println(" 1 : push \n 2 : display \n 3 : pop\n 4 : exit");
			int ch = sill.sc.nextInt();
			
			switch(ch)
			{
			case 1:
				//to add new element in to stack
				sill.push();
				break;
			case 2:
				//to display all the values in the linked list (stack)
				sill.display();
				break;
			case 3:
				//to pop the first element in the stack 
				sill.pop();
				break;
			case 4:
				//to break the continuous loop
				loop = 0;
				break;
			default:
				System.out.println("You have entered a wrong option please try again");
			}
		}
	}
}