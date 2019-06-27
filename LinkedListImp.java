import java.util.*;

class LinkedListImp
{
	Node head;
	static class Node
	{
		int data;
		Node link;
		
		Node(int d)
		{
			data = d;
			link = null;
		}	
	}
	
	//Insert a new node to the linked list at various positions
	public LinkedListImp insertNode(LinkedListImp lli,int a)
	{
		Node new_node = new Node(a);
		new_node.link = null;
		Node p;
		
		System.out.println("please enter your choice");
		System.out.println("1:insert new node at end\n2:insert after particular node\n3:insert before particular node");
		System.out.println("4:insert at particular position");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		switch(ch)
		{
		//insert at the end
		case 1:
		
		//if it is first node if will execute so head will be initialized to the first node
		if(lli.head == null)
		{
			lli.head = new_node;
		}
		
		//Add the new node at last
		else
		{
            p = lli.head;
			
            while(p.link != null)
            {
				p = p.link;
            }		
			
			p.link = new_node;
		}
		
        break;
		
		//Insert after a particular node
        case 2:
		System.out.println("insert after particular node");
		System.out.println("enter the number, after which you want to add a node");
		
		int num = sc.nextInt();
		p = lli.head;
		
		while(p!= null)
		{
			if(p.data == num)
			{
				break;
			}
			
			p = p.link;
		}
		
		if(p == null)
		{
			System.out.println("Number you entered is not present in the linked list");
		}
		else
		{
		new_node.link = p.link;
		p.link = new_node;
		}
		
        break;
		
		//Insert before a particular Node 
        case 3:
		
		System.out.println("insert before particular node");
		System.out.println("enter the number, before which you want to add a node");
		num = sc.nextInt();
		
		p = lli.head;
		
		//check if the node is first
		if(num == p.data)
		{
			new_node.link = p;
			lli.head = new_node;
		}
		else
		{
		    while(p.link != null)
		    {
			    if(p.link.data == num)
				    break;
			    p = p.link;
		    }
		    if(p.link == null)
			    System.out.println("Number you entered is not present in the linked list");
		    else
		    {
			    new_node.link = p.link;
			    p.link = new_node;
		    }
		}
        break;
		
		//Insert at particular position
        case 4:
		
		// if linked list is empty then node will be inserted at the first position
		if(lli.head == null)
		{
			System.out.println("As the linked list is empty the node will be added at the first position");
			lli.head = new_node;
		}
		//if linked list contain some nodes previously
		else
	    {
		    System.out.println("enter the position to insert node");
		    int pos = sc.nextInt();
			p = lli.head;
			
			//count number of nodes in the linked list
			int count_noofnodes = 0;
			while(p != null)
			{
				count_noofnodes++;
				p = p.link;
			}
			
			p = lli.head;//Make always reference variable refer to the first node
			
			//if node to be added at first position
			if(pos == 1)
			{
				new_node.link = p;
				lli.head = new_node;
			}
			//if node to be added at positions other than first and last
			else if(pos <= count_noofnodes)
			{
                for(int i = 0; i < (pos-2); i++)
                {
					p = p.link;
				}					
				new_node.link = p.link;
				p.link = new_node;
			}
			//if node to be addded at last position
			else if(pos == (count_noofnodes+1))
			{
				while(p.link != null)
				{
					p = p.link;
				}
				p.link = new_node;
			}
			//if position other than positions present in the linked list is given
			else
			{
				System.out.println("You have entered a unknown position");
			}
				
			
		}
		break;
			
        default:System.out.println("You have entered wrong choice");		
		
		}
	return lli;
	}
	
	//Delete a node from the linked list
	public LinkedListImp deleteNode(LinkedListImp lli, int del_ele)
	{
		Node p = lli.head;
		
		//If no nodes  are present
		if(p == null)
		{
			System.out.println("There are no elements in the linked list");
		}
		else
		{
			//if only one node is present
			if(p.link == null)
			{
				lli.head = null;
			}
			// Deletion of first node,last node and other nodes
			else
			{
				//Deletion of first element
				if(p.data == del_ele)
				{
					p = p.link;
					lli.head = p;
				}
				else
				{
		            while(p.link != null)
		            {
			            if(p.link.data == del_ele)
					    {
						    //Checking condition for last node
						    if(p.link.link == null)
						    {
								//deleting last node
							    p.link = null;
								break;
						    }
						    else
						    {
								//deleting remaining nodes
				                p.link = p.link.link;
						    }
					    }
			        p = p.link;
		            }
				}
			}
		}
        lli.displayLinkedList(lli);		
		return lli;
	}
	
	//Display the Linked List items
	public void displayLinkedList(LinkedListImp lli)
	{
		Node p = lli.head;
		
		while(p != null)
		{
			System.out.print(p.data+"-->");
			p = p.link;
		}
		
		System.out.println("\n");
	}
	
	
	public static void main(String args[])
	{
		
		int loop = 1;
        Scanner sc  = new Scanner(System.in);
		LinkedListImp lli = new LinkedListImp();
		
		
		while(loop == 1)
		{
		System.out.println("enter your choice");
		System.out.println("1 : Insert a new node\n2 : Display  \n3 : Delete node\n4 : exit");
		int ch = sc.nextInt();
		
            switch(ch)
            {
				
			case 1:
			System.out.println("Enter number");
		    int a = sc.nextInt();
			lli = lli.insertNode(lli,a);
			break;
			
			case 2:
			System.out.println("Display");
			lli.displayLinkedList(lli);
			break;
			
			case 3: 
			System.out.println("Delete a new node");
			System.out.println("enter a element to delete");
			int del_ele = sc.nextInt();
			
			lli = lli.deleteNode(lli,del_ele);
			
			break;
			
			case 4: System.out.println("exit");
		    loop = 0;
			break;
			
			default : System.out.println("you have entered a wrong choice");
            }
        }		
	}
}	