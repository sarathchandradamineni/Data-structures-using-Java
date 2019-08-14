//Implementation of Queue using Circular Linked List
//Operations are insertion, deletion, display
import java.util.Scanner;
class QCircularLL
{
	Scanner sc;
	Node rear;
	
	public static class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	//Insert new element in to queue from rear end
	public void insertion()
	{
		System.out.println("Enter the value to insert in to the queue");
		int val = sc.nextInt();
		
		QCircularLL.Node node = new QCircularLL.Node(val);
		
		//if the node to be added is the first node
		if(rear == null)
		{
			rear = node;
			rear.next = rear;
		}
		//node is other than that of first node
		else
		{
			node.next = rear.next;
			rear.next = node;
			rear = node;
		}
		
		display();
	}
	
	//to display all the elements in the queue
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty, no elements to display");
		}
		else
		{
		QCircularLL.Node node = rear.next;
		
		do
		{
			System.out.println("|"+node.data+"|");
			System.out.println("-----");
			node = node.next;
		}while(node != rear.next);
		}
		
	}
	
	// To delete the first element in the queue i.e from front end
	public void deletion()
	{
		if(rear.next == rear)
		{
			rear = null;
		}
		else
		{
			rear.next = rear.next.next;
		}
		display();
	}
	
	public boolean isEmpty()
	{
		if(rear == null)
			return true;
		else
			return false;
	}
	public static void main(String args[])
	{
		QCircularLL qcll = new QCircularLL();
		qcll.sc = new Scanner(System.in);
		
		int loop = 1;
		while(loop == 1)
		{
			System.out.println("Enter your choice");
			System.out.println("1 : Insertion\n2 : Display\n3 : Delete\n4 : exit");
			
			int ch = qcll.sc.nextInt();
			
			switch(ch)
			{
			case 1:
				qcll.insertion();
				break;
			case 2:

					qcll.display();
				
				break;
			case 3:
				if(qcll.isEmpty())
				{
					System.out.println("There are no elements to delete in the queue");
				}
				else
				{
					qcll.deletion();
				}
				break;
			case 4:
				System.out.println("Exit");
				loop = 0;
				break;
			default:
				System.out.println("You have entered a wrong choice");
			}
		}
	}
}