package com.stack;

/*Q1. WAP to create stack.
Write push, pop, peek, isEmpty and isFull functions

Create a tester class with main method to use above functions.
*/
public class StackOperator 
{
	private int[] ch;
	private int top,size;
	
	public StackOperator() {
		super();
		top=-1;
		size=10;
		ch=new int[size];
		
	}

	public StackOperator(int s) {
		super();
		ch=new int[s];
		top=-1;
	}
	
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	
	public boolean isFull()
	{
		if(top==(size-1))
			return true;
		else
			return false;
	}
	
	public void push(int c)
	{
		if(isFull())
			System.out.println("Stack is full");
		else
		{
			top=top+1;
			ch[top]=c;
		}	
	}
	
	public int pop() throws OperatorException 
	{
		if(isEmpty())
			throw new OperatorException("Stack is Empty");	
		else
		{
			int temp=ch[top];
			top=top-1;
			return temp;
			
		}
	}
		
		public int peek() throws OperatorException
		{
			if(isEmpty())
				throw new OperatorException("Stack is Empty");	
			else
			{
				return ch[top];
			}
		}
		
	}
	
	
	
	
	