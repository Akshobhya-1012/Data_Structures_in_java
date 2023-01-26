package com.stack;

/*Q1. WAP to create stack.
Write push, pop, peek, isEmpty and isFull functions

Create a tester class with main method to use above functions.
*/
public class StackChar
{
	private char[] ch;
	private int top,size;
	
	public StackChar() {
		super();
		top=-1;
		size=10;
		ch=new char[size];
		
	}

	public StackChar(char s) {
		super();
		ch=new char[s];
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
	
	public void push(char c)
	{
		if(isFull())
			System.out.println("Stack is full");
		else
		{
			top=top+1;
			ch[top]=c;
		}	
	}
	
	public char pop() throws OperatorException 
	{
		if(isEmpty())
			throw new OperatorException("Stack is Empty");	
		else
		{
			char temp=ch[top];
			top=top-1;
			return temp;
			
		}
	}
		
		public char peek() throws OperatorException
		{
			if(isEmpty())
				throw new OperatorException("Stack is Empty");	
			else
			{
				return ch[top];
			}
		}
		
	}
	
	
	
	
	