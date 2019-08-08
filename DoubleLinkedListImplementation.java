//Implementation of doubly linked list in java
import java.util.Scanner;
class DoubleLinkedListImplementation
{
	//Creating the head object that points the initial node
	Node head;
	Scanner sc;
	static class Node
	{
		Node prev;
		int data;
		Node next;
		
		//constructor to initialize the values
		Node(int data)
		{
		prev = null;
		this.data = data;
		next = null;
		}
	}
	
	//Creation of Doubly Linked List 
	public void creation(DoubleLinkedListImplementation dlli)
	{
		//Taking input of number of nodes to be present in linked list while creation
		System.out.println("please enter number of nodes to create the Doubly Linked List");
		int num_of_nodes = sc.nextInt();
		
		//Creation of the first node
		System.out.println("Enter the value for the node 1");
		int val = sc.nextInt();
		DoubleLinkedListImplementation.Node first_node = new DoubleLinkedListImplementation.Node(val);
		dlli.head = first_node;
		
		//Creation of remaining all nodes
		for(int i = 0; i < num_of_nodes-1; i++)
		{
			System.out.println("enter the value for the "+(i+2)+" node");
			val = sc.nextInt();
			DoubleLinkedListImplementation.Node node_2 = new DoubleLinkedListImplementation.Node(val);
			DoubleLinkedListImplementation.Node p;
			
			//Making p referring to the last node 
			p = dlli.head;
			while(p.next != null)
			{
				p = p.next;
			}
			
			//Assigning the new node at last position
			p.next = node_2;
			node_2.prev = p;
		}
		
	}
	
	
	//Insertion of the new nodes at various positions
	public void insertion(DoubleLinkedListImplementation dlli)
	{
		int loop = 1;
		while(loop == 1)
		{

			System.out.println("Enter your choice");
			System.out.println("1:Insertion at begining\n2:Insertion at the end\n3:Insertion after the node\n4:Insertion before the node\n5:exit");
			int ch = sc.nextInt();	
			
			switch(ch)
			{
			
			case 1:				
				System.out.println("enter data to insert in to linked list");
				int val = sc.nextInt();
				
				DoubleLinkedListImplementation.Node node = new DoubleLinkedListImplementation.Node(val);
				
				node.next = dlli.head;
				dlli.head.prev = node;
				dlli.head = node;
				display(dlli);
				break;
				
			case 2:
				if(dlli.head == null)
				{
					System.out.println("There are no nodes in linked list");
				}
				else
				{
					System.out.println("enter data to insert in to linked list");
					int val_2 = sc.nextInt();
					
					DoubleLinkedListImplementation.Node node_2 = new DoubleLinkedListImplementation.Node(val_2);
					
					//Referring to the last node
					DoubleLinkedListImplementation.Node p = dlli.head;
					while(p.next != null)
					{
						p = p.next;
					}
					
					p.next = node_2;
					node_2.prev = p;
					
					display(dlli);
				}
				break;
				
			case 3:
				System.out.println("enter the node to which new node will be inserted after that");
				int key = sc.nextInt();
				DoubleLinkedListImplementation.Node p = dlli.head;
				
				//Referencing to the key node
				while(p != null)
				{
					if(p.data == key)
						break;
					else
						p = p.next;
				}
				
				//If key is not found if will execute 
				if(p == null)
					System.out.println(key+" is not found in the linked list");
				else
				{
					System.out.println("enter data to insert in to linked list");
					int val_3 = sc.nextInt();
					
					DoubleLinkedListImplementation.Node node_3 = new DoubleLinkedListImplementation.Node(val_3);
					
					//if the key node is last node
					if(p.next == null)
					{
						node_3.prev = p;
						p.next = node_3;
					}
					//if the key node is the node,other than that of the last node
					else
					{
						node_3.next = p.next;
						node_3.prev = p;
						p.next.prev =node_3;
						p.next = node_3;	
					}
					display(dlli);
				}
				break;
				
			case 4:
				//System.out.println("Insertion before the node");
				System.out.println("enter the node to which new node will be inserted before that");
				int key_2 = sc.nextInt();
				
				DoubleLinkedListImplementation.Node p_1 = dlli.head;
				//referring to the node with key data
				 while(p_1 != null)
				 {
					 if(p_1.data == key_2)
						 break;
					 p_1 = p_1.next;
				 }
					 
				 if(p_1 == null)
				 {
					 System.out.println(key_2+" is not present in the linked list");
				 }
				 else
				 {
					System.out.println("enter data to insert in to linked list");
					int val_4 = sc.nextInt();
						
					DoubleLinkedListImplementation.Node node_4 = new DoubleLinkedListImplementation.Node(val_4);
					 if(p_1 == dlli.head)
					 {
						 node_4.next = p_1;
						 p_1.prev = node_4;
						 dlli.head = node_4;
					 }
					 else
					 {
						 node_4.next = p_1;
						 node_4.prev = p_1.prev;
						 p_1.prev.next = node_4;
						 p_1.prev = node_4;		 
					 }
					 display(dlli);
				 }
				break;
				
			case 5:
				loop = 0;
				System.out.println("exit from the insertion");
				break;
				
			default:
				System.out.println("you have entered a wrong choice please try again");
			}
		}
		//System.out.println("inserting a new node");
	}
	
	
	public void deletion(DoubleLinkedListImplementation dlli)
	{
		System.out.println("Enter the value of node to be deleted");
		int del_ele = sc.nextInt();
		
		DoubleLinkedListImplementation.Node del_node = dlli.head;
		
		if(dlli.head == null)
		{
			System.out.println("Linked List is empty so  there are no elements to delete");
		}
		else
		{
			//Referring to node with value to be deleted
			while(del_node != null)
			{
				if(del_node.data == del_ele)
					break;
				del_node = del_node.next;
			}
			
		}
		//if element was not found in the linked list
		if(del_node == null)
			System.out.println("there is no such "+del_ele+" in linked list");
		else
		{
			//if the node to be deleted is the first node
			if(del_node == dlli.head)
			{
				if(del_node.next == null)
				{
					dlli.head = null;
				}
				else
				{
					dlli.head = del_node.next;
					del_node.next.prev = null;
				}	
			}
			//if the node to be deleted is last node
			else if(del_node.next == null)
			{
				del_node.prev.next = null;
				del_node.prev = null;
			}
			//Code for deletion of remaining nodes other than first and last nodes
			else
			{
				del_node.prev.next = del_node.next;
				del_node.next.prev = del_node.prev;
			}
			display(dlli);
			if(dlli.head == null)
			{
				System.out.println("There are no remianing elements in the linked list so create a new linked list");
				creation(dlli);
			}
		}
				
	}
	
	
	public void display(DoubleLinkedListImplementation dlli)
	{
		if(dlli.head == null)
		{
			System.out.println("there are no nodes in the linked list to display");
		}
		else
		{
			// Display the values in forward direction
			System.out.println("forward display");
			DoubleLinkedListImplementation.Node p = dlli.head;
			
			while(p!= null)
			{
				System.out.print(p.data+" --> ");
				p = p.next;
			}
			
			System.out.println("\n");
			System.out.println("backward display");
			// Display the values in Backward direction
			p = dlli.head;
			// Referencing to the last node
			while(p.next != null)
			{
				p = p.next;
			}
			//Printing values in reverse order
			while(p != null)
			{
				System.out.print(p.data+" <-- ");
				p=p.prev;
			}
			System.out.println("\n");
		}
	}
	
	
	public static void main(String args[])
	{
		DoubleLinkedListImplementation dlli = new DoubleLinkedListImplementation();
		dlli.sc = new Scanner(System.in);
		
		//Creation of linked list takes place first
		dlli.creation(dlli);
		
		int loop =1;
		while(loop == 1)
		{
			System.out.println("Double Linked List Implementation");
			System.out.println("Enter your  choice");
			System.out.println("1:Insert new node\n2:Deletion of the node\n3:Display\n4:exit");
			
			int ch = dlli.sc.nextInt();
			
			switch(ch)
			{
			
				case 1:
				dlli.insertion(dlli);
				break;
				
				case 2:
				dlli.deletion(dlli);
				break;
				
				case 3:
				dlli.display(dlli);
				break;
				
				case 4:loop = 0;
				System.out.println("Exit");
				break;
				
				default:
				System.out.println("You have entered a wrong choice please try again");
			}
		}
	}
}