//Evaluation of infix expression
//Infix Expression is taken
//Infix Expression is converted in to post fix Expression
//Post fix is calculated
import java.util.Scanner;
class ExpressionEvaluation
{
	//Stack that storing all the operators
	char exp_stack[] = new char[20];
	int top = -1;
	
	double postfix_stack[] = new double[20];
	int top_pstack = -1;
	
	// Conversion of infix expression to post fix expression
	// takes infix expression as input
	// returns post fix expression
	public String infixToPostfix(String exp)
	{
		String postfix_exp = "";
		 
		for(int i = 0; i < exp.length(); i++)
		{
			char ch = exp.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*'|| ch == '/' || ch == '^')
			{
				int priority_scanned = priorityCheck(ch);
				
				//if the operator scanned is the very first operator scanned
				if(top == -1)
				{
					top++;
					exp_stack[top] = ch;
				}
				else
				{
					
					for(int j = top; j >= 0; j--)
					{
						if(priority_scanned <= priorityCheck(exp_stack[j]))
						{
							postfix_exp = postfix_exp + exp_stack[j];
							stack_pop();
						}
						else
						{
							break;
						}
					}
					
					//push the scanned operator in to the stack
					stack_push(ch);
				}
			}
			//if ( appear in the expression, simply push that in to the stack
			else if(ch == '(' )
			{
				stack_push(ch);
			}
			//if ) appear in the stack, then we append all the operators up to ( to the post fix expression
			else if(ch == ')' )
			{
				for(int k = top; k >= 0; k--)
				{
					if( exp_stack[k] == '(' )
					{
						stack_pop();
						break;
					}
					else
					{
						postfix_exp = postfix_exp + exp_stack[k];
						stack_pop();
					}
				}
			}
			else
			{
				postfix_exp = postfix_exp + ch;
			}
		}
		if(!stack_isEmpty())
		{
			for(int l = top; l >= 0; l--)
			{
				postfix_exp = postfix_exp + exp_stack[l];
				stack_pop();
			}
		}
		return postfix_exp;
	}
	
	//Checks whether the stack is empty or not
	//return true if stack is empty else return false
	public boolean stack_isEmpty()
	{
		if(top == -1)
			return true;
		else
			return false;
	}
	// push (insert) element in to the stack
	public void stack_push(char ch)
	{
		top++;
		exp_stack[top] = ch;
	}
	
	// pops(deletes ) the top element in the stack
	public void stack_pop()
	{
		top--;
	}
	public int priorityCheck(char ch)
	{
		if(ch == '+' || ch == '-')
		{
			return 2;
		}
		else if(ch == '*' || ch == '/')
		{
			return 3;
		}
		else if(ch == '^')
		{
			return 4;
		}
		else
		{
			return 0;
		}
	}
	
	public double postfix_calc(String postfix_exp)
	{
		for(int m = 0; m < postfix_exp.length(); m++)
		{
			char ch = postfix_exp.charAt(m);
			if(ch == '+' || ch == '-' || ch == '*'|| ch == '/' || ch == '^')
			{
				double op2 = postfix_stack[top_pstack];
				double op1 = postfix_stack[top_pstack-1];
				top_pstack = top_pstack - 2;
				switch(ch)
				{
				case '+':
					postfix_stack_push(op1 + op2);
					break;
				case '-':
					postfix_stack_push(op1 - op2);
					break;
				case '*':
					postfix_stack_push(op1 * op2);
					break;
				case '/':
					postfix_stack_push(op1 / op2);
					break;
				case '^':
					postfix_stack_push(Math.pow(op1,op2));
					break;
				}
			}
			else
			{
				int vals = Character.getNumericValue(ch);
				postfix_stack_push(vals);
			}
		}
		return postfix_stack[0];
	}
	
	public void postfix_stack_push(double data)
	{
		if(top_pstack == -1)
		{
			top_pstack = 0;
			postfix_stack[top_pstack] = data;
		}
		else
		{
			top_pstack++;
			postfix_stack[top_pstack] = data;
		}
		
	}
	public static void main(String args[])
	{
		ExpressionEvaluation ee = new ExpressionEvaluation();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Infix expression to calculate");
		String exp = sc.nextLine();
		String postfix_exp = ee.infixToPostfix(exp);
		
		System.out.println(postfix_exp);
		
		double val = ee.postfix_calc(postfix_exp);
		System.out.println("value for expression is "+val);
	}
}
