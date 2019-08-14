//Implementation of Circular Queue
import java.util.Scanner;
class CircularQueue
{
	Scanner sc;
	int Q[];
	int front = -1,rear = -1;
	int size;
	
	//insert new values in to the circular Queue
	public void insertion()
	{		
		if(rear == size-1)
		{
			rear = 0;
			System.out.println("Enter value to insert in to Queue");
			int val = sc.nextInt();
			Q[rear] =  val;
		}
		
		else
		{
		//Insertion of the first element
		if(rear == front && front == -1)
		{
			front = 0;
		}
		
		System.out.println("Enter value to insert in to Queue");
		int val = sc.nextInt();
		rear++;
		Q[rear] =  val;
		}
		

		
		display();
	}
	
	//Deletion of elements in the Circular Queue
	public void deletion()
	{
		//Deletion of the only remaining element
		if(front == rear)
		{
			System.out.println(Q[front]+" is deleted successfully");
			front = -1;
			rear = -1;
		}
		//Deletion from the starting of the Array
		else if(front == size-1)
		{
			front = 0;
		}
		//deletion of remaining elements
		else
		{
			System.out.println(Q[front]+" is deleted successfully");
			front++;
		}
		display();
	}
	
	//Display all the elements in the Queue
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty, no elements to show");
		}
		else
		{
			int i = front;
			if(front <= rear)
			{
				while(i <= rear)
					System.out.println(Q[i++]);
			}
			else
			{
				while(i <= Q.length-1)
					System.out.println(Q[i++]);
				i = 0;
				while(i <= rear)
					System.out.println(Q[i++]);
			}
		}
	}
	
	//Returns true if Queue is empty
	//In Circular Queue if we delete the only remaining element then initialize rear and front to base condition ( = -1) 
	public boolean isEmpty()
	{
		if(front == -1)
			return true;
		else
			return false;
	}
	
	//Return true if the Queue is full else false 
	public boolean isFull()
	{
		if(front == rear+1)
		{
			return true;
		}
		else if(front == 0 && rear == size-1)
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
		CircularQueue cq = new CircularQueue();
		cq.sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		cq.size = cq.sc.nextInt();
		
		cq.Q = new int[cq.size];
		
		int loop = 1;
		
		while(loop == 1)
		{
			System.out.println("Enter your choice");
			System.out.println("1 : Insert\n2 : Display\n3 : Deletion\n4 : exit");
			
			int ch = cq.sc.nextInt();
			
			switch(ch)
			{
			case 1:
				
				if(cq.isFull())
				{
					System.out.println("Queue is full, it is not possible to add new elements");
				}
				else
				{
					cq.insertion();
				}
				break;
				
			case 2:
				cq.display();
				break;
			case 3:
				if(cq.isEmpty())
				{
					System.out.println("Queue is empty, it is impossible to delete");
				}
				else
				{
					cq.deletion();
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