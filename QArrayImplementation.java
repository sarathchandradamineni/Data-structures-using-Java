//Implementation of Queue using Arrays in Java
import java.util.Scanner;
class QArrayImplementation
{
	int Qarr[];
	int rear = -1;
	int front = -1;
	Scanner sc;
	
	public void insertion()
	{
		if(rear == front && front == -1)
		{
			front++;
		}
		rear++;
		
		System.out.println("enter the value to insert");
		int val = sc.nextInt();
		Qarr[rear] = val;
		
		display();
	}
	
	public void deletion()
	{
		System.out.println(Qarr[front]+" is deleted successfully");
		front++;
		
		display();
	}
	
	public void display()
	{
		for(int i = front; i <= rear; i++)
		{
			System.out.println("|"+Qarr[i]+"|");
			System.out.println("----");
		}
	}
	
	public boolean isEmpty()
	{
		if(front == rear+1)
			return true;
		else if(front == rear && front == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull()
	{
		if(rear == Qarr.length-1)
			return true;
		else
			return false;
	}
	
	
	public static void main(String args[])
	{
		QArrayImplementation qai = new QArrayImplementation();
		
		qai.sc = new Scanner(System.in);
		
		System.out.println("enter the size of the queue");
		int size = qai.sc.nextInt();
		qai.Qarr = new int[size];
		
		
		int loop = 1;
		while(loop == 1)
		{
			System.out.println("Enter your choice");
			System.out.println("1 : Insertion\n2 : Display\n3 : Deletion\n4 : exit");
			int ch = qai.sc.nextInt();
			
			switch(ch)
			{
			case 1:
				if(qai.isFull())
				{
					System.out.println("Queue is full, it is impossible add new values");
				}
				else
				{
					qai.insertion();
				}
				
				break;
			case 2:
				
				if(qai.isEmpty())
				{
					System.out.println("There are no elements to display");
				}
				else
				{
					qai.display();
				}
				
				break;
			case 3:
				
				if(qai.isEmpty())
				{
					System.out.println("Queue is empty, it is impossible delete the values");
				}
				else
				{
					qai.deletion();
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
		
		qai.sc.close();
	}
}