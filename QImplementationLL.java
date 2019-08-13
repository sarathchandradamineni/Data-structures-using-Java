//Implementation of queue using Linked List
// Operations are insert, delete, display
import java.util.Scanner;
class QImplementationLL
{
	Scanner sc;
	Node front;
	Node rear;
	
	static class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	// Insert new value in to the Queue from rear end
	public void insertion()
	{
		System.out.println("Enter value to insert in to queue");
		int data = sc.nextInt();
		
		QImplementationLL.Node node = new QImplementationLL.Node(data);
		
		if(rear == null)
		{
			rear = node;
			front = node;
		}
		else
		{
			rear.next = node;
			rear = node;
		}
		
		display();
	}
	
	// Deletes the value in the queue from front end
	public void deletion()
	{
		System.out.println(front.data+" is deleted successfuly");
		
		if(front == rear)
		{
			front = null;
			rear = null;
		}
		else
		{
			front = front.next;
		}
		display();
	}
	
	// Displays all the elements in the queue
	public void display()
	{
		QImplementationLL.Node node = front;
		
		while(node != null)
		{
			System.out.println("|"+node.data+"|");
			System.out.println("-----");
			node = node.next;
		}
	}
	
	// Checks if the queue is empty or not
	// returns true if the queue is empty else false
	public boolean isEmpty()
	{
		if(front == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String args[])
	{
		QImplementationLL qill = new QImplementationLL();
		
		qill.sc = new Scanner(System.in);
		int loop = 1;
		while(loop == 1)
		{
			
			System.out.println("Enter your choice");
			System.out.println("1 : Insertion\n2 : Display\n3 : Delete\n4 : exit");
			
			int ch = qill.sc.nextInt();
			
			switch(ch)
			{
			
			case 1:
				qill.insertion();
				break;
				
			case 2:
				
				//checks if it is there are any elements are there in the queue to display
				if(qill.isEmpty())
				{
					System.out.println("Queue is empty, no elements to display");
				}
				else
				{
					qill.display();
				}
				
				break;
			case 3:
				
				//checks if it is there are any elements are there or not to delete
				if(qill.isEmpty())
				{
					System.out.println("Queue is empty, it is impossible to delete");
				}
				else
				{
					qill.deletion();
				}
				
				break;
				
			case 4:
				System.out.println("exit");
				loop = 0;
				break;
				
			default:
				System.out.println("you have entered a wrong choice");

			}
		}
	}
}